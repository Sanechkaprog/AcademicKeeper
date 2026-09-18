package by.alexkrug.contoller;

import by.alexkrug.model.service.RegistrationService;
import by.alexkrug.tools.PathsHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
    RegistrationService registrationService = RegistrationService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PathsHandler.handle("registration")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        registrationService.setHttpServletRequest(req);
//        registrationService.check();
    }
}
