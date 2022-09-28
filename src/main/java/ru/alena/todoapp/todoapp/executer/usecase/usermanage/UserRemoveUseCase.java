package ru.alena.todoapp.todoapp.executer.usecase.usermanage;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserCommonResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.*;

import java.time.LocalDateTime;
import java.util.*;

import static ru.alena.todoapp.todoapp.Utils.*;

@Service
public class UserRemoveUseCase {

    private final UserRepository repository;

    public UserRemoveUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserCommonResponse execute(String userId) throws InvalidUserDateException, UserNotFoundException {

        if (isStringUUID(userId)) {
            Optional<User> userOptional = repository.findById(UUID.fromString(userId));

            if (userOptional.isPresent()) {
                User userFromDb = userOptional.get();
                if (userFromDb.getDeletedAt() == null) {
                    userFromDb.setDeletedAt(LocalDateTime.now());
                    repository.save(userFromDb);
                    return UserCommonResponse.builder()
                            .status(HttpStatus.OK.getReasonPhrase())
                            .message("User with id " + userId + " was deleted.")
                            .date(LocalDateTime.now()).build();
                } else {
                    throw new InvalidUserDateException("User with id " + userId + " already deleted.");
                }
            } else {
                throw new UserNotFoundException(userId);
            }
        } else throw new UserNotFoundException(userId);
    }
}
