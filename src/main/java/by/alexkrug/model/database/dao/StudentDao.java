package by.alexkrug.model.database.dao;

import by.alexkrug.model.database.connection.ConnectionManager;
import by.alexkrug.model.database.entity.users.Student;
import by.alexkrug.model.database.entity.enumtype.SysRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao implements IDao<Student, String> {
    public static StudentDao INSTANCE = new StudentDao();
    public Connection connection = ConnectionManager.getConnection();
    private final static String ADD = """
            INSERT INTO students(name, surname, password, login)
            VALUES (?, ?, ?, ?)
            """;

    private final static String GET = """
            SELECT * FROM students WHERE login = ?
            """;

    private final static String DELETE = """
            DELETE FROM students
            WHERE login = ?
            """;


    private final static String UPDATE = """
             UPDATE students
             SET \s
                 name = ?,
                 surname = ?,
                 password = ?
             WHERE login = ?
            \s""";

    private final static String GETALL = """
            SELECT * FROM students
            """;

    private StudentDao() {
    }

    @Override
    public Student add(Student student) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setObject(3, student.getPassword());
            preparedStatement.setString(4, student.getLogin());
            preparedStatement.execute();
            return student;
        }
    }

    @Override
    public Student get(String login) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                String password = resultSet.getString(3);
                String student_login = resultSet.getString(5);
                return new Student(name, surname, password, student_login);
            } else {
                return null;
            }
        }

    }

    @Override
    public boolean delete(String login) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setString(1, login);
            return preparedStatement.execute();
        }
    }

    @Override
    public boolean update(Student student) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setString(4, student.getLogin());
            return preparedStatement.execute();
        }

    }

    @Override
    public List<Student> getAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GETALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("login"));
                studentList.add(student);
            }
            return studentList;
        }
    }

}
