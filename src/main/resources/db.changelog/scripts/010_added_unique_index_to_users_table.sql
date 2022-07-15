--liquibase formatted sql
--changeset Alena:create task comments table

CREATE UNIQUE INDEX users_username_key
    ON users (username);

CREATE UNIQUE INDEX users_email_key
    ON users (email);