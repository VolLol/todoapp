package ru.alena.todoapp.todoapp.executer.usecase.usermanage;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.EditUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserCommonResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.UserNotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;

import static ru.alena.todoapp.todoapp.Utils.*;

@Service
public class UserEditUseCase {

    private final UserRepository repository;

    public UserEditUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserCommonResponse execute(EditUserHttpRequest request) throws InvalidUserDateException, UserNotFoundException {
        Optional<User> userFromDb = repository.findById(request.getUserId());
        if (isColumnExist(request.getFieldName())) {

            if (userFromDb.isPresent()) {
                User editedUser = userFromDb.get();

                if (request.getFieldName().equals("username")) {
                    if (isUsernameCorrect(request.getNewValue())) {
                        editedUser.setUsername(request.getNewValue());
                    } else {
                        throw new InvalidUserDateException("username");
                    }
                }

                if (request.getFieldName().equals("email")) {
                    if (isEmailCorrect(request.getNewValue())) {
                        editedUser.setEmail(request.getNewValue());
                    } else {
                        throw new InvalidUserDateException("email");
                    }
                }

                if (request.getFieldName().equals("password")) {
                    if (isPasswordCorrect(request.getNewValue())) {
                        editedUser.setCryptoPassword(encryptPassword(request.getNewValue()));
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
                throw new UserNotFoundException(request.getUserId().toString());
            }
        } else {
            throw new InvalidUserDateException("Field " + request.getFieldName() + " not exist");
        }
    }
}
