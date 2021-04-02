drop database if exists xac_dinh_khoa_chinh_khoa_phu;
create database xac_dinh_khoa_chinh_khoa_phu;
use xac_dinh_khoa_chinh_khoa_phu;

create table transactions(
	tran_number int primary key auto_increment,
    account_number int,
    `date` date,
    amounts int,
    descriptions varchar(255)
);

create table accounts(
	account_number int primary key auto_increment,
    account_type varchar(12),
    `date` date,
    balance int,
    tran_number int,
    foreign key (tran_number) references transactions(tran_number) 
);

create table customers(
	customer_number int primary key auto_increment,
    fullname varchar(50),
    address varchar(50),
    email varchar(50),
    phone int(10),
    account_number int,
    foreign key (account_number) references accounts(account_number) 
);