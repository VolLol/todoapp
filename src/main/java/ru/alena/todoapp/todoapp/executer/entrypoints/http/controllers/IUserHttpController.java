package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.CreateUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.EditUserHttpRequest;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserCommonResponse;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserSearchResponse;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;

public interface IUserHttpController {

    UserCommonResponse userCreate(@RequestBody CreateUserHttpRequest user) throws InvalidUserDateException;

    UserCommonResponse userEdit(@RequestBody EditUserHttpRequest request) throws InvalidUserDateException;

    UserCommonResponse userRemove(@RequestBody String userUUID) throws InvalidUserDateException;

    UserSearchResponse showAllUsers();
}
