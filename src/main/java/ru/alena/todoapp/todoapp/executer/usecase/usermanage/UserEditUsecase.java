package ru.alena.todoapp.todoapp.executer.usecase.usermanage;

import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.UserEditHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserEntityResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.*;

import java.time.LocalDateTime;
import java.util.*;

import static ru.alena.todoapp.todoapp.Utils.*;

@Service
public class UserEditUsecase {
    private final UserRepository repository;

    public UserEditUsecase(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntityResponse execute(UserEditHttpRequest request, String userId) throws InvalidUserDateException, UserNotFoundException {

        if (isStringUUID(userId)) {
            Optional<User> userOptional = repository.findById(UUID.fromString(userId));

            if (userOptional.isPresent()) {
                User userFromDb = userOptional.get();
                User editedUser = User.builder()
                        .mood(request.getMood())
                        .build();
                repository.save(editedUser);
                return UserEntityResponse.builder()
                        .username(userFromDb.getUsername())
                        .email(userFromDb.getEmail())
                        .mood(editedUser.getMood())
                        .createdAt(userFromDb.getCreatedAt())
                        .updatedAt(LocalDateTime.now())
                        .build();
            }
            throw new UserNotFoundException(userId);
        } else throw new InvalidUserDateException(userId);
    }
}