package br.com.project.TaskManager.src.services.repositories;

import br.com.project.TaskManager.src.entities.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository {

    User createUser(User user);
    User findUser(UUID userID);
    User findByEmail(String email);

}
