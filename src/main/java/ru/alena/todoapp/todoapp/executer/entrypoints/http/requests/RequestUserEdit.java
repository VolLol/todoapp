package ru.alena.todoapp.todoapp.executer.entrypoints.http.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class RequestUserEdit {

    private UUID userId;

    private String fieldName;

    private String newValue;
}
