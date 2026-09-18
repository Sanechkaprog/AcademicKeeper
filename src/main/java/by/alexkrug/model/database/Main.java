package by.alexkrug.model.database;

import by.alexkrug.model.database.dao.StudentDao;
import by.alexkrug.model.database.dao.TeacherDao;
import by.alexkrug.model.database.entity.Student;
import by.alexkrug.model.database.entity.Task;
import by.alexkrug.model.database.entity.Teacher;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    static void main() throws SQLException {
        StudentDao teacherDao = StudentDao.INSTANCE;
        teacherDao.getAll().stream().forEach(x -> System.out.println(x));


//        try {
//            Task task = new Task();
//            task.setCreation_time(LocalDate.of(2000, 4, 14));
//            task.setDeadline(LocalDate.of(2001, 5, 15));
//            task.setStudent_id(5L);
//            task.setTeacher_id(2L);
//            task.setDescription("lol");
//
//    }
//}
//}
    }
}