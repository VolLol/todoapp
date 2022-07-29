package ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.KanbanColumn;

import java.util.UUID;

@Repository
public
interface KanbanColumnRepository extends JpaRepository<KanbanColumn, UUID> {

}