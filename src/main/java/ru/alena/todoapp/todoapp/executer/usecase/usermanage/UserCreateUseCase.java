package ru.alena.todoapp.todoapp.executer.usecase.usermanage;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.*;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.CreateUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserEntityResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;

import java.time.LocalDateTime;
import java.util.UUID;

import static ru.alena.todoapp.todoapp.Utils.*;

@Service
public class UserCreateUseCase {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;
    private final AreaRepository areaRepository;

    public UserCreateUseCase(UserRepository userRepository, AreaRepository areaRepository) {
        this.userRepository = userRepository;
        this.areaRepository = areaRepository;
    }

    public UserEntityResponse execute(CreateUserHttpRequest request) throws InvalidUserDateException {

        if (!isUsernameCorrect(request.getUsername()))
            throw new InvalidUserDateException("username");
        if (!isEmailCorrect(request.getEmail()))
            throw new InvalidUserDateException("email");
        if (!isPasswordCorrect(request.getPassword()))
            throw new InvalidUserDateException("password");

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new InvalidUserDateException("Username already exists.");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
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

        UUID userId = userRepository.save(newUser).getUserId();

        areaRepository.save(
                Area.builder()
                        .role("OWNER_AREA")
                        .userFkId(userId)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );

        return UserEntityResponse.builder()
                .username(newUser.getUsername())
                .email(newUser.getEmail())
                .mood(newUser.getMood())
                .createdAt(newUser.getCreatedAt())
                .updatedAt(newUser.getUpdatedAt())
                .build();
    }
}
