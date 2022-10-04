package ru.alena.todoapp.todoapp.executer.entrypoints.http.responce;

import lombok.*;

import java.util.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AreaEntityResponse {

    private String userUUID;
    private Integer areaCount;
    private List<AreaCommonResponse> areas;
}
