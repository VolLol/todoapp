package ru.alena.todoapp.todoapp.executer.usecase.areamanage;

import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.AreaRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.responce.*;
import ru.alena.todoapp.todoapp.executer.usecase.usermanage.exceptions.InvalidUserDateException;

import java.util.*;

import static ru.alena.todoapp.todoapp.Utils.*;

@Service
public class AreaSearchUsecase {

    private final AreaRepository areaRepository;

    public AreaSearchUsecase(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public AreaEntityResponse execute(String userId) throws InvalidUserDateException {
        if (isStringUUID(userId)) {
            List<AreaCommonResponse> userAreas = areaRepository.findAllByUserFkId(UUID.fromString(userId))
                    .stream().map(area -> AreaCommonResponse.builder()
                            .userId(userId)
                            .areaId(area.getAreaId().toString())
                            .role(area.getRole())
                            .createdAt(area.getCreatedAt())
                            .updatedAt(area.getUpdatedAt())
                            .deletedAt(area.getDeletedAt())
                            .build()).toList();

            return AreaEntityResponse.builder()
                    .userUUID(userId)
                    .areaCount(userAreas.size())
                    .areas(userAreas)
                    .build();
        } else throw new InvalidUserDateException(userId);
    }
}
