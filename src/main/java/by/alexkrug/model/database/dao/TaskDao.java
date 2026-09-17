package by.alexkrug.model.database.dao;

import by.alexkrug.model.database.connection.ConnectionManager;
import by.alexkrug.model.database.entity.Task;
import by.alexkrug.model.database.exceptions.ResultSetEmptyException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao implements IDao<Task, Long> {
    Connection connection = ConnectionManager.getConnection();
    public static TaskDao INSTANCE = new TaskDao();
    private final static String ADD = """
            INSERT INTO tasks(status, creation_time, deadline, student_id, teacher_id, description)
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
            preparedStatement.setLong(4, o.getStudent_id());
            preparedStatement.setLong(5, o.getTeacher_id());
            preparedStatement.setString(6, o.getDescription());
            preparedStatement.execute();
            ResultSet keys = preparedStatement.getGeneratedKeys();

            if (keys.next()) {
                return new Task(
                        keys.getLong(7),
                        o.getStudent_id(),
                        o.getTeacher_id(),
                        o.getCreation_time(),
                        o.getDeadline(),
                        o.getDescription()
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
                        resultSet.getLong(7),
                        resultSet.getLong(4),
                        resultSet.getLong(5),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getDate(3).toLocalDate(),
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
        List<Task> tasks = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GETALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(
                        resultSet.getLong(7),
                        resultSet.getLong(4),
                        resultSet.getLong(5),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(6)
                );
                tasks.add(task);
            }
            return tasks;
        }
    }
}
