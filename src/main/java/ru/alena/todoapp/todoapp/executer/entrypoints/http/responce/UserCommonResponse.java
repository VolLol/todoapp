package ru.alena.todoapp.todoapp.executer.entrypoints.http.responce;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class UserCommonResponse {

    @Schema(example = "Bad request")
    private String status;

    @Schema(example = "User use invalid date")
    private String message;

    @Schema(example = "2022-08-12T12:59:44.2121825")
    private LocalDateTime date;
}

