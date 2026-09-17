package by.alexkrug.model.service;

import by.alexkrug.contoller.exceptions.EmptyParameter;
import by.alexkrug.model.database.dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RegistrationService {
    public static RegistrationService INSTANCE = new RegistrationService();
    private HttpServletRequest httpServletRequest;
    private RegistrationService(){}

    public void registrate() {
        StudentDao studentDao = StudentDao.INSTANCE;

    }

    private Map<String, String> getParams() {
        Map<String, String[]> mapWithParam = httpServletRequest.getParameterMap();
        Map<String, String> params = new HashMap<>();
        for (String paramName : mapWithParam.keySet()) {
            if (mapWithParam.get(paramName).length == 0) {
                throw new EmptyParameter("Parameter value is empty");
            }
            params.put(paramName, mapWithParam.get(paramName)[0]);
        }
        return params;

    }

    private boolean isRegistrated() {
        StudentDao studentDao = StudentDao.INSTANCE;
        return false;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }


}
