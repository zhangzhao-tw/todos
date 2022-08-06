create sequence todo_id_seq
    minvalue 100
    increment by 1
    cache 20;

CREATE TABLE if NOT EXISTS todo
(
    id   int  not null primary key default nextval('todo_id_seq'),
    text varchar(255) not null,
    done boolean
);
