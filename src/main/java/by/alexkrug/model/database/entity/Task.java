package by.alexkrug.model.database.entity;

import by.alexkrug.model.database.entity.enumtype.StatusType;

import java.time.LocalDate;

public class Task {
    private Long task_id;
    private Long student_id;
    private Long teacher_id;
    private StatusType statusType;
    private LocalDate creation_time;

    {
        statusType = StatusType.PROCESSING;
    }

    private String description;

    private LocalDate deadline;

    public Task() {}

    public Task(Long task_id, Long student_id, Long teacher_id, LocalDate creation_time, LocalDate deadline, String description) {
        this.task_id = task_id;
        this.student_id = student_id;
        this.teacher_id = teacher_id;
        this.creation_time = creation_time;
        this.deadline = deadline;
        this.description = description;
    }


    public Long getTask_id() {
        return task_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
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
                ", student_id=" + student_id +
                ", teacher_id=" + teacher_id +
                ", statusType=" + statusType +
                ", creation_time=" + creation_time +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
