package br.com.project.TaskManager.src.services.repositories;


import br.com.project.TaskManager.src.entities.Task;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository {

    Task createTask(Task task, UUID projectId);
    Boolean deleteTask(UUID idTask);
    Task findTask(UUID idTask);

}
