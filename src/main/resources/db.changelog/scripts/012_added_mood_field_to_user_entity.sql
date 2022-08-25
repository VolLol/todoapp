--liquibase formatted sql
--changeset Alena:create task comments table

alter table users
    add column mood varchar;
