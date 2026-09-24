package by.alexkrug.model.service.authentication;

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

public class RegistrationService extends AbstractAuthentication{
    public static RegistrationService INSTANCE = new RegistrationService();


    private RegistrationService() {
    }

    public void registrate() throws SQLException, EmptyParameterException, RegisteredException {
        Map<String, String> params = getParams();
        if (isExist(params)) {
            throw new RegisteredException();
        }
        if (params.get("status").equals("teacher")) {
            pushToDataBase(new Teacher(), params);
        }

        if (params.get("status").equals("student")) {
            pushToDataBase(new Student(), params);
        }
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
