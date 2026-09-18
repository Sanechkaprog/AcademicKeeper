package by.alexkrug.model.database.entity;

import by.alexkrug.model.database.entity.enumtype.SysRole;

public class Teacher {
    private Long teacher_id;
    private String name;
    private String surname;
    private String password;
    private final SysRole person_sysrole;
    private String login;

    public Teacher() {
        this.person_sysrole = SysRole.TEACHER;
    }

    public Teacher(Long teacher_id, String name, String surname, String login) {
        this.teacher_id = teacher_id;
        this.name = name;
        this.surname = surname;
        this.person_sysrole = SysRole.TEACHER;
    }

    public Teacher(String name, String surname, String password, SysRole person_sysrole, Long teacher_id, String login) {
        this.person_sysrole = person_sysrole;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.teacher_id = teacher_id;
    }

    public SysRole getPerson_sysrole() {
        return person_sysrole;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", person_sysrole=" + person_sysrole +
                ", login='" + login + '\'' +
                '}';
    }
}
