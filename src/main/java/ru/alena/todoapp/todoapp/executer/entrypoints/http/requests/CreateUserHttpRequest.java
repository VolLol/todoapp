package ru.alena.todoapp.todoapp.executer.entrypoints.http.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserHttpRequest {

    @Schema(example = "Margo")
    private String username;

    @Schema(example = "Amazing mood!")
    private String mood;

    @Schema(example = "margo@mail.com")
    private String email;

    @Schema(example = "margoPassword")
    private String password;

}
