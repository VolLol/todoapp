package ru.alena.todoapp.todoapp.executer.entrypoints.http.responce;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BaseUserEntityResponse {

    @Schema(example = "Bob Dilan")
    private String username;

    @Schema(example = "bobDilan@oldMail.com")
    private String email;

    @Schema(example = "My mood")
    private String mood;

    @Schema(example = "2022-05-20 20:56:23.042203")
    private LocalDateTime createdAt;

    @Schema(example = "2022-07-21 10:34:56.056201")
    private LocalDateTime updatedAt;

    @Schema(example = "2022-09-13 10:34:56.054402")
    private LocalDateTime deletedAt;
}
