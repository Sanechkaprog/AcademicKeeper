package by.alexkrug.model.service.authentication;

import by.alexkrug.contoller.exceptions.EmptyParameterException;
import by.alexkrug.model.database.dao.StudentDao;
import by.alexkrug.model.database.dao.TeacherDao;
import by.alexkrug.model.service.exceptions.ExistenceException;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAuthentication {
    protected HttpServletRequest httpServletRequest;
    protected final StudentDao studentDao = StudentDao.INSTANCE;
    protected final TeacherDao teacherDao = TeacherDao.INSTANCE;

    protected boolean isExist(Map<String, String> params) throws SQLException, ExistenceException {
        String login = params.get("login");
        String status = params.get("status");
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

    protected Map<String, String> getParams() throws EmptyParameterException {
        Map<String, String[]> map = httpServletRequest.getParameterMap();
        Map<String, String> params = new HashMap<>();
        for (String param : map.keySet()) {
            params.put(param, map.get(param)[0]);
        }
        return params;
    }
}
