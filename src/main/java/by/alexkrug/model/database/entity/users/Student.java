package by.alexkrug.model.database.entity.users;

import by.alexkrug.model.database.entity.enumtype.SysRole;

public class Student extends User {
    private Long student_id;
    private final SysRole person_sysrole;


    public Student() {
        this.person_sysrole = SysRole.STUDENT;
    }

    public Student(Long student_id, String name, String surname, String login) {
        super(name, surname, login);
        this.student_id = student_id;
        this.person_sysrole = SysRole.STUDENT;

    }

    public Student(String name, String surname, String password, SysRole person_sysrole, Long student_id, String login) {
        super(name, surname, password, login);
        this.person_sysrole = person_sysrole;
        this.student_id = student_id;
    }

    public Long getStudent_id() {
        return student_id;
    }


    public SysRole getPerson_sysrole() {
        return person_sysrole;
    }


    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", person_sysrole=" + person_sysrole +
                ", login='" + getLogin() + '\'' +
                '}';
    }
}