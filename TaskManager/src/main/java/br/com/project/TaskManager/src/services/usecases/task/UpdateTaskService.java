package br.com.project.TaskManager.src.services.usecases.task;

import br.com.project.TaskManager.src.Status;
import br.com.project.TaskManager.src.entities.Task;
import br.com.project.TaskManager.src.services.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskService {

    private final TaskRepository taskRepo;

    public UpdateTaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task update(Task task){
        return taskRepo.updateTask(task);
    }
}
