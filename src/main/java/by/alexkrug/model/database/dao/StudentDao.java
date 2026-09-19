package by.alexkrug.model.database.dao;

import by.alexkrug.model.database.connection.ConnectionManager;
import by.alexkrug.model.database.entity.users.Student;
import by.alexkrug.model.database.entity.enumtype.SysRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao implements IDao<Student, Long> {
    public static StudentDao INSTANCE = new StudentDao();
    public Connection connection = ConnectionManager.getConnection();
    private final static String ADD = """
            INSERT INTO students(name, surname, password, login)
            VALUES (?, ?, ?, ?)
            """;

    private final static String GET = """
            SELECT * FROM students WHERE student_id = ?
            """;

    private final static String DELETE = """
            DELETE FROM students
            WHERE student_id = ?
            """;


    private final static String UPDATE = """
             UPDATE students
             SET \s
                 name = ?,
                 surname = ?,
                 password = ?
             WHERE student_id = ?
            \s""";

    private final static String GETALL = """
            SELECT * FROM students
            """;

    private final static String CHECKUSER = """
            SELECT * FROM students
                     WHERE login = ?
            """;

    private StudentDao() {
    }

    @Override
    public Student add(Student student) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setObject(3, student.getPassword());
            preparedStatement.setString(4, student.getLogin());
            preparedStatement.execute();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                return new Student(student.getName(), student.getSurname(), student.getPassword(), student.getPerson_sysrole(), keys.getLong(5), student.getLogin());
            }
            throw new SQLException();
        }
    }

    @Override
    public Student get(Long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                String password = resultSet.getString(3);
                SysRole person_sysrole = SysRole.valueOf(resultSet.getString(4));
                Long student_id = resultSet.getLong(5);
                String login = resultSet.getString(6);
                return new Student(name, surname, password, person_sysrole, student_id, login);
            } else {
                return null;
            }
        }

    }

    @Override
    public boolean delete(Long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        }
    }

    @Override
    public boolean update(Student student) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setLong(4, student.getStudent_id());
            return preparedStatement.execute();
        }

    }

    @Override
    public List<Student> getAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GETALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getLong("student_id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("login"));
                studentList.add(student);
            }
            return studentList;
        }
    }

    public Student get(String login) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CHECKUSER)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                String password = resultSet.getString(3);
                SysRole person_sysrole = SysRole.valueOf(resultSet.getString(4));
                Long student_id = resultSet.getLong(5);
                return new Student(
                        name,
                        surname,
                        password,
                        person_sysrole,
                        student_id,
                        login);
            } else {
                return null;
            }
        }
    }
}
