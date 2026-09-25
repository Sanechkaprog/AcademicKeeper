package by.alexkrug.model.database.entity;

import by.alexkrug.model.database.entity.enumtype.StatusType;

import java.time.LocalDate;

public class Task {
    private Long task_id;
    private String student_login;
    private String teacher_login;
    private StatusType statusType;
    private LocalDate creation_time;

    {
        statusType = StatusType.PROCESSING;
    }

    private String description;

    private LocalDate deadline;

    public Task() {}

    public Task(Long task_id, LocalDate creation_time, LocalDate deadline, String description, String student_login, String teacher_login) {
        this.task_id = task_id;
        this.creation_time = creation_time;
        this.deadline = deadline;
        this.description = description;
        this.student_login = student_login;
        this.teacher_login = teacher_login;
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

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public LocalDate getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(LocalDate creation_time) {
        this.creation_time = creation_time;
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

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", statusType=" + statusType +
                ", creation_time=" + creation_time +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
