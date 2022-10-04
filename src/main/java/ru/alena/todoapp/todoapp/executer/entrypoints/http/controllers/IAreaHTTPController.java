package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.*;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;

public interface IAreaHTTPController {

    @Operation(summary = "Search areas by user uuid", tags = {"Area controller"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "All areas have been displayed", content = @Content(schema = @Schema(implementation = AreaEntityResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Used invalid uuid", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
            })
    AreaEntityResponse searchArea(String userId) throws InvalidUserDateException;
}
