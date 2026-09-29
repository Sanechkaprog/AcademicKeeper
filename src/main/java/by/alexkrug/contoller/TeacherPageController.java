package by.alexkrug.contoller;

import by.alexkrug.model.service.TeacherPageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/teacher")
public class TeacherPageController extends HttpServlet {
    TeacherPageService teacherPageService = TeacherPageService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            teacherPageService.getStudents(req);
            req.getRequestDispatcher("/WEB-INF/jsp/teacher-page.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
