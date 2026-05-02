package br.com.project.TaskManager.src.services.usecases.project;

import br.com.project.TaskManager.src.DTO.ProjectDTO;
import br.com.project.TaskManager.src.entities.Project;
import br.com.project.TaskManager.src.services.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectService {

    private final ProjectRepository projectRepo;

    public CreateProjectService(ProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Project create(ProjectDTO projectDTO){

        Project project = new Project();
        project.setNameProject(projectDTO.name_project());

        return projectRepo.createProject(project);
    }
}
