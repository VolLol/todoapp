package ru.alena.todoapp.todoapp.executer.usecase.usermanage;


import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.CreateUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.BaseUserEntityResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;

import java.time.LocalDateTime;

import static ru.alena.todoapp.todoapp.Utils.*;

@Service
public class UserCreateUseCase {

    private final UserRepository repository;

    public UserCreateUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public BaseUserEntityResponse execute(CreateUserHttpRequest request) throws InvalidUserDateException {

        if (!isUsernameCorrect(request.getUsername()))
            throw new InvalidUserDateException("username");
        if (!isEmailCorrect(request.getEmail()))
            throw new InvalidUserDateException("email");
        if (!isPasswordCorrect(request.getPassword()))
            throw new InvalidUserDateException("password");

        if (repository.existsByUsername(request.getUsername())) {
            throw new InvalidUserDateException("Username already exists.");
        }
        if (repository.existsByEmail(request.getEmail())) {
            throw new InvalidUserDateException("Email already exists.");
        }

        User newUser = User.builder()
                .username(request.getUsername())
                .cryptoPassword(encryptPassword(request.getPassword()))
                .email(request.getEmail())
                .mood(request.getMood())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        repository.save(newUser);

        return BaseUserEntityResponse.builder()
                .username(newUser.getUsername())
                .email(newUser.getEmail())
                .mood(newUser.getMood())
                .createdAt(newUser.getCreatedAt())
                .updatedAt(newUser.getUpdatedAt())
                .build();
    }
}
