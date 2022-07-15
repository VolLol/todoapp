--liquibase formatted sql
--changeset Alena:create label table

CREATE TABLE IF NOT EXISTS
    labels
(
    label_id   uuid not null primary key,
    area_fk_id uuid not null,
    FOREIGN KEY (area_fk_id) REFERENCES areas (area_id),
    title      varchar(255),
    color      varchar(255),
    created_at timestamp,
    deleted_at timestamp,
    updated_at timestamp
);