--liquibase formatted sql
--changeset Alena:create task comments table

CREATE UNIQUE INDEX users_username_email_key
    ON users (username, email);