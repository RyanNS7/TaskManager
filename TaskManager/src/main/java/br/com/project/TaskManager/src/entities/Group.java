package br.com.project.TaskManager.src.entities;

import java.util.Set;
import java.util.UUID;

public class Group {

    private UUID id;
    private String nameGroup;
    private Set<User> users;
    private UUID currentProject;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public UUID getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(UUID currentProject) {
        this.currentProject = currentProject;
    }
}
