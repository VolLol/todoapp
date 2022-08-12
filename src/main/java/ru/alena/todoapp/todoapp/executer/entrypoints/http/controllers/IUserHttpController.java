package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.CreateUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.EditUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserCommonResponse;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserSearchResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.UserNotFoundException;

public interface IUserHttpController {

    UserCommonResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException;

    UserCommonResponse userEdit(@RequestBody EditUserHttpRequest request) throws InvalidUserDateException, UserNotFoundException;

    UserCommonResponse userRemove(@RequestParam String userUUID) throws InvalidUserDateException, UserNotFoundException;

    //UserSearchResponse showAllUsers();

    UserSearchResponse showAllUsers(@PathVariable(required = false) Boolean removed);
}
