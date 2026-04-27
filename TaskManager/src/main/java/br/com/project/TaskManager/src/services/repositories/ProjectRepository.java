package br.com.project.TaskManager.src.services.repositories;

import br.com.project.TaskManager.src.DTO.ProjectDTO;
import br.com.project.TaskManager.src.entities.Project;

import java.util.UUID;

public interface ProjectRepository {

    Project createProject(ProjectDTO project);
    Boolean deleteProject(UUID id_project);
    Project findProjectByID(UUID id_project);

}
