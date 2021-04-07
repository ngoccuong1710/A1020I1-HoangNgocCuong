drop database if exists truy_van_du_lieu_tu_nhieu_bang;
create database truy_van_du_lieu_tu_nhieu_bang;
use truy_van_du_lieu_tu_nhieu_bang;

create table customers(
	customer_number int primary key,
    customer_name varchar(50),
    contact_last_name varchar(50),
    contact_first_name varchar(50),
    phone int(10),
    address_line_1 varchar(50),
    address_line_2 varchar(50),
    city varchar(50),
    state varchar(50),
    postal_code int,
    country varchar(50),
    sales_rep_employee_number int,
    credit_limit varchar(50)
);

create table orders(
	order_number int primary key,
    order_date date,
    required_date date,
    shipped_date date,
    `status` varchar(50),
    comments varchar(50),
    customer_number int,
    
    foreign key (customer_number) references customers(customer_number)
);

create table payments(
	customer_number int,
    check_number int,
    payments_date date,
    amount double,
    
    foreign key (customer_number) references customers(customer_number)
);

insert into customers
values (1, 'cuong', 'asd', 'asd', 1231231231, 'qwe', 'qwe', 'da nang', 'ada', 123, 'qwe', 123, 'qwe'),
(2, 'cuong2', 'asd', 'asd', 1231231231, 'qwe', 'qwe', 'ha hoi', 'qwe', 123, 'qwe', 123, 'qwe'),
(3, 'cuong3', 'asd', 'asd', 1231231231, 'qwe', 'qwe', 'ho chi minh', 'qwe', 123, 'qwe', 123, 'qwe'),
(4, 'cuong4', 'asd', 'asd', 1231231231, 'qwe', 'qwe', 'quang tri', 'qwe', 123, 'qwe', 123, 'qwe');


insert into orders
values (1, "2020-1-2"," 2020-2-2", "2017-12-2", 'asd', 'asd', 2),
(2, "2020-1-2", "2020-2-2", "2017-12-2", 'asd', 'asd', 4),
(3, "2020-1-2", "2020-2-2", "2017-12-2", 'asd', 'asd', 1),
(4, "2020-1-2", "2020-2-2", "2017-12-2", 'asd', 'asd', 2);

insert into payments
values (3, 123, '2020-12-2', 20000),
(1, 123, '2020-12-3', 40000),
(4, 123, '2020-12-4', 10000),
(3, 123, '2020-12-5', 60000);

select customers.customer_number, customer_name, phone, payments_date, amount 
from customers
inner join payments on customers.customer_number = payments.customer_number
-- where city = 'da nang'