package ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions;

import lombok.Getter;


@Getter
public class UserNotFoundException extends Exception {

    private String userId;

    public UserNotFoundException(String userId) {
        this.userId = userId;
    }
}
