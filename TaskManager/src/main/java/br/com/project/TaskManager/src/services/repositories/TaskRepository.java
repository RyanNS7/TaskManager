package br.com.project.TaskManager.src.services.repositories;

import br.com.project.TaskManager.src.DTO.TaskDTO;
import br.com.project.TaskManager.src.entities.Task;

import java.util.UUID;

public interface TaskRepository {

    Task createTask(TaskDTO task, UUID project_id);
    Boolean deleteTask(UUID id_task);

}
