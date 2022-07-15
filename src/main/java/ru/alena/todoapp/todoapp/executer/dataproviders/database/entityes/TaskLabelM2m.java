package ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "task_label_m2m")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskLabelM2m {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "task_label_m2m_id", updatable = false, nullable = false, length = 36)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID taskLabelM2mId;

    @Column(name = "task_fk_id", updatable = false, nullable = false, length = 36)
    private UUID taskId;

    @Column(name = "label_id", updatable = false, nullable = false, length = 36)
    private UUID labelId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private LocalDateTime deletedAt;

}
