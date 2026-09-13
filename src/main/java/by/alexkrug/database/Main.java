package by.alexkrug.database;

import by.alexkrug.database.connection.ConnectionManager;
import by.alexkrug.database.dao.StudentDao;
import by.alexkrug.database.entity.Student;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    static void main() {
        try {
            StudentDao studentDao = new StudentDao();
            System.out.println(studentDao.getAll());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
