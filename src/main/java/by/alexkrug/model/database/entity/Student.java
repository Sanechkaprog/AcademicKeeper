package by.alexkrug.model.database.entity;

import by.alexkrug.model.database.entity.enumtype.SysRole;

public class Student {
    private Long student_id;
    private String name;
    private String surname;
    private String password;
    private final SysRole person_sysrole;
    private String login;


    public Student() {
        this.person_sysrole = SysRole.STUDENT;
    }

    public Student(Long student_id, String name, String surname, String login) {
        this.student_id = student_id;
        this.name = name;
        this.surname = surname;
        this.person_sysrole = SysRole.STUDENT;
        this.login = login;
    }

    public Student(String name, String surname, String password, SysRole person_sysrole, Long student_id, String login) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.person_sysrole = person_sysrole;
        this.student_id = student_id;
        this.login = login;
    }

    public Long getStudent_id() {
        return student_id;
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

    public SysRole getPerson_sysrole() {
        return person_sysrole;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", person_sysrole=" + person_sysrole +
                ", login='" + login + '\'' +
                '}';
    }
}