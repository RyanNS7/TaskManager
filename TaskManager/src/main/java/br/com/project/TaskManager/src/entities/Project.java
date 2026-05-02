package br.com.project.TaskManager.src.entities;

import java.util.Set;
import java.util.UUID;

public class Project {

    private UUID id;
    private String name_project;
    private Set<Task> tasks;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNameProject() {
        return name_project;
    }

    public void setNameProject(String name_project) {
        this.name_project = name_project;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
