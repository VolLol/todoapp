package ru.alena.todoapp.todoapp.executer.entrypoints.http.requests;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveUserHttpRequest {

    private String userId;
}
