package by.alexkrug.model.database.dao;


import by.alexkrug.model.database.connection.ConnectionManager;
import by.alexkrug.model.database.entity.users.Teacher;
import by.alexkrug.model.database.entity.enumtype.SysRole;
import by.alexkrug.model.database.exceptions.ResultSetEmptyException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TeacherDao implements IDao<Teacher, Long> {
    Connection connection = ConnectionManager.getConnection();
    public static TeacherDao INSTANCE = new TeacherDao();
    private final static String ADD = """
            INSERT INTO teachers(name, surname, password, login)
            VALUES (?, ?, ?, ?)
            """;

    private final static String GET = """
            SELECT * FROM teachers WHERE teacher_id = ?
            """;

    private final static String DELETE = """
            DELETE FROM teachers
            WHERE teacher_id = ?
            """;


    private final static String UPDATE = """
             UPDATE teachers
             SET \s
                 name = ?,
                 surname = ?,
                 password = ?
             WHERE teacher_id = ?
            \s""";

    private final static String GETALL = """
            SELECT * FROM teachers
            """;

    private final static String CHECKUSER = """
            SELECT * FROM teachers
                     WHERE login = ?
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
            if (keys.next()) {
                return new Teacher(teacher.getName(), teacher.getSurname(), teacher.getPassword(), teacher.getPerson_sysrole(), keys.getLong(5), teacher.getLogin());
            }
            throw new SQLException();
        }
    }

    @Override
    public Teacher get(Long id) throws SQLException, ResultSetEmptyException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                String password = resultSet.getString(3);
                SysRole person_sysrole = SysRole.valueOf(resultSet.getString(4));
                Long teacher_id = resultSet.getLong(5);
                String login = resultSet.getString(6);
                return new Teacher(name, surname, password, person_sysrole, teacher_id, login);
            } else {
                throw new ResultSetEmptyException("Empty result set");
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
    public boolean update(Teacher teacher) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getSurname());
            preparedStatement.setString(3, teacher.getPassword());
            preparedStatement.setLong(4, teacher.getTeacher_id());
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
                        resultSet.getLong("teacher_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("login"));
                teacherList.add(teacher);
            }
            return teacherList;
        }
    }

    public Teacher get(String login) throws SQLException, ResultSetEmptyException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(CHECKUSER)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String surname = resultSet.getString(2);
                String password = resultSet.getString(3);
                SysRole person_sysrole = SysRole.valueOf(resultSet.getString(4));
                Long teacher_id = resultSet.getLong(5);
                return new Teacher(name, surname, password, person_sysrole, teacher_id, login);
            } else {
                return null;
            }
        }
    }
}
