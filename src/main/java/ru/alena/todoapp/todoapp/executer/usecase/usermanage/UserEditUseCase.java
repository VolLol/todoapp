package ru.alena.todoapp.todoapp.executer.usecase.usermanage;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.EditUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserCommonResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.*;

import java.time.LocalDateTime;
import java.util.*;

import static ru.alena.todoapp.todoapp.Utils.*;
import static ru.alena.todoapp.todoapp.executer.usecase.usermanage.EditedField.*;

@Service
public class UserEditUseCase {

    private final UserRepository repository;

    public UserEditUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserCommonResponse execute(EditUserHttpRequest request) throws InvalidUserDateException, UserNotFoundException {
        isEditedFieldValid(request.getFieldName());

        try {
            UUID id = UUID.fromString(request.getUserId());

            Optional<User> userFromDb = repository.findById(id);

            if (userFromDb.isPresent()) {
                User editedUser = userFromDb.get();

                String fieldName = request.getFieldName().toUpperCase();
                String newValue = request.getNewValue();

                if (fieldName.equalsIgnoreCase(USERNAME.name())) {
                    if (isUsernameCorrect(newValue)) {
                        editedUser.setUsername(newValue);
                    } else {
                        throw new InvalidUserDateException("username");
                    }
                }

                if (fieldName.equalsIgnoreCase(EMAIL.name())) {
                    if (isEmailCorrect(newValue)) {
                        editedUser.setEmail(newValue);
                    } else {
                        throw new InvalidUserDateException("email");
                    }
                }

                if (fieldName.equalsIgnoreCase(PASSWORD.name())) {
                    if (isPasswordCorrect(newValue)) {
                        editedUser.setCryptoPassword(encryptPassword(newValue));
                    } else {
                        throw new InvalidUserDateException("password");
                    }
                }

                editedUser.setUpdatedAt(LocalDateTime.now());
                repository.save(editedUser);

                return UserCommonResponse.builder()
                        .status(HttpStatus.OK.getReasonPhrase())
                        .message("User change " + request.getFieldName() + " successful.")
                        .date(LocalDateTime.now()).build();
            } else {
                throw new UserNotFoundException(request.getUserId());
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidUserDateException("user id not UUID");
        }
    }

    private void isEditedFieldValid(String fieldName) throws InvalidUserDateException {
        try {
            valueOf(fieldName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidUserDateException("Field " + fieldName + " not exist");
        }
    }
}
