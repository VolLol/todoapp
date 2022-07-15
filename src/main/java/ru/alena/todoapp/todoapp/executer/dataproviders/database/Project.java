package ru.alena.todoapp.todoapp.executer.dataproviders.database;

import ru.alena.todoapp.todoapp.executer.dataproviders.database.enums.ProjectTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class Project {

    private UUID projectId;

    private UUID areaId;

    private String title;

    private ProjectTypeEnum type;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
