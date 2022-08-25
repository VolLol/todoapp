package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.web.bind.annotation.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.*;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.*;

public interface IUserHttpController {

    @Operation(summary = "Create new user", tags = {"User controller"},
            responses = {
                    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = BaseUserEntityResponse.class))),
                    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = UserCommonResponse.class)))
            })
    BaseUserEntityResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException;

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
