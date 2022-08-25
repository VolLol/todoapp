package ru.alena.todoapp.todoapp.executer.entrypoints.http.responce;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserSearchResponse {

    @Schema(example = "Founded following users")
    private String title;

    @Schema(example = "1")
    private Integer count;

    private List<BaseUserEntityResponse> users;
}
