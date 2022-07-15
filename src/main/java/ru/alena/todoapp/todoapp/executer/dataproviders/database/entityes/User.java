package ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Please, set here the username")
    private String username;

    @Column(name = "crypto_password", nullable = false)
    private String cryptoPassword;

    @Column(unique = true, nullable = false, length = 512)
    @Pattern(regexp = "^[A-Za-z\\d+_.-]+@(.+)$")
    @NotNull(message = "Please, set here the user email")
    private String email;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime deletedAt;

}
