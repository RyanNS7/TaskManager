package br.com.project.TaskManager.src.services.usecases.task;

import br.com.project.TaskManager.src.services.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteTaskService {

    private final TaskRepository taskRepo;

    public DeleteTaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Boolean delete(UUID task_id){
        return taskRepo.deleteTask(task_id);
    }
}
