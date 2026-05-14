package br.com.project.TaskManager.src.services.repositories;

import br.com.project.TaskManager.src.entities.Group;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository {

    Group createGroup(Group group);
    Group findGroup(UUID groupID);
    Group deleteGroup(UUID groupID);

}
