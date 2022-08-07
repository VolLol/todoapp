package ru.alena.todoapp.todoapp.executer.entrypoints.http.responce;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimpleUserForResponse {

    private String username;
    private String email;
}
