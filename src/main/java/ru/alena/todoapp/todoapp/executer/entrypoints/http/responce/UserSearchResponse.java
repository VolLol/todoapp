package ru.alena.todoapp.todoapp.executer.entrypoints.http.responce;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserSearchResponse {

    private String title;

    private List<SimpleUserForResponse> users;
}
