--liquibase formatted sql
--changeset Alena:create users table

CREATE TABLE IF NOT EXISTS users
(
    user_id         uuid not null
        primary key,
    crypto_password varchar(255),
    email           varchar(512),
    username        varchar(255),
    created_at      timestamp,
    deleted_at      timestamp,
    updated_at      timestamp
);