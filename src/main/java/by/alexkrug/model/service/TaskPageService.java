package by.alexkrug.model.service;

import by.alexkrug.model.database.dao.TaskDao;
import by.alexkrug.model.database.entity.Task;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class TaskPageService {
    private final TaskDao taskDao = TaskDao.INSTANCE;
    public final static TaskPageService INSTANCE = new TaskPageService();

    private TaskPageService(){}

    public void createTask(HttpServletRequest req) throws SQLException {
        String description = req.getParameter("description");
        LocalDate deadline = Date.valueOf(req.getParameter("deadline")).toLocalDate();
        String student_login = req.getSession().getAttribute("handle").toString();
        String teacher_login = req.getSession().getAttribute("login").toString();
        Task task = new Task(deadline, description, student_login, teacher_login);
        taskDao.add(task);
    }
}
