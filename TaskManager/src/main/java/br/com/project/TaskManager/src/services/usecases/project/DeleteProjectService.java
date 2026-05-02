package br.com.project.TaskManager.src.services.usecases.project;

import br.com.project.TaskManager.src.services.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProjectService {

    private final ProjectRepository projectRepo;

    public DeleteProjectService(ProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Boolean delete(UUID id_project){
        return projectRepo.deleteProject(id_project);
    }

}
