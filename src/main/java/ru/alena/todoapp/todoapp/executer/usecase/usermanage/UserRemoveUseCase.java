package ru.alena.todoapp.todoapp.executer.usecase.usermanage;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserCommonResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRemoveUseCase {

    private final UserRepository repository;

    public UserRemoveUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserCommonResponse execute(String userUUID) throws InvalidUserDateException {

        try {
            UUID id = UUID.fromString(userUUID);
            Optional<User> userOptional = repository.findById(id);

            if (userOptional.isPresent()) {
                User userFromDb = userOptional.get();
                if (userFromDb.getDeletedAt() == null) {
                    userFromDb.setDeletedAt(LocalDateTime.now());
                    repository.save(userFromDb);
                    return UserCommonResponse.builder()
                            .status(HttpStatus.OK.getReasonPhrase())
                            .message("User with id " + userUUID + " was deleted.")
                            .date(LocalDateTime.now()).build();
                } else {
                    throw new InvalidUserDateException("User with id " + userUUID + " already deleted.");
                }
            } else {
                throw new InvalidUserDateException("User with id " + userUUID + " not found.");
            }
        } catch (IllegalArgumentException exception) {
            throw new InvalidUserDateException("Not valid user id.");
        }
    }
}
