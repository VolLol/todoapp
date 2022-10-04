package ru.alena.todoapp.todoapp.executer.entrypoints.http.responce;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaCommonResponse {

    private String userId;

    private String areaId;

    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
