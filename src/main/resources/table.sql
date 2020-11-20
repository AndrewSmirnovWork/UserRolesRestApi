DROP TABLE IF EXISTS user;

create table user
(
    name     varchar(255) null,
    login    varchar(255) not null
        primary key,
    password varchar(255) null
);

DROP TABLE IF EXISTS user;

create table role
(
    id   int auto_increment,
    name varchar(255) null,
    constraint role_id_uindex
        unique (id),
    constraint role_name_uindex
        unique (name)
);

alter table role
    add primary key (id);

DROP TABLE IF EXISTS user_role;

create table user_role
(
    user_login varchar(255) not null,
    role_id    int          not null
        primary key,
    constraint user_role_role_id_fk
        foreign key (role_id) references role (id),
    constraint user_role_user_login_fk
        foreign key (user_login) references user (login)
);

