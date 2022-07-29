package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.RequestCreateUser;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.RequestUserEdit;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.*;

import java.util.List;

@RestController
public class UserHttpController {

    private final UserCreateUseCase userCreateUseCase;
    private final UserEditUseCase userEditUserCase;

    private final UserRemoveUseCase userRemoveUseCase;

    private final UserSearchUseCase userSearchUseCase;

    private final UserShowAllUseCase userShowAllUseCase;

    public UserHttpController(UserCreateUseCase userCreateUseCase, UserEditUseCase userEditUseCase, UserRemoveUseCase userRemoveUseCase, UserSearchUseCase userSearchUseCase, UserShowAllUseCase userShowAllUseCase) {
        this.userCreateUseCase = userCreateUseCase;
        this.userEditUserCase = userEditUseCase;
        this.userRemoveUseCase = userRemoveUseCase;
        this.userSearchUseCase = userSearchUseCase;
        this.userShowAllUseCase = userShowAllUseCase;
    }

    @PostMapping("user/new")
    @ResponseStatus(code = HttpStatus.OK)
    void userCreate(@RequestBody RequestCreateUser user) {
        userCreateUseCase.execute(user);
    }

    @PutMapping("user/edit")
    @ResponseStatus(code = HttpStatus.OK)
    void userEdit(@RequestBody RequestUserEdit request) {
        userEditUserCase.execute(request);
    }

    @DeleteMapping("users/delete")
    @ResponseStatus(code = HttpStatus.OK)
    void showUsers() {
        userRemoveUseCase.execute();
    }

    @GetMapping("user/all")
    List<User> showAllUsers() {
        return userShowAllUseCase.execute();
    }

    @GetMapping("user/search")
    List<User> searchUsers() {
        return userSearchUseCase.execute();
    }
}

