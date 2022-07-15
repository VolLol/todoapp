package ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "task_comments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskComment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "task_comment_id", updatable = false, nullable = false, length = 36)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID taskCommentId;

    @Column(name = "task_id", updatable = false, nullable = false, length = 36)
    private UUID taskId;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private LocalDateTime deletedAt;

}
