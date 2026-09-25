package by.alexkrug.model.database.dao;

import by.alexkrug.model.database.connection.ConnectionManager;
import by.alexkrug.model.database.entity.Task;
import by.alexkrug.model.database.exceptions.ResultSetEmptyException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TaskDao implements IDao<Task, Long> {
    Connection connection = ConnectionManager.getConnection();
    public static TaskDao INSTANCE = new TaskDao();
    private final static String ADD = """
            INSERT INTO tasks(status, creation_time, deadline, description, student_login, teacher_login)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    private final static String GET = """
            SELECT * FROM tasks WHERE task_id = ?
            """;

    private final static String DELETE = """
            DELETE FROM tasks
            WHERE task_id = ?
            """;

    private final static String UPDATE = """
             UPDATE tasks
             SET \s
                 deadline = ?,
                 status = ?,
                 description = ?
             WHERE task_id = ?
            \s""";

    private final static String GETALL = """
            SELECT * FROM tasks
            """;



    private TaskDao()  {
    }


    @Override
    public Task add(Task o) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, o.getStatusType().name(), java.sql.Types.OTHER);
            preparedStatement.setObject(2, o.getCreation_time());
            preparedStatement.setObject(3, o.getDeadline());
            preparedStatement.setString(4, o.getDescription());
            preparedStatement.setString(5, o.getStudent_login());
            preparedStatement.setString(6, o.getTeacher_login());
            preparedStatement.execute();
            ResultSet keys = preparedStatement.getGeneratedKeys();

            if (keys.next()) {
                return new Task(
                        keys.getLong(7),
                        o.getCreation_time(),
                        o.getDeadline(),
                        o.getDescription(),
                        o.getStudent_login(),
                        o.getTeacher_login()
                );
            }
            throw new SQLException();
        }
    }

    @Override
    public Task get(Long id) throws SQLException, ResultSetEmptyException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Task(
                        resultSet.getLong(5),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            }
            throw new ResultSetEmptyException("Empty set");
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
    public boolean update(Task o) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setDate(1, Date.valueOf(o.getDeadline()));
            preparedStatement.setObject(2, o.getStatusType());
            preparedStatement.setString(3, o.getDescription());
            preparedStatement.setLong(4, o.getTask_id());
            return preparedStatement.execute();
        }
    }

    @Override
    public List<Task> getAll() throws SQLException {
        return List.of();
    }
}
