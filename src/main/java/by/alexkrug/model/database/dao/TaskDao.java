package by.alexkrug.model.database.dao;

import by.alexkrug.model.database.connection.ConnectionManager;
import by.alexkrug.model.database.entity.Task;
import by.alexkrug.model.database.entity.enumtype.StatusType;
import by.alexkrug.model.database.exceptions.ResultSetEmptyException;

import java.sql.*;
import java.time.LocalDate;
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


    private TaskDao() {
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
                        keys.getLong(5),
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
        String sql = GETALL + " WHERE task_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Task> tasks = getTasks(resultSet);
            if (!tasks.isEmpty()) {
                return tasks.getFirst();
            }
            return null;
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
            preparedStatement.setObject(2, o.getStatusType().toString(), Types.OTHER);
            preparedStatement.setString(3, o.getDescription());
            preparedStatement.setLong(4, o.getTask_id());
            return preparedStatement.execute();
        }
    }

    @Override
    public List<Task> getAll() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GETALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return getTasks(resultSet);
        }
    }

    public List<Task> get(String student_login) throws SQLException {
        String sql = GETALL + " WHERE student_login = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student_login);
            ResultSet resultSet = preparedStatement.executeQuery();
            return getTasks(resultSet);
        }
    }

    private List<Task> getTasks(ResultSet resultSet) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        while (resultSet.next()) {
            String status = resultSet.getString(1);
            LocalDate creation_time = resultSet.getDate(2).toLocalDate();
            LocalDate deadline = resultSet.getDate(3).toLocalDate();
            String description = resultSet.getString(4);
            Long id = resultSet.getLong(5);
            String student_login = resultSet.getString(6);
            String teacher_login = resultSet.getString(7);
            Task task = new Task(
                    id,
                    student_login,
                    teacher_login,
                    StatusType.valueOf(status),
                    description,
                    deadline
            );
            tasks.add(task);
        }
        return tasks;
    }
}
