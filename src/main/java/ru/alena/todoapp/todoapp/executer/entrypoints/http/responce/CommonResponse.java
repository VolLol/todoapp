package ru.alena.todoapp.todoapp.executer.entrypoints.http.responce;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CommonResponse {

    private String status;

    private String message;

    private LocalDateTime date;
}

