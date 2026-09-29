package by.alexkrug.model.database.entity;

import by.alexkrug.model.database.entity.enumtype.StatusType;

import java.time.LocalDate;

public class Task {
    private Long task_id;
    private String student_login;
    private String teacher_login;
    private StatusType statusType;
    private LocalDate creation_time;
    private String description;
    private LocalDate deadline;

    public Task() {
        statusType = StatusType.PROCESSING;
    }

    public Task(Long task_id, String student_login, String teacher_login, StatusType statusType, String description, LocalDate deadline) {
        this.task_id = task_id;
        this.student_login = student_login;
        this.teacher_login = teacher_login;
        this.statusType = statusType;
        this.creation_time = LocalDate.now();
        this.description = description;
        this.deadline = deadline;
    }


    public Task(Long task_id, LocalDate deadline, String description, String student_login, String teacher_login) {
        this.task_id = task_id;
        this.deadline = deadline;
        this.description = description;
        this.creation_time = LocalDate.now();
        this.student_login = student_login;
        this.teacher_login = teacher_login;
        statusType = StatusType.PROCESSING;
    }

    public Task(LocalDate deadline, String description, String student_login, String teacher_login) {
        this.deadline = deadline;
        this.description = description;
        this.creation_time = LocalDate.now();
        this.student_login = student_login;
        this.teacher_login = teacher_login;
        statusType = StatusType.PROCESSING;
    }




    public Long getTask_id() {
        return task_id;
    }

    public String getStudent_login() {
        return student_login;
    }

    public void setStudent_login(String student_login) {
        this.student_login = student_login;
    }

    public String getTeacher_login() {
        return teacher_login;
    }

    public void setTeacher_login(String teacher_login) {
        this.teacher_login = teacher_login;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public LocalDate getCreation_time() {
        return creation_time;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return
                "task_id=" + task_id + "\n\n" +
                ", student_login='" + student_login + '\'' + "\n" +
                ", teacher_login='" + teacher_login + '\'' + "\n" +
                ", statusType=" + statusType + "\n" +
                ", creation_time=" + creation_time + "\n" +
                ", description='" + description + '\'' + "\n" +
                ", deadline=" + deadline + "\n"
                ;
    }
}
