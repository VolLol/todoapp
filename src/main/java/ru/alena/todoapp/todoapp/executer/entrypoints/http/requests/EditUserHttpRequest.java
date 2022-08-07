package ru.alena.todoapp.todoapp.executer.entrypoints.http.requests;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditUserHttpRequest {

    private UUID userId;

    private String fieldName;

    private String newValue;
}
