package ru.alena.todoapp.todoapp.executer.entrypoints.http.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEditHttpRequest {

    @Schema(example = "New mood")
    private String mood;

}
