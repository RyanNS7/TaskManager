package br.com.project.TaskManager.src.services.usecases.task;

import br.com.project.TaskManager.src.entities.Task;
import br.com.project.TaskManager.src.services.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindTaskService {

    private final TaskRepository taskRepo;

    public FindTaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task find(UUID idTask){
        return taskRepo.findTask(idTask);
    }
}
