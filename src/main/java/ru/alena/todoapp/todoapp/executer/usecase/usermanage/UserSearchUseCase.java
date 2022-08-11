package ru.alena.todoapp.todoapp.executer.usecase.usermanage;

import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.SimpleUserForResponse;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserSearchResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSearchUseCase {

    private final UserRepository repository;

    public UserSearchUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserSearchResponse execute(Boolean removed) {
        List<User> userList = repository.findAll();

        if (!userList.isEmpty()) {
            List<SimpleUserForResponse> simpleUsers;
            String title;
            if (removed) {
                simpleUsers = userList.stream()
                        .filter(user -> user.getDeletedAt() == null)
                        .map(u -> new SimpleUserForResponse(u.getUsername(), u.getEmail()))
                        .collect(Collectors.toList());
                title = "List of non-deleted users";
            } else {
                simpleUsers = userList.stream()
                        .map(u -> new SimpleUserForResponse(u.getUsername(), u.getEmail()))
                        .collect(Collectors.toList());
                title = "Founded following users";
            }
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
