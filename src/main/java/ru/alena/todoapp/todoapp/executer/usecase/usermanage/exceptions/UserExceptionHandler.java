package ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
                e.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
