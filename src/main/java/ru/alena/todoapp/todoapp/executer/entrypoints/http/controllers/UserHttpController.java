package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
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

    @Operation(summary = "Create new user", tags = {"User controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user was created"),
            @ApiResponse(responseCode = "400", description = "The user used invalid data")
    })
    @PostMapping("user/new")
    public UserCommonResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException {
        return userCreateUsecase.execute(user);
    }

    @Operation(summary = "Edit user", tags = {"User controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User data has been changed"),
            @ApiResponse(responseCode = "400", description = "The user used invalid data"),
            @ApiResponse(responseCode = "404", description = "The user with the given id was not found")
    })
    @PutMapping("user/edit")
    public UserCommonResponse userEdit(@RequestBody EditUserHttpRequest request) throws InvalidUserDateException, UserNotFoundException {
        return userEditUsecase.execute(request);
    }

    @Operation(summary = "Remove user by id", tags = {"User controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user has been removed"),
            @ApiResponse(responseCode = "400", description = "The user used invalid data"),
            @ApiResponse(responseCode = "404", description = "The user with the given id was not found")
    })
    @PostMapping("user/remove")
    public UserCommonResponse userRemove(@RequestParam(name = "id") String userUUID) throws InvalidUserDateException, UserNotFoundException {
        return userRemoveUsecase.execute(userUUID);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All users have been displayed")})
    @Operation(summary = "Search all users", tags = {"User controller"})
    @GetMapping("user/search")
    public UserSearchResponse showAllUsers() {
        return userShowAllUsecase.execute();
    }
}

