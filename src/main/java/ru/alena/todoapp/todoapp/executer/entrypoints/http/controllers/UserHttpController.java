package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.CreateUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.EditUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserCommonResponse;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserSearchResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserCreateUseCase;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserEditUseCase;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserRemoveUseCase;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.UserShowAllCase;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.UserNotFoundException;

@RestController
public class UserHttpController implements IUserHttpController {

    private final UserCreateUseCase userCreateUsecase;
    private final UserEditUseCase userEditUsecase;

    private final UserRemoveUseCase userRemoveUsecase;

    private final UserShowAllCase userShowAllUsecase;


    public UserHttpController(UserCreateUseCase userCreateUsecase, UserEditUseCase userEditUseCase, UserRemoveUseCase userRemoveUsecase, UserShowAllCase userShowAllUsecase) {
        this.userCreateUsecase = userCreateUsecase;
        this.userEditUsecase = userEditUseCase;
        this.userRemoveUsecase = userRemoveUsecase;
        this.userShowAllUsecase = userShowAllUsecase;
    }

    @Operation(summary = "Create new user", tags = {"User controller"})
    @PostMapping("user/new")
    public UserCommonResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException {
        return userCreateUsecase.execute(user);
    }

    @Operation(summary = "Edit user", tags = {"User controller"})
    @PutMapping("user/edit")
    @ResponseBody
    public UserCommonResponse userEdit(@RequestBody EditUserHttpRequest request) throws InvalidUserDateException, UserNotFoundException {
        return userEditUsecase.execute(request);
    }

    @Operation(summary = "Remove user by id", tags = {"User controller"})
    @PostMapping("user/remove")
    public UserCommonResponse userRemove(@RequestParam(name = "id") String userUUID) throws InvalidUserDateException, UserNotFoundException {
        return userRemoveUsecase.execute(userUUID);
    }

    @Operation(summary = "Search all users", tags = {"User controller"})
    @Override
    @GetMapping("user/search")
    public UserSearchResponse showAllUsers() {
        return userShowAllUsecase.execute();
    }
}

