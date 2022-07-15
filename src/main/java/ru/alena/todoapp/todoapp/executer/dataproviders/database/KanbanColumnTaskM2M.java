package ru.alena.todoapp.todoapp.executer.dataproviders.database;

import java.time.LocalDateTime;
import java.util.UUID;

public class KanbanColumnTaskM2M {

    private UUID kanbanColumnTaskM2mId;

    private UUID taskId;

    private UUID kanbanColumn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
