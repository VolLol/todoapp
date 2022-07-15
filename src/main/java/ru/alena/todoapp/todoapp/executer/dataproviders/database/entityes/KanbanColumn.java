package ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "kanban_columns")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KanbanColumn {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "kanban_columns_id", updatable = false, nullable = false, length = 36)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID kanbanColumnId;

    @Column(name = "project_fk_id", updatable = false, nullable = false, length = 36)
    private UUID projectFkId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer orderNumber;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private LocalDateTime deletedAt;

}
