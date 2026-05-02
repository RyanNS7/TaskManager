package br.com.project.TaskManager.src.services.usecases.task;

import br.com.project.TaskManager.src.DTO.TaskDTO;
import br.com.project.TaskManager.src.entities.Task;
import br.com.project.TaskManager.src.exceptions.InsufficientCharactersException;
import br.com.project.TaskManager.src.exceptions.NotFoundException;
import br.com.project.TaskManager.src.services.repositories.ProjectRepository;
import br.com.project.TaskManager.src.services.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateTaskService {

    private final TaskRepository taskRepo;
    private final ProjectRepository projectRepo;

    public CreateTaskService(TaskRepository taskRepo, ProjectRepository projectRepo) {
        this.taskRepo = taskRepo;
        this.projectRepo = projectRepo;
    }

    public Task create(TaskDTO task, UUID project_id){
        if(projectRepo.findProjectByID(project_id) == null){
            throw new NotFoundException("Error, Project not found");
        }

        if(task.title().length() < 3){
            throw new InsufficientCharactersException("Insufficient number of characters");
        }

        return taskRepo.createTask(task, project_id);
    }
}
