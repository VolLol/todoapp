--liquibase formatted sql
--changeset Alena:create kanban column task m2m table

CREATE TABLE IF NOT EXISTS
    kanban_column_task_m2m
(
    kanban_column_task_m2m_id       uuid not null primary key,
    task_fk_id uuid not null,
    FOREIGN KEY (task_fk_id) REFERENCES tasks (task_id),
    kanban_column_id uuid not null,
    FOREIGN KEY (kanban_column_id) REFERENCES kanban_columns (kanban_column_id),
    created_at    timestamp,
    deleted_at    timestamp,
    updated_at    timestamp
);