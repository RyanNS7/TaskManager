package br.com.project.TaskManager.src.adapters.in.controllers;

import br.com.project.TaskManager.src.DTO.TaskDTO;
import br.com.project.TaskManager.src.DTO.UpdateTaskDTO;
import br.com.project.TaskManager.src.entities.Task;
import br.com.project.TaskManager.src.services.usecases.task.CreateTaskService;
import br.com.project.TaskManager.src.services.usecases.task.DeleteTaskService;
import br.com.project.TaskManager.src.services.usecases.task.FindTaskService;
import br.com.project.TaskManager.src.services.usecases.task.UpdateTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final CreateTaskService createTaskService;
    private final FindTaskService findTaskService;
    private final DeleteTaskService deleteTaskService;
    private final UpdateTaskService updateTaskService;

    public TaskController(CreateTaskService createTaskService, FindTaskService findTaskService, DeleteTaskService deleteTaskService, UpdateTaskService updateTaskService) {
        this.createTaskService = createTaskService;
        this.findTaskService = findTaskService;
        this.deleteTaskService = deleteTaskService;
        this.updateTaskService = updateTaskService;
    }

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO){

        Task task = new Task();
        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());

        Task created = createTaskService.create(task, taskDTO.projectID());

        return ResponseEntity.status(201).body(created);

    }

    @GetMapping("/{id}")
    ResponseEntity<Task> findTask(@PathVariable UUID id){
        Task find = findTaskService.find(id);

        return ResponseEntity.ok(find);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable UUID id){
        deleteTaskService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    ResponseEntity<Task> updateTask(@RequestBody UpdateTaskDTO updateTaskDTO){
        Task task = new Task();
        task.setTask_id(updateTaskDTO.idTask());
        task.setStatus(updateTaskDTO.status());
        task.setDescription(updateTaskDTO.description());
        task.setTitle(updateTaskDTO.title());

        Task updated = updateTaskService.update(task);

        return ResponseEntity.ok(updated);
    }

}
