package by.alexkrug.model.database.entity.users;

import by.alexkrug.model.database.entity.enumtype.SysRole;

public class Teacher extends User {
    private final SysRole person_sysrole;


    public Teacher() {
        this.person_sysrole = SysRole.TEACHER;
    }

    public Teacher(String name, String surname, String login) {
        super(name, surname, login);
        this.person_sysrole = SysRole.TEACHER;
    }

    public Teacher(String name, String surname, String password,  String login) {
        super(name, surname, password, login);
        this.person_sysrole = SysRole.TEACHER;

    }

    public SysRole getPerson_sysrole() {
        return person_sysrole;
    }

}
