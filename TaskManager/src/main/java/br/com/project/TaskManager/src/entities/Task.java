package br.com.project.TaskManager.src.entities;

import br.com.project.TaskManager.src.Status;

import java.util.UUID;

public class Task {

    private UUID task_id;
    private String title;
    private String description;
    private Status status;
    private UUID assignedUserId;
    private UUID projectID;

    public UUID getTask_id() {
        return task_id;
    }

    public void setTask_id(UUID task_id) {
        this.task_id = task_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(UUID assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public UUID getProjectID() {
        return projectID;
    }

    public void setProjectID(UUID projectID) {
        this.projectID = projectID;
    }
}
