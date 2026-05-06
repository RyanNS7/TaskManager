package br.com.project.TaskManager.src.adapters.out.implementations;

import br.com.project.TaskManager.src.entities.Project;
import br.com.project.TaskManager.src.exceptions.InternalServerError;
import br.com.project.TaskManager.src.exceptions.NotFoundException;
import br.com.project.TaskManager.src.infra.models.ProjectModel;
import br.com.project.TaskManager.src.infra.repositories.ProjectRepositoriesDB;
import br.com.project.TaskManager.src.services.repositories.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private final ProjectRepositoriesDB projectRepoDB;

    public ProjectRepositoryImpl(ProjectRepositoriesDB projectRepoDB) {
        this.projectRepoDB = projectRepoDB;
    }

    @Override
    public Project createProject(Project project) {
        try{

            ProjectModel projectDB = new ProjectModel();
            projectDB.setProjectName(project.getNameProject());

            ProjectModel saved = projectRepoDB.save(projectDB);

            Project projectCreated = new Project();
            projectCreated.setId(saved.getId());
            projectCreated.setNameProject(saved.getProjectName());

            return projectCreated;

        } catch (Exception e) {
            throw new InternalServerError(e.getMessage());
        }
    }

    @Override
    public Boolean deleteProject(UUID id_project) {
        try{

            if(!projectRepoDB.existsById(id_project)){
                throw new NotFoundException("Project Not Found");
            }

            projectRepoDB.deleteById(id_project);
            return true;

        } catch (NotFoundException e) {
            throw e;
        }catch (Exception e){
            throw new InternalServerError("Error while trying to delete the project.");
        }
    }

    @Override
    public Project findProjectByID(UUID id_project) {
        ProjectModel projectFinded = projectRepoDB.findById(id_project).orElseThrow(() -> new NotFoundException("Project Not Found"));

        Project project = new Project();
        project.setNameProject(projectFinded.getProjectName());
        project.setId(projectFinded.getId());

        return project;
    }
}
