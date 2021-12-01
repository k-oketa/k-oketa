drop table if exists post;
drop table if exists comment;

create table if not exists post (
    id bigint primary key,
    text varchar(64)
);

insert into post values (1, '');

create table if not exists comment (
    id bigint primary key,
    description varchar(64)
);


