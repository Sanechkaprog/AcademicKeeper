package by.alexkrug.model.database.dao;


import by.alexkrug.model.database.connection.ConnectionManager;
import by.alexkrug.model.database.entity.users.Teacher;
import by.alexkrug.model.database.entity.enumtype.SysRole;
import by.alexkrug.model.database.exceptions.ResultSetEmptyException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TeacherDao implements IDao<Teacher, String> {
    Connection connection = ConnectionManager.getConnection();
    public static TeacherDao INSTANCE = new TeacherDao();
    private final static String ADD = """
            INSERT INTO teachers(name, surname, password, login)
            VALUES (?, ?, ?, ?)
            """;

    private final static String GET = """
            SELECT * FROM teachers WHERE login = ?
            """;

    private final static String DELETE = """
            DELETE FROM teachers
            WHERE login = ?
            """;


    private final static String UPDATE = """
             UPDATE teachers
             SET \s
                 name = ?,
                 surname = ?,
                 password = ?
             WHERE login = ?
            \s""";

    private final static String GETALL = """
            SELECT * FROM teachers
            """;

    private TeacherDao()  {
    }

    @Override
    public Teacher add(Teacher teacher) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getSurname());
            preparedStatement.setObject(3, teacher.getPassword());
            preparedStatement.setObject(4, teacher.getLogin());
            preparedStatement.execute();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            return teacher;
        }
    }

    @Override
    public Teacher get(String login) throws SQLException, ResultSetEmptyException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                String password = resultSet.getString(3);
                String teacher_login = resultSet.getString(5);
                return new Teacher(name, surname, password, teacher_login);
            } else {
                return null;
            }
        }

    }

    @Override
    public boolean delete(String param) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setString(1, param);
            return preparedStatement.execute();
        }
    }

    @Override
    public boolean update(Teacher teacher) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getSurname());
            preparedStatement.setString(3, teacher.getPassword());
            preparedStatement.setString(4, teacher.getLogin());
            return preparedStatement.execute();
        }

    }

    @Override
    public List<Teacher> getAll() throws SQLException {
        List<Teacher> teacherList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GETALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher(
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("login"));
                teacherList.add(teacher);
            }
            return teacherList;
        }
    }
}
