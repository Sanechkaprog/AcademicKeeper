package by.alexkrug.model.service;

import by.alexkrug.model.database.dao.TaskDao;
import by.alexkrug.model.database.entity.Task;
import by.alexkrug.model.database.entity.enumtype.StatusType;

import java.sql.SQLException;
import java.util.List;

public class StudentPageService {
    public static final StudentPageService INSTANCE = new StudentPageService();
    private final TaskDao taskDao = TaskDao.INSTANCE;

    private StudentPageService() {}

    public List<Task> getStudentTasks(String login) throws SQLException {
        return taskDao.get(login);
    }

    public void changeTaskStatus(Long task_id) throws SQLException{
        Task task = taskDao.get(task_id);
        task.setStatusType(StatusType.MADE);
        taskDao.update(task);
    }
}
