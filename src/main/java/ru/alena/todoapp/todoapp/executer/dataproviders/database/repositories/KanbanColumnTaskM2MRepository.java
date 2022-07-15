package ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.KanbanColumnTaskM2M;

import java.util.UUID;

@Repository
public
interface KanbanColumnTaskM2MRepository extends JpaRepository<KanbanColumnTaskM2M, UUID> {

}
