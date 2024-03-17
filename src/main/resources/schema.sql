drop table if exists authors cascade;

drop table if exists books cascade;

drop sequence if exists author_sequence;

drop sequence if exists book_sequence;

create sequence author_sequence start with 1 increment by 1;

create sequence book_sequence start with 1 increment by 1;

create table authors
(
    id   bigint not null primary key,
    name varchar(255)
);

create table books
(
    id        bigint not null primary key,
    author_id bigint,
    title     varchar(255)
);

alter table if exists books
    add constraint author_id_FK
    foreign key (author_id)
    references authors on delete cascade;