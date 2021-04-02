drop database if exists classicmodels;
create database classicmodels;

use classicmodels;

create table customers (
	id int primary key auto_increment,
    customer_name varchar(50),
    phone varchar(10),
    city varchar(30),
    country varchar(50)
);

-- insert into customers
-- values (1, 'Cuong', '0123456789', 'Da Nang', 'Hue'),
-- (2, 'Danh', '0234567891', 'Da Nang', 'Da Nang'),
-- (3, 'Tien', '0345678912', 'Quang Nam', 'Ha Noi'),
-- (4, 'Hai', '0456789123', 'Ho Chi Minh', 'Ha Noi');

insert into customers (customer_name, phone, city, country)
values ('Cuong', '0123456789', 'Da Nang', 'Hue'),
('Danh', '0234567891', 'Da Nang', 'Da Nang'),
('Tien', '0345678912', 'Quang Nam', 'Ha Noi'),
('Hai', '0456789123', 'Ho Chi Minh', 'Ha Noi');

insert into customers (customer_name, phone, city, country,  email)
values ('An', '05567891234', 'Gia Lai', 'Ho Chi Minh', 'an@gmail.com');

update customers
set email = 'cuong@gmail.com'
where id = 1;

select * 
from customers;

select *
from customers
where customer_name = 'Cuong';

select *
from customers
where customer_name like '%a%';

select *
from customers
where customer_name in ('Cuong', 'Danh');

select customer_name, city
from customers;

delete from customers
where id = 6;

update customers
set city = 'Quang Tri'
where city = 'Quang Nam';

update customers
set customer_name = 'Thanh'
where id = 4;

alter table customers
add column email varchar(50);
