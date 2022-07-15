--liquibase formatted sql
--changeset Alena:create areas table

CREATE TABLE IF NOT EXISTS areas
(
    area_id    uuid not null
        primary key,
    user_fk_id uuid not null,
    FOREIGN KEY (user_fk_id) REFERENCES users (user_id),
    role       varchar(255),
    created_at timestamp,
    deleted_at timestamp,
    updated_at timestamp
);
