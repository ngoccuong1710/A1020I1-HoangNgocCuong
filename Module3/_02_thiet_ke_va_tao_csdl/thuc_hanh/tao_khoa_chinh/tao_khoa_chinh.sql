drop database if exists ao_khoa_chinh;
create database tao_khoa_chinh;
use tao_khoa_chinh;

create table users(
	users_id int primary key auto_increment,
    username varchar(50),
    `password` varchar(50),
    email varchar(50)
);

create table roles(
	role_id int auto_increment,
    role_name varchar(50),
    primary key(role_id)
);

create table userroles(
	user_id int not null,
    role_id int not null,
    primary key(user_id, role_id),
    foreign key(user_id) references users(users_id),
    foreign key(role_id) references roles(role_id)
);