package ru.alena.todoapp.todoapp.executer.dataproviders.database;

import java.time.LocalDateTime;
import java.util.UUID;

public class Area {

    private UUID areaId;

    private UUID userFkId;

    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
