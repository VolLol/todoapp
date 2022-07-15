--liquibase formatted sql
--changeset Alena:create task comments table

CREATE TABLE IF NOT EXISTS
    task_comments
(
    task_comment_id uuid not null primary key,
    task_fk_id      uuid not null,
    FOREIGN KEY (task_fk_id) REFERENCES tasks (task_id),
    body            varchar(2048),
    created_at      timestamp,
    deleted_at      timestamp,
    updated_at      timestamp
);