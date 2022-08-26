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
                    @ApiResponse(responseCode = "201", description = "The user has been created", content = @Content(schema = @Schema(implementation = UserEntityResponse.class))),
                    @ApiResponse(responseCode = "400", description = "The user used a non-valid value", content = @Content(schema = @Schema(implementation = UserCommonResponse.class)))
            })
    UserEntityResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException;

    @Operation(summary = "Edit user by id", tags = {"User controller"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "The user has been updated mood field", content = @Content(schema = @Schema(implementation = UserEntityResponse.class))),
                    @ApiResponse(responseCode = "400", description = "The user used a non-valid value", content = @Content(schema = @Schema(implementation = UserCommonResponse.class))),
                    @ApiResponse(responseCode = "404", description = "The user with this id does not exist", content = @Content(schema = @Schema(implementation = UserCommonResponse.class)))
            })
    UserEntityResponse userEditMood(@RequestBody UserEditHttpRequest request, @PathVariable(name = "userId") String userId) throws InvalidUserDateException, UserNotFoundException;

    @Operation(summary = "Remove user by id", tags = {"User controller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user has been removed"),
            @ApiResponse(responseCode = "400", description = "The user used invalid data"),
            @ApiResponse(responseCode = "404", description = "The user with the given id was not found")
    })
    UserCommonResponse userRemove(@RequestParam String userId) throws InvalidUserDateException, UserNotFoundException;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All users have been displayed")})
    @Operation(summary = "Search all users", tags = {"User controller"})
    @GetMapping("user/search")
    UserSearchResponse showAllUsers();
}
