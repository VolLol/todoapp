package ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "kanban_column_task_m2m")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KanbanColumnTaskM2M {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "kanban_column_task_m2m_id", updatable = false, nullable = false, length = 36)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID kanbanColumnTaskM2mId;

    @Column(name = "task_fk_id", updatable = false, nullable = false, length = 36)
    private UUID taskId;

    @Column(name = "kanban_column_id", updatable = false, nullable = false, length = 36)
    private UUID kanbanColumnId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private LocalDateTime deletedAt;

}
