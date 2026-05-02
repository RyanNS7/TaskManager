package br.com.project.TaskManager.src.services.usecases.project;

import br.com.project.TaskManager.src.entities.Project;
import br.com.project.TaskManager.src.services.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindProjectService {

    private final ProjectRepository projectRepo;

    public FindProjectService(ProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Project find(UUID project_id){
        return projectRepo.findProjectByID(project_id);
    }
}
