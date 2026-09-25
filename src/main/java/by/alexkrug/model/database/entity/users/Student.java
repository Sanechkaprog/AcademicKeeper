package by.alexkrug.model.database.entity.users;

import by.alexkrug.model.database.entity.enumtype.SysRole;

public class Student extends User {
    private final SysRole person_sysrole;


    public Student() {
        this.person_sysrole = SysRole.STUDENT;
    }

    public Student(String name, String surname, String login) {
        super(name, surname, login);
        this.person_sysrole = SysRole.STUDENT;

    }

    public Student(String name, String surname, String password, String login) {
        super(name, surname, password, login);
        this.person_sysrole = SysRole.STUDENT;
    }



    public SysRole getPerson_sysrole() {
        return person_sysrole;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", person_sysrole=" + person_sysrole +
                ", login='" + getLogin() + '\'' +
                '}';
    }
}