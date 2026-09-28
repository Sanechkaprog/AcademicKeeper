package by.alexkrug.model.service;

import by.alexkrug.model.database.dao.TaskDao;
import by.alexkrug.model.database.entity.Task;
import by.alexkrug.model.database.entity.enumtype.StatusType;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class StudentPageService {
    public static final StudentPageService INSTANCE = new StudentPageService();
    private final TaskDao taskDao = TaskDao.INSTANCE;

    private StudentPageService() {}

    public List<Task> getStudentTasks(String login) throws SQLException {
        List<Task> tasks = taskDao.get(login);
        return isExpired(tasks);
    }

    public void changeTaskStatus(Long task_id) throws SQLException {
        Task task = taskDao.get(task_id);
        task.setStatusType(StatusType.MADE);
        taskDao.update(task);
    }

    private List<Task> isExpired(List<Task> tasks) throws SQLException {
        for (Task task : tasks) {
            if (LocalDate.now().isAfter(task.getDeadline())) {
                task.setStatusType(StatusType.EXPIRED);
                taskDao.update(task);
            }
        }
        return tasks;
    }
}
