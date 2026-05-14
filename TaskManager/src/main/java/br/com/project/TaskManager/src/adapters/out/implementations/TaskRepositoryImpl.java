package br.com.project.TaskManager.src.adapters.out.implementations;

import br.com.project.TaskManager.src.Status;
import br.com.project.TaskManager.src.entities.Task;
import br.com.project.TaskManager.src.exceptions.NotFoundException;
import br.com.project.TaskManager.src.infra.models.TaskModel;
import br.com.project.TaskManager.src.infra.repositories.ProjectRepositoriesDB;
import br.com.project.TaskManager.src.infra.repositories.TaskRepositoriesDB;
import br.com.project.TaskManager.src.services.repositories.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskRepositoriesDB taskRepositoriesDB;
    private final ProjectRepositoriesDB projectRepositoriesDB;

    public TaskRepositoryImpl(TaskRepositoriesDB taskRepositoriesDB, ProjectRepositoriesDB projectRepositoriesDB) {
        this.taskRepositoriesDB = taskRepositoriesDB;
        this.projectRepositoriesDB = projectRepositoriesDB;
    }

    @Override
    public Task createTask(Task task, UUID projectId) {
        if(!projectRepositoriesDB.existsById(projectId)){
            throw new NotFoundException("Project not found");
        }

        TaskModel taskModel = new TaskModel();
        taskModel.setDescription(task.getDescription());
        taskModel.setStatus(Status.AVAIABLE);
        taskModel.setTitle(task.getTitle());
        taskModel.setProject(projectRepositoriesDB.getReferenceById(projectId));

        TaskModel saved = taskRepositoriesDB.save(taskModel);

        Task taskCreated = new Task();
        taskCreated.setTask_id(saved.getId());
        taskCreated.setDescription(saved.getDescription());
        taskCreated.setStatus(saved.getStatus());
        taskCreated.setTitle(saved.getTitle());

        return taskCreated;

    }

    @Override
    public Boolean deleteTask(UUID idTask) {
        if(!taskRepositoriesDB.existsById(idTask)){
            throw new NotFoundException("Task not Found");
        }

        taskRepositoriesDB.deleteById(idTask);

        return true;
    }

    @Override
    public Task findTask(UUID idTask) {
        TaskModel taskFound = taskRepositoriesDB.findById(idTask).orElseThrow(() -> new NotFoundException("Task Not Found"));

        Task task = new Task();
        task.setTask_id(taskFound.getId());
        task.setDescription(taskFound.getDescription());
        task.setStatus(taskFound.getStatus());
        task.setTitle(taskFound.getTitle());

        return task;
    }

    @Override
    public Task updateTask(Task task) {

        TaskModel existingTask = taskRepositoriesDB.findById(task.getTask_id()).orElseThrow(() -> new NotFoundException("Task Not Found"));

        if(task.getTitle() != null){
            existingTask.setTitle(task.getTitle());
        }

        if(task.getDescription() != null){
            existingTask.setDescription(task.getDescription());
        }

        if(task.getStatus() != null){
            existingTask.setStatus(task.getStatus());
        }

        TaskModel savedTask = taskRepositoriesDB.save(existingTask);

        System.out.println(savedTask.getStatus());

        Task updated = new Task();
        updated.setTask_id(savedTask.getId());
        updated.setDescription(savedTask.getDescription());
        updated.setStatus(savedTask.getStatus());
        updated.setTitle(savedTask.getTitle());

        return updated;
    }
}
