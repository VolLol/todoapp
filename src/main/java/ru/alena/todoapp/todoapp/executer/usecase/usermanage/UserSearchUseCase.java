package ru.alena.todoapp.todoapp.executer.usecase.usermanage;

import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserSearchUseCase {

    private final UserRepository repository;

    public UserSearchUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> execute() {
        return Collections.emptyList();
    }
}
