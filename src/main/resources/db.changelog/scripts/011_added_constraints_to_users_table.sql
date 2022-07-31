--liquibase formatted sql
--changeset Alena:create task comments table

alter table users
    alter column username set not null;

alter table users
    alter column email set not null;

alter table users
    alter column crypto_password set not null;

CREATE EXTENSION if not exists "uuid-ossp";

ALTER TABLE users
    ALTER COLUMN user_id SET DEFAULT uuid_generate_v4();
