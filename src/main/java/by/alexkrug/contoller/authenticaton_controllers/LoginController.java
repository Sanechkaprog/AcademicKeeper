package by.alexkrug.contoller;

import by.alexkrug.contoller.ErrorStatusType.Status;
import by.alexkrug.contoller.exceptions.EmptyParameterException;
import by.alexkrug.model.service.authentication.LoginService;
import by.alexkrug.model.service.exceptions.ExistenceException;
import by.alexkrug.tools.PathsHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PathsHandler.handle("index")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = LoginService.INSTANCE;
        loginService.setHttpServletRequest(req);
        try {
            loginService.login();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ExistenceException e) {
            req.setAttribute("errorMessage", Status.NOT_REGISTERED.toString());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        } catch (EmptyParameterException e) {
            req.setAttribute("errorMessage", Status.EMPTY.toString());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("login", req.getParameter("login"));
        httpSession.setAttribute("status", req.getParameter("status"));
        resp.sendRedirect("/diary");

    }


}
