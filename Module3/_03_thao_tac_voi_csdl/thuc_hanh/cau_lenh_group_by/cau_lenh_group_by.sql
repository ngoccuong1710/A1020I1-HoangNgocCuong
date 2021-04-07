drop database if exists cau_lenh_group_by;
create database cau_lenh_group_by;
use cau_lenh_group_by;

create table orders(
	order_number int primary key,
    order_date date,
    required_date date,
    shipped_date date,
    `status` varchar(50),
    comments varchar(50),
    customer_number int
);

create table order_details(
	order_number int,
    product_code int,
    quantity_ordered double,
    price_each double,
    order_line_number int,
    
    foreign key (order_number) references orders(order_number)
);

insert into orders
values (1, "2020-1-2"," 2021-2-2", "2017-12-2", 'asdasd', 'asdasda', 2),
(2, "2000-1-2", "2001-2-2", "2017-12-2", 'asdasd', 'asdqweqe', 4),
(3, "2014-1-2", "2013-2-2", "2017-12-2", 'zxczxc', 'asdzxc', 1),
(4, "2015-1-2", "2014-2-2", "2017-12-2", 'fghfgh', 'asdrty', 2);

insert into order_details
values (2, 1, 2, 20000, 3),
(1, 2, 3, 30000, 4),
(3, 3, 1, 12000, 2),
(2, 4, 4, 10000, 1);

select status, COUNT(*) as 'So luong status'
from orders
group by `status`;

select `status`, sum(quantity_ordered * price_each) as amount
from orders 
inner join order_details on orders.order_number = order_details.order_number
group by `status`;

select order_number, sum(quantity_ordered * price_each) as total
from order_details
group by order_number;

select year(order_date) as year, sum(quantity_ordered * price_each) as total
from orders 
inner join order_details on orders.order_number = order_details.order_number
where `status` = 'asdasd'
group by year
having year > 2003