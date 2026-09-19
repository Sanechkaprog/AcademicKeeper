package by.alexkrug;

import by.alexkrug.model.database.dao.StudentDao;

public class Main {
    static void main() {
        StudentDao studentDao = StudentDao.INSTANCE;
        System.out.println(studentDao.connection);
    }
}
