package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import org.springframework.web.bind.annotation.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.*;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.*;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.*;

@RestController
public class UserHttpController implements IUserHttpController {

    private final UserCreateUseCase userCreateUsecase;
    private final UserEditUseCase userEditUsecase;

    private final UserRemoveUseCase userRemoveUsecase;

    private final UserSearchUseCase userShowAllUsecase;

    public UserHttpController(UserCreateUseCase userCreateUsecase, UserEditUseCase userEditUseCase, UserRemoveUseCase userRemoveUsecase, UserSearchUseCase userShowAllUsecase) {
        this.userCreateUsecase = userCreateUsecase;
        this.userEditUsecase = userEditUseCase;
        this.userRemoveUsecase = userRemoveUsecase;
        this.userShowAllUsecase = userShowAllUsecase;
    }

    @PostMapping("user/new")
    public UserCommonResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException {
        return userCreateUsecase.execute(user);
    }

    @PutMapping("user/edit")
    public UserCommonResponse userEdit(@RequestBody EditUserHttpRequest request) throws InvalidUserDateException, UserNotFoundException {
        return userEditUsecase.execute(request);
    }

    @PostMapping("user/remove")
    public UserCommonResponse userRemove(@RequestParam(name = "id") String userUUID) throws InvalidUserDateException, UserNotFoundException {
        return userRemoveUsecase.execute(userUUID);
    }

    public UserSearchResponse showAllUsers() {
        return userShowAllUsecase.execute();
    }
}

