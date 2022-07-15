package ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.TaskLabelM2m;

import java.util.UUID;

@Repository
public
interface TaskLableM2mRepository extends JpaRepository<TaskLabelM2m, UUID> {

}
