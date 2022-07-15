package ru.alena.todoapp.todoapp.executer.dataproviders.database;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {

    private UUID userId;

    private String username;

    private String cryptoPassword;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
