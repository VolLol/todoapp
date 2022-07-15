package ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.enums.PriorityType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "projects")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "task_id", updatable = false, nullable = false, length = 36)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID taskId;

    @Column(name = "project_fk_id", updatable = false, nullable = false, length = 36)
    private UUID projectFkId;

    @Column(nullable = false, length = 2048)
    private String summary;

    @Column(nullable = false)
    private LocalDateTime dueTime;

    @Column(name = "priority", nullable = false)
    private PriorityType priority;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private Integer orderNumber;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private LocalDateTime deletedAt;

}
