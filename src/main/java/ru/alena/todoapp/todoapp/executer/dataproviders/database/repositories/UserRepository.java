package ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;

import java.util.UUID;

@Repository
public
interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
