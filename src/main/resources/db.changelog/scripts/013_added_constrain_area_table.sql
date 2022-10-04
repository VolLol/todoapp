--liquibase formatted sql
--changeset Alena:create constrain to columns update_At adn create_at

alter table areas
    alter column created_at set not null;

alter table areas
    alter column updated_at set not null;
