package ru.alena.todoapp.todoapp.executer.usecase.usermanage;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.CreateUserHttpRequest;

import java.time.LocalDateTime;

@Service
public class UserCreateUseCase {

    private final UserRepository userRepository;

    public UserCreateUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(CreateUserHttpRequest request) {
        User newUser = User.builder()
                .username(request.getUsername())
                .cryptoPassword(encryptPassword(request.getPassword()))
                .email(request.getEmail())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return userRepository.save(newUser);
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.encode(password);
    }
}
