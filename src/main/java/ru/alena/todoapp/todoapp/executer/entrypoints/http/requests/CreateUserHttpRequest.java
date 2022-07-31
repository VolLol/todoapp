package ru.alena.todoapp.todoapp.executer.entrypoints.http.requests;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserHttpRequest {

    private String username;
    private String email;
    private String password;

}
