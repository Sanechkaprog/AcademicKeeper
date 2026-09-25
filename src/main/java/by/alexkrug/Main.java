package by.alexkrug;

import by.alexkrug.model.database.connection.ConnectionManager;
import by.alexkrug.model.database.dao.StudentDao;
import by.alexkrug.model.database.entity.users.Student;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    static void main() throws SQLException {
        Student student = new Student();
        student.setLogin("1");
        student.setPassword("123213");
        student.setSurname("2313");
        student.setName("211");
       StudentDao studentDao = StudentDao.INSTANCE;
        Student student1 = studentDao.get("1");
        System.out.println(student1);
    }
}
