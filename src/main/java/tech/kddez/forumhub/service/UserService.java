package tech.kddez.forumhub.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.kddez.forumhub.domain.user.User;
import tech.kddez.forumhub.repository.UserRepository;
import tech.kddez.forumhub.domain.user.UserRequestDTO;
import tech.kddez.forumhub.domain.user.UserResponseDTO;
import tech.kddez.forumhub.infra.exception.UsernameAlreadyExistsException;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO request){

        if(repository.findUserByUsername(request.username()).isPresent()){
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        var user = new User(null, request.username(), encoder.encode(request.password()));
        repository.save(user);
        return new UserResponseDTO(user);


    }

    public UserResponseDTO getUser(Long id) {
        var user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return new UserResponseDTO(user);
    }

    public User getAuthenticatedUser(){
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var username = auth.getName();
        return repository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
    }
}
