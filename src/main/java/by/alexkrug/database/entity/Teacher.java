package by.alexkrug.database.entity;

import by.alexkrug.database.entity.enumtype.SysRole;

public class Teacher {
    private Long teacher_id;
    private String name;
    private String surname;
    private String password;
    private final SysRole person_sysrole;

    public Teacher() {
        this.person_sysrole = SysRole.TEACHER;
    }

    public Teacher(Long teacher_id, String name, String surname, String password) {
        this.teacher_id = teacher_id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.person_sysrole = SysRole.TEACHER;
    }

    public SysRole getPerson_sysrole() {
        return person_sysrole;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
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
}
