--liquibase formatted sql
--changeset Alena:create task comments table

alter table users
    alter column username set not null;

alter table users
    add constraint check_min_length check (length(username) >= 4);

alter table users
    add constraint check_max_length check (length(username) <= 10);

alter table users
    alter column email set not null;

alter table users
    add constraint check_email_valid check ((email ~* '^[A-Za-z0-9._+%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$'));

alter table users
    alter column crypto_password set not null;

CREATE EXTENSION if not exists "uuid-ossp";

ALTER TABLE users
    ALTER COLUMN user_id SET DEFAULT uuid_generate_v4();

ALTER TABLE users
    ALTER column created_at set default current_timestamp;

ALTER TABLE users
    ALTER column updated_at set default current_timestamp;

ALTER TABLE users
    ALTER column deleted_at set default current_timestamp;