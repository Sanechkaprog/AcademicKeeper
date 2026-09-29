package by.alexkrug;

import by.alexkrug.model.database.connection.ConnectionManager;
import by.alexkrug.model.database.dao.StudentDao;
import by.alexkrug.model.database.dao.TaskDao;
import by.alexkrug.model.database.entity.Task;
import by.alexkrug.model.database.entity.users.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    static void main() throws SQLException {
        TaskDao taskDao = TaskDao.INSTANCE;
    }
}
