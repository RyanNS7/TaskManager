package br.com.project.TaskManager.src.adapters.in.controllers;

import br.com.project.TaskManager.src.DTO.ProjectDTO;
gimport br.com.project.TaskManager.src.entities.Project;
import br.com.project.TaskManager.src.services.usecases.project.CreateProjectService;
import br.com.project.TaskManager.src.services.usecases.project.DeleteProjectService;
import br.com.project.TaskManager.src.services.usecases.project.FindProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final CreateProjectService createProjectService;
    private final FindProjectService findProjectService;
    private final DeleteProjectService deleteProjectService;

    public ProjectController(CreateProjectService createProjectService, FindProjectService findProjectService, DeleteProjectService deleteProjectService) {
        this.createProjectService = createProjectService;
        this.findProjectService = findProjectService;
        this.deleteProjectService = deleteProjectService;
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody ProjectDTO projectDTO){

        Project project = createProjectService.create(projectDTO);

        return ResponseEntity.status(201).body(project);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> find(@PathVariable UUID id){

        Project project = findProjectService.find(id);

        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){

        deleteProjectService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
