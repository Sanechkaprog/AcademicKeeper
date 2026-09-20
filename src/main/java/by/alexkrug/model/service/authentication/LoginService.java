package by.alexkrug.model.service;

import by.alexkrug.contoller.exceptions.EmptyParameterException;
import by.alexkrug.model.database.dao.StudentDao;
import by.alexkrug.model.database.dao.TeacherDao;
import by.alexkrug.model.service.exceptions.ExistenceException;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginService {
    public static LoginService INSTANCE = new LoginService();
    private HttpServletRequest httpServletRequest;
    private final StudentDao studentDao = StudentDao.INSTANCE;
    private final TeacherDao teacherDao = TeacherDao.INSTANCE;

    private LoginService() {
    }

    public boolean login() throws SQLException {
        Map<String, String> params = getParams();
        System.out.println(isExist(params));
        if (!isExist(params)) {
            throw new ExistenceException();
        }
        return true;
    }

    private Map<String, String> getParams() throws EmptyParameterException{
        Map<String, String[]> map = httpServletRequest.getParameterMap();
        Map<String, String> params = new HashMap<>();
        for (String param : map.keySet()) {
            if (map.get(param)[0].isEmpty()) {
                throw new EmptyParameterException("Parameter value is empty");
            }
            params.put(param, map.get(param)[0]);
        }
        return params;
    }

    private boolean isExist(Map<String, String> params) throws SQLException, ExistenceException {
        String login = params.get("login");
        String status = params.get("status");
        System.out.println(teacherDao.get(login));
        if (
                (teacherDao.get(login) != null && status.equals("teacher"))
                        ||
                        (studentDao.get(login) != null && status.equals("student"))
        ) {
            return true;
        }
        return false;

    }


    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
}
