--liquibase formatted sql
--changeset Alena:create tasks table


CREATE TYPE prior AS ENUM ('P1', 'P2', 'P3', 'P4');

CREATE TABLE IF NOT EXISTS
    tasks
(
    task_id       uuid not null primary key,
    project_fk_id uuid not null,
    FOREIGN KEY (project_fk_id) REFERENCES projects (project_id),
    summary       varchar(225),
    due_date      timestamp,
    priority      prior,
    details       varchar,
    order_number  int,
    created_at    timestamp,
    deleted_at    timestamp,
    updated_at    timestamp
);