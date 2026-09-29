package by.alexkrug.contoller.redirectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/taskred")
public class RedirectTaskController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String onButton = req.getParameter("onButton");
        req.getSession().setAttribute("handle", onButton);
        resp.sendRedirect("/task");
    }
}
