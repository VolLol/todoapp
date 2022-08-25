package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.web.bind.annotation.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.CreateUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.EditUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserCommonResponse;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserSearchResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.UserNotFoundException;

public interface IUserHttpController {

    @Operation(summary = "Create new user", tags = {"User controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The user was created"),
            @ApiResponse(responseCode = "400", description = "The user used invalid data")
    })
    UserCommonResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException;

    @Operation(summary = "Edit user", tags = {"User controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User data has been changed"),
            @ApiResponse(responseCode = "400", description = "The user used invalid data"),
            @ApiResponse(responseCode = "404", description = "The user with the given id was not found")
    })
    UserCommonResponse userEdit(@RequestBody EditUserHttpRequest request) throws InvalidUserDateException, UserNotFoundException;

    @Operation(summary = "Remove user by id", tags = {"User controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user has been removed"),
            @ApiResponse(responseCode = "400", description = "The user used invalid data"),
            @ApiResponse(responseCode = "404", description = "The user with the given id was not found")
    })
    UserCommonResponse userRemove(@RequestParam String userUUID) throws InvalidUserDateException, UserNotFoundException;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All users have been displayed")})
    @Operation(summary = "Search all users", tags = {"User controller"})
    @GetMapping("user/search")
    UserSearchResponse showAllUsers();
}
