package by.alexkrug.model.service;

import by.alexkrug.model.database.dao.StudentDao;
import by.alexkrug.model.database.dao.TaskDao;
import by.alexkrug.model.database.entity.users.Student;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.List;


public class TeacherPageService {
    private final StudentDao studentDao = StudentDao.INSTANCE;
    private final TaskDao taskDao = TaskDao.INSTANCE;
    public final static TeacherPageService INSTANCE = new TeacherPageService();

    private TeacherPageService(){}

    public void getStudents(HttpServletRequest req) throws SQLException {
        List<Student> students = studentDao.getAll();
        req.setAttribute("students", students);
    }
}
