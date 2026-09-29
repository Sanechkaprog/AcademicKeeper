package by.alexkrug.contoller;

import by.alexkrug.model.database.entity.Task;
import by.alexkrug.model.service.StudentPageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/student")
public class StudentPageController extends HttpServlet {
    StudentPageService studentPageService = StudentPageService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setTasks(req);
        req.getRequestDispatcher("/WEB-INF/jsp/student-page.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("onButton"));
        try {
            studentPageService.changeTaskStatus(id);
            resp.sendRedirect("/student");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setTasks(HttpServletRequest req) {
        String studentLogin = req.getSession().getAttribute("login").toString();
        try {
            List<Task> tasks = studentPageService.getStudentTasks(studentLogin);
            req.setAttribute("tasks", tasks);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
