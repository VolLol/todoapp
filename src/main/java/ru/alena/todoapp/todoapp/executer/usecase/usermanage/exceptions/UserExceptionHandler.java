package ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.UserCommonResponse;

import java.time.LocalDateTime;

@ControllerAdvice("ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers")
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidUserDateException.class)
    @ResponseBody
    public ResponseEntity<UserCommonResponse> handleInvalidUserDate(InvalidUserDateException e) {
        UserCommonResponse response = new UserCommonResponse(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "User is using invalid data: " + e.getTarget(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public ResponseEntity<UserCommonResponse> handleUserNotFound(UserNotFoundException e) {
        UserCommonResponse response = new UserCommonResponse(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                "User with id = " + e.getUserId() + " not exist",
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
