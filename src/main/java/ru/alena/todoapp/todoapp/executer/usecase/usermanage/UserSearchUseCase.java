package ru.alena.todoapp.todoapp.executer.usecase.usermanage;


import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.*;

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
        if (!userList.isEmpty()) {
            List<BaseUserEntityResponse> simpleUsers = userList.stream()
                    .map(u -> new BaseUserEntityResponse(u.getUsername(), u.getEmail()))
                    .collect(Collectors.toList());
            String title = "Founded following users";

            return UserSearchResponse.builder()
                    .title(title)
                    .count(simpleUsers.size())
                    .users(simpleUsers)
                    .build();
        } else {
            return UserSearchResponse.builder()
                    .title("Users were not found")
                    .build();
        }
    }
}
