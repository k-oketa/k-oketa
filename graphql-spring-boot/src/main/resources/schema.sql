drop table if exists post cascade;
drop table if exists comment cascade;

create table if not exists post (
    id bigint primary key,
    text varchar(64)
);

insert into post values (1, 'First Post');
insert into post values (2, 'Second Post');
insert into post values (3, 'Third Post');

create table if not exists comment (
    id bigint primary key,
    post_id bigint,
    description varchar(64),
    foreign key (post_id) references post(id)
);

insert into comment values (1, 1, 'Super Sugoi First Post Desu.');
insert into comment values (2, 1, 'Super Yabai First Post Desu.');
insert into comment values (3, 1, 'Hyper Sugoi First Post Desu.');

insert into comment values (4, 2, 'Super Sugoi Second Post Desu.');
insert into comment values (5, 2, 'Super Yabai Second Post Desu.');
insert into comment values (6, 2, 'Hyper Sugoi Second Post Desu.');

insert into comment values (7, 3, 'Super Sugoi Third Post Desu.');
insert into comment values (8, 3, 'Super Yabai Third Post Desu.');
insert into comment values (9, 3, 'Hyper Sugoi Third Post Desu.');
