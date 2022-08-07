package ru.alena.todoapp.todoapp.executer.usecase.usermanage;

import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.SimpleUserForResponse;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserSearchResponse;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSearchUseCase {

    private final UserRepository repository;

    public UserSearchUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserSearchResponse execute() {
        List<User> userList = repository.findAll();
        List<SimpleUserForResponse> simpleUsers = userList.stream()
                .filter(user -> user.getDeletedAt() == null)
                .map(u -> new SimpleUserForResponse(u.getUsername(), u.getEmail()))
                .collect(Collectors.toList());
        if (!simpleUsers.isEmpty()) {
            return UserSearchResponse.builder()
                    .title("Founded following users")
                    .users(simpleUsers)
                    .build();
        } else {
            return UserSearchResponse.builder()
                    .title("Users were not found")
                    .users(Collections.emptyList())
                    .build();
        }


    }
}
