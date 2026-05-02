package br.com.project.TaskManager.src.infra.repositories;

import br.com.project.TaskManager.src.infra.models.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepositoriesDB extends JpaRepository<ProjectModel, UUID> {

    ProjectModel save(ProjectModel project);

}
