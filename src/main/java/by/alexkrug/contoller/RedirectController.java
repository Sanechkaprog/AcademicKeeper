package by.alexkrug.contoller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/diary")
public class RedirectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if (httpSession.getAttribute("login") == null) {
            req.getRequestDispatcher("/error404.jsp").forward(req, resp);
        }

        if ("student".equals(httpSession.getAttribute("status"))) {
            req.getRequestDispatcher("/student").forward(req, resp);
        }

        if ("teacher".equals(httpSession.getAttribute("status"))) {
            req.getRequestDispatcher("/teacher").forward(req, resp);
        }


    }
}
