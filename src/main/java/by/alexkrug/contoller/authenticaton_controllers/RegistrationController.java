package by.alexkrug.contoller;

import by.alexkrug.contoller.ErrorStatusType.Status;
import by.alexkrug.contoller.exceptions.EmptyParameterException;
import by.alexkrug.model.service.authentication.RegistrationService;
import by.alexkrug.model.service.exceptions.RegisteredException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
    RegistrationService registrationService = RegistrationService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        registrationService.setHttpServletRequest(req);
        try {
            registrationService.registrate();
        } catch (EmptyParameterException e) {
            req.setAttribute("errorMessage", Status.EMPTY.toString());
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        } catch (RegisteredException e) {
            req.setAttribute("errorMessage", Status.REGISTERED.toString());
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
