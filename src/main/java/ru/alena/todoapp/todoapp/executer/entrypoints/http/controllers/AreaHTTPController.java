package ru.alena.todoapp.todoapp.executer.entrypoints.http.controllers;

import org.springframework.web.bind.annotation.*;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.AreaEntityResponse;
import ru.alena.todoapp.todoapp.executer.usecase.areamanage.AreaSearchUsecase;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;

@RestController
@RequestMapping("areas")
public class AreaHTTPController implements IAreaHTTPController {

    private final AreaSearchUsecase areaSearchUsecase;

    public AreaHTTPController(AreaSearchUsecase areaSearchUsecase) {
        this.areaSearchUsecase = areaSearchUsecase;
    }

    @GetMapping("/search/{userId}")
    @Override
    public AreaEntityResponse searchArea(@PathVariable String userId) throws InvalidUserDateException {
        return areaSearchUsecase.execute(userId);
    }
}
