package by.alexkrug.database.entity;

import by.alexkrug.database.entity.enumtype.SysRole;

public class Student {
    private Long student_id;
    private String name;
    private String surname;
    private String password;
    private final SysRole person_sysrole;


    public Student() {
        this.person_sysrole = SysRole.STUDENT;
    }

    public Student(Long student_id, String name, String surname) {
        this.student_id = student_id;
        this.name = name;
        this.surname = surname;
        this.person_sysrole = SysRole.STUDENT;
    }

    public Student(String name, String surname, String password, SysRole person_sysrole, Long student_id) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.person_sysrole = person_sysrole;
        this.student_id = student_id;
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

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", person_sysrole=" + person_sysrole +
                '}';
    }
}
