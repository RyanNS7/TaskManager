package br.com.project.TaskManager.src.security;

import br.com.project.TaskManager.src.infra.models.UserModel;
import br.com.project.TaskManager.src.infra.repositories.UserRepositoriesDB;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepositoriesDB userRepo;

    public UserDetailsServiceImpl(UserRepositoriesDB userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = userRepo.findByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("The user was not found.");
        }

        return new UserDetailsImpl(user);
    }
}
