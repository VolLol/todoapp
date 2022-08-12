package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

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

    private final UserCreateUseCase userCreateUseCase;
    private final UserEditUseCase userEditUserCase;

    private final UserRemoveUseCase userRemoveUseCase;

    private final UserShowAllCase userShowAllUsecase;


    public UserHttpController(UserCreateUseCase userCreateUseCase, UserEditUseCase userEditUseCase, UserRemoveUseCase userRemoveUseCase, UserShowAllCase userShowAllUsecase) {
        this.userCreateUseCase = userCreateUseCase;
        this.userEditUserCase = userEditUseCase;
        this.userRemoveUseCase = userRemoveUseCase;
        this.userShowAllUsecase = userShowAllUsecase;
    }

    @PostMapping("user/new")
    public UserCommonResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException {
        return userCreateUseCase.execute(user);
    }

    @PutMapping("user/edit")
    @ResponseBody
    public UserCommonResponse userEdit(@RequestBody EditUserHttpRequest request) throws InvalidUserDateException, UserNotFoundException {
        return userEditUserCase.execute(request);
    }

    @PostMapping("user/remove")
    public UserCommonResponse userRemove(@RequestParam(name = "id") String userUUID) throws InvalidUserDateException, UserNotFoundException {
        return userRemoveUseCase.execute(userUUID);
    }

    @Override
    @GetMapping("user/search{removed}")
    public UserSearchResponse showAllUsers(@RequestParam(name = "removed") Boolean removed) {
        return userShowAllUsecase.execute(removed);
    }
}

