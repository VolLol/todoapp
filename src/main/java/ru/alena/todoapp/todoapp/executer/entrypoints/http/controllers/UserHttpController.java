package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import org.springframework.web.bind.annotation.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.*;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.*;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.*;

@RestController
@RequestMapping("user")
public class UserHttpController implements IUserHttpController {

    private final UserCreateUseCase userCreateUsecase;

    private final UserRemoveUseCase userRemoveUsecase;

    private final UserSearchUseCase userShowAllUsecase;

    private final UserEditUsecase userEditUsecase;

    public UserHttpController(UserCreateUseCase userCreateUsecase, UserRemoveUseCase userRemoveUsecase, UserSearchUseCase userShowAllUsecase, UserEditUsecase userEditUsecase) {
        this.userCreateUsecase = userCreateUsecase;
        this.userRemoveUsecase = userRemoveUsecase;
        this.userShowAllUsecase = userShowAllUsecase;
        this.userEditUsecase = userEditUsecase;
    }

    @PostMapping("/new")
    public UserEntityResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException {
        return userCreateUsecase.execute(user);
    }

    @PutMapping("/edit/{userId}")
    public UserEntityResponse userEditMood(@RequestBody UserEditHttpRequest request, @PathVariable(name = "userId") String userId) throws InvalidUserDateException, UserNotFoundException {
        return userEditUsecase.execute(request, userId);
    }

    @PostMapping("/remove")
    public UserCommonResponse userRemove(@RequestParam(name = "id") String userUUID) throws InvalidUserDateException, UserNotFoundException {
        return userRemoveUsecase.execute(userUUID);
    }

    public UserSearchResponse showAllUsers() {
        return userShowAllUsecase.execute();
    }
}

