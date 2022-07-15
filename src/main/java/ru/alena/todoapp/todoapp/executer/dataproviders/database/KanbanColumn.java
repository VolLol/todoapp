package ru.alena.todoapp.todoapp.executer.dataproviders.database;

import java.time.LocalDateTime;
import java.util.UUID;


public class KanbanColumn {

    private UUID kanbanColumnId;

    private UUID projectId;

    private Integer orderNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
