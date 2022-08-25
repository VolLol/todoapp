package ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes;


import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "user_id", unique = true, updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "crypto_password", nullable = false)
    private String cryptoPassword;

    @Column(unique = true, nullable = false, length = 512)
    @Pattern(regexp = "^[A-Za-z\\d+_.-]+@(.+)$")
    private String email;

    private String mood;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;

}
