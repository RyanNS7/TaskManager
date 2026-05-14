package br.com.project.TaskManager.src.services.usecases.login;

import br.com.project.TaskManager.src.entities.User;
import br.com.project.TaskManager.src.exceptions.InsufficientCharactersException;
import br.com.project.TaskManager.src.services.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUserService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public CreateUserService(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public User create(User user){

        if(user.getName().length() < 3){
            throw new InsufficientCharactersException("The characters in the name should contain more letters.");
        }

        if(user.getPassword().length() < 8){
            throw new InsufficientCharactersException("The password must contain at least 8 digits.");
        }

        user.setPassword(encoder.encode(user.getPassword()));

        return userRepo.createUser(user);
    }
}
