--liquibase formatted sql
--changeset Alena:create project table


CREATE TYPE prtype AS ENUM ('SIMPLE_LIST', 'KANBAN');


CREATE TABLE IF NOT EXISTS
    projects
(
    project_id         uuid not null
        primary key,
    title VARCHAR(255),
    area_fk_id         uuid not null,
    FOREIGN KEY(area_fk_id) REFERENCES areas(area_id),
    project_type          prtype,
    created_at      timestamp,
    deleted_at      timestamp,
    updated_at      timestamp
);