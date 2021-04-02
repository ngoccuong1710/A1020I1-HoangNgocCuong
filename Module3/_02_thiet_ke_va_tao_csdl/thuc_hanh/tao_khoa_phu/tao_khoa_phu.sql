drop database if exists tao_khoa_phu;
create database tao_khoa_phu;
use tao_khoa_phu;

create table customers(
	id int primary key auto_increment,
    `name` varchar(50),
    address varchar(50),
    email varchar(50)
);

create table orders(
	id int auto_increment,
    staff varchar(50),
    primary key(id),
    customer_id int,
    foreign key (customer_id) references customers(id)
);
