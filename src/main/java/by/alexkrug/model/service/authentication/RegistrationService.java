package by.alexkrug.model.service;

import by.alexkrug.contoller.exceptions.EmptyParameterException;
import by.alexkrug.model.database.dao.StudentDao;
import by.alexkrug.model.database.dao.TeacherDao;
import by.alexkrug.model.database.entity.users.Student;
import by.alexkrug.model.database.entity.users.Teacher;
import by.alexkrug.model.database.entity.users.User;
import by.alexkrug.model.service.exceptions.RegisteredException;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RegistrationService {
    public static RegistrationService INSTANCE = new RegistrationService();
    private HttpServletRequest httpServletRequest;
    private final StudentDao studentDao = StudentDao.INSTANCE;
    private final TeacherDao teacherDao = TeacherDao.INSTANCE;

    private RegistrationService() {
    }

    public void registrate() throws SQLException, EmptyParameterException, RegisteredException {
        Map<String, String> params = getParams();
        if (!isNotRegistrate(params)) {
            throw new RegisteredException();
        }
        if (params.get("status").equals("teacher")) {
            pushToDataBase(new Teacher(), params);
        }

        if (params.get("status").equals("student")) {
            pushToDataBase(new Student(), params);
        }
    }

    private Map<String, String> getParams() throws EmptyParameterException {
        Map<String, String[]> mapWithParam = httpServletRequest.getParameterMap();
        Map<String, String> params = new HashMap<>();
        for (String paramName : mapWithParam.keySet()) {
            if (mapWithParam.get(paramName)[0].isEmpty()) {
                throw new EmptyParameterException("Parameter value is empty");
            }
            params.put(paramName, mapWithParam.get(paramName)[0]);
        }
        return params;

    }

    private boolean isNotRegistrate(Map<String, String> params) throws SQLException {
        String login = params.get("login");
        if ((studentDao.get(login) == null && params.get("status").equals("student")) || (teacherDao.get(login) == null && params.get("status").equals("teacher"))) {
            return true;
        }
        return false;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    private void pushToDataBase(User user, Map<String, String> params) throws SQLException {
        String name = params.get("username");
        String surname = params.get("surname");
        String login = params.get("login");
        String password = params.get("password");
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);
        if (user instanceof Teacher teacher) {
            teacherDao.add(teacher);
        }
        if (user instanceof Student student) {
            studentDao.add(student);
        }
    }


}
