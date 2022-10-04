package ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.Area;

import java.util.*;

@Repository
public
interface AreaRepository extends JpaRepository<Area, UUID> {

    List<Area> findAllByUserFkId(UUID userFkId);

}
