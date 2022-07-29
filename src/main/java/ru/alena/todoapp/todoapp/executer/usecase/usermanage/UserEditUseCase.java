package ru.alena.todoapp.todoapp.executer.usecase.usermanage;

import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.RequestUserEdit;

@Service
public class UserEditUseCase {

    private final UserRepository repository;

    public UserEditUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(RequestUserEdit request){


    }
}
