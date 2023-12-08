drop table users, authorities

create table users(
    id bigint not null identity(1,1) primary key,
    username varchar(45) not null,
    password varchar(45) not null,
    enabled int not null
);

create table authorities(
    id bigint not null identity(1,1) primary key,
    username varchar(45) not null,
    authority varchar(45) not null
);
