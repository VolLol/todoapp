--liquibase formatted sql
--changeset Alena:create kanban columns table

CREATE TABLE IF NOT EXISTS
    kanban_columns
(
    kanban_column_id       uuid not null primary key,
    title varchar(255),
    project_fk_id uuid not null,
    FOREIGN KEY (project_fk_id) REFERENCES projects (project_id),
    order_number  int,
    created_at    timestamp,
    deleted_at    timestamp,
    updated_at    timestamp
);