drop database if exists luyen_tap_cac_ham_thong_dung;
create database luyen_tap_cac_ham_thong_dung;
use luyen_tap_cac_ham_thong_dung;

create table student(
	id int,
    `name` varchar(50),
    age int,
    course varchar(50),
    price int
);

insert into student
value (1, 'Hoang', 21, 'CNTT', 400000),
(2, 'Viet', 19, 'DTVT', 320000),
(3, 'Thanh', 18, 'KTDN', 400000),
(4, 'Nhan', 19, 'CK', 450000),
(5, 'Huong', 20, 'CNTT', 500000),
(5, 'Huong', 20, 'CNTT', 200000);

select *
from student
where `name` = 'Huong';

select sum(price)
from student
where `name` = 'Huong';

select distinct `name`
from student


