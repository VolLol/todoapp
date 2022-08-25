package ru.alena.todoapp.todoapp.executer.entrypoints.http.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditUserHttpRequest {

    @Schema(example = "94f6f4a7-9be2-420b-bbf9-39336cbbacf8")
    private String userId;

    @Schema(example = "password")
    private String fieldName;

    @Schema(example = "newPassword")
    private String newValue;
}
