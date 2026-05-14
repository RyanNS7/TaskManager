package br.com.project.TaskManager.src.entities;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private UUID current_task_id;
    private UUID GroupID;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getCurrent_task_id() {
        return current_task_id;
    }

    public void setCurrent_task_id(UUID current_task_id) {
        this.current_task_id = current_task_id;
    }

    public UUID getGroupID() {
        return GroupID;
    }

    public void setGroupID(UUID groupID) {
        GroupID = groupID;
    }
}
