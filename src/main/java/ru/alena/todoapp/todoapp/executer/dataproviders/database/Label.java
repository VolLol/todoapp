package ru.alena.todoapp.todoapp.executer.dataproviders.database;

import java.time.LocalDateTime;
import java.util.UUID;

public class Label {

    private UUID labelId;

    private UUID areaId;

    private String title;

    private String color;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
