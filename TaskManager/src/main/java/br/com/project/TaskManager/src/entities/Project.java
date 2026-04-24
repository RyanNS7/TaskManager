package br.com.project.TaskManager.src.entities;

import java.util.UUID;

public class Project {

    private UUID id;
    private String name_project;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName_project() {
        return name_project;
    }

    public void setName_project(String name_project) {
        this.name_project = name_project;
    }
}
