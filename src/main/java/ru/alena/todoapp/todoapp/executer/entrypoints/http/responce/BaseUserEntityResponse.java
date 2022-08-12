package ru.alena.todoapp.todoapp.executer.entrypoints.http.responce;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseUserEntityResponse {

    @Schema(example = "Bob Dilan")
    private String username;

    @Schema(example = "bobDilan@oldMail.com")
    private String email;
}
