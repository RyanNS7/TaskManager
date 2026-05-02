package br.com.project.TaskManager.src.infra.models;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class ProjectModel{

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String projectName;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<TaskModel> tasks;

    public UUID getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskModel> tasks) {
        this.tasks = tasks;
    }
}
