drop database if exists truy_van_du_lieu_nang_cao;
create database truy_van_du_lieu_nang_cao;
use truy_van_du_lieu_nang_cao;

create table product_lines(
	product_line int primary key,
    text_description varchar(50),
    html_description varchar(50),
    image varchar(50)
);

create table products(
	product_code int primary key,
    product_name varchar(50),
    product_line int,
    product_scale varchar(50),
    product_vendor varchar(50),
    product_description varchar(50),
    quantity_in_stock int,
    buy_price double,
    msrp varchar(50),
    
    foreign key (product_line) references product_lines(product_line)
);

insert into product_lines
value(1, 'qwe', 'qwe', 'qwe'),
	(2, 'zxc', 'zxc', 'zxc'),
	(3, 'asd', 'asd', 'asd'),
	(4, 'fgh', 'fgh', 'fgh'),
	(5, 'rty', 'rty', 'rty'),
	(6, 'asd', 'asd', 'asd');

insert into products
value(1, 'cuong', 1, 'asd', 'asd', 'asd', 50, 100, 'asd'),
	(2, 'cuong2', 2, 'asd', 'asd', 'asd', 10, 150, 'asd'),
	(3, 'cuong3', 1, 'asd', 'asd', 'asd', 5, 200, 'asd'),
	(4, 'cuong4', 4, 'asd', 'asd', 'asd', 15, 40, 'asd'),
	(5, 'cuong5', 3, 'asd', 'asd', 'asd', 18, 100, 'asd'),
	(6, 'cuong6', 2, 'asd', 'asd', 'asd', 7, 50, 'asd');
    
select product_code, product_name, buy_price, quantity_in_stock from products
where buy_price > 56.76 and quantity_in_stock > 10
