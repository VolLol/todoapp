--liquibase formatted sql
--changeset Alena:create task_label_m2m table

CREATE TABLE IF NOT EXISTS
    task_label_m2m
(
    task_label_m2m_id       uuid not null primary key,
    task_fk_id uuid not null,
    FOREIGN KEY (task_fk_id) REFERENCES tasks (task_id),

    label_fk_id uuid not null,
    FOREIGN KEY (label_fk_id) REFERENCES labels (label_id),
    created_at    timestamp,
    deleted_at    timestamp,
    updated_at    timestamp
);