package ru.alena.todoapp.todoapp.executer.dataproviders.database;

import ru.alena.todoapp.todoapp.executer.dataproviders.database.enums.PriorityType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {

    private UUID taskId;

    private UUID projectId;

    private String summary;

    private LocalDateTime dueTime;

    private PriorityType priority;

    private String details;

    private Integer orderNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
