drop database if exists classicmodels;
create database classicmodels;

use classicmodels;

create table customers (
	id int primary key,
    customername varchar(50),
    phone varchar(10),
    city varchar(30),
    country varchar(50)
);

insert into customers
values (1, 'Cuong', '0123456789', 'Da Nang', 'Hue'),
(2, 'Danh', '0234567891', 'Da Nang', 'Da Nang'),
(3, 'Tien', '0345678912', 'Quang Nam', 'Ha Noi');

select *
from customers