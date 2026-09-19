package by.alexkrug.model.database.entity.users;

import by.alexkrug.model.database.entity.enumtype.SysRole;

public class Teacher extends User {
    private Long teacher_id;
    private final SysRole person_sysrole;


    public Teacher() {
        this.person_sysrole = SysRole.TEACHER;
    }

    public Teacher(Long teacher_id, String name, String surname, String login) {
        super(name, surname, login);
        this.teacher_id = teacher_id;
        this.person_sysrole = SysRole.TEACHER;
    }

    public Teacher(String name, String surname, String password, SysRole person_sysrole, Long teacher_id, String login) {
        super(name, surname, password, login);
        this.person_sysrole = person_sysrole;
        this.teacher_id = teacher_id;
    }

    public SysRole getPerson_sysrole() {
        return person_sysrole;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", person_sysrole=" + person_sysrole +
                ", login='" + getLogin() + '\'' +
                '}';
    }
}
