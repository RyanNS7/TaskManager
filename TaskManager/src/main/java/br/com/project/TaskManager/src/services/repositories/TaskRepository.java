package br.com.project.TaskManager.src.services.repositories;

import br.com.project.TaskManager.src.DTO.TaskDTO;
import br.com.project.TaskManager.src.entities.Task;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository {

    Task createTask(TaskDTO task, UUID project_id);
    Boolean deleteTask(UUID id_task);

}
