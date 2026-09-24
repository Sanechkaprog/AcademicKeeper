package by.alexkrug.model.service.authentication;


import by.alexkrug.model.service.exceptions.ExistenceException;
import by.alexkrug.model.service.exceptions.IncorrectPasswordException;

import java.sql.SQLException;

import java.util.Map;

public class LoginService extends AbstractAuthentication{
    public static LoginService INSTANCE = new LoginService();


    private LoginService() {
    }

    public boolean login() throws SQLException {
        Map<String, String> params = getParams();
        if (!isExist(params)) {
            throw new ExistenceException();
        }

        if (!isPasswordCorrect(params)) {
            throw new IncorrectPasswordException();
        }

        return true;
    }

    protected boolean isPasswordCorrect(Map<String, String> params) throws SQLException, ExistenceException {
        String password = params.get("password");
        String login = params.get("login");
        String status = params.get("status");
        if (
                (!teacherDao.get(login).getPassword().equals(password) && status.equals("teacher"))
                        ||
                        (!studentDao.get(login).getPassword().equals(password) && status.equals("student"))
        ) {
            return false;
        }
        return true;
    }
}
