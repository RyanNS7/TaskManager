package br.com.project.TaskManager.src.services.repositories;

import br.com.project.TaskManager.src.DTO.ProjectDTO;
import br.com.project.TaskManager.src.entities.Project;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepository {

    Project createProject(Project project);
    Boolean deleteProject(UUID id_project);
    Project findProjectByID(UUID id_project);

}
