drop table if exists post cascade;
drop table if exists comment cascade;

create table if not exists post (
    id bigint primary key,
    text varchar(64)
);

insert into post values (1, '');

create table if not exists comment (
    id bigint primary key,
    post_id bigint,
    description varchar(64),
    foreign key (post_id) references post(id)
);

insert into comment values (1, 1, 'Super Sugoi Post Desu.');
insert into comment values (2, 1, 'Super Yabai Post Desu.');
insert into comment values (3, 1, 'Hyper Sugoi Post Desu.');


