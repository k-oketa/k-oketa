drop table if exists post;
drop table if exists comment;

create table if not exists post (
    id bigint primary key,
    text varchar(64)
);

insert into post values (1, '');

create table if not exists comment (
    post_id bigint foreign key references post(id),
    description varchar(64)
);

insert into comment (1, 'Super Sugoi Post Desu.')
insert into comment (1, 'Super Yabai Post Desu.')
insert into comment (1, 'Hyper Sugoi Post Desu.')


