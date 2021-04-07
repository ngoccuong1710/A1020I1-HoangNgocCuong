drop database if exists quan_ly_thu_vien;
create database quan_ly_thu_vien;
use quan_ly_thu_vien;

create table category(
	category_id int primary key,
    category_name varchar(50)
);

create table address(
	address_id int primary key,
    city varchar(50),
    country varchar(50)
);

create table book(
	book_id int primary key,
    book_name varchar(50),
    publishing_company varchar(50),
    author varchar(50),
    publishing_year year,
    number_of_publishing int,
    price double,
    image varchar(255),
    category_id int,
    
    foreign key (category_id) references category(category_id)
);

create table library_card(
	library_card_id int primary key,
    student_name varchar(50),
    date_of_bỉthday date,
    address_id int,
    email varchar(50),
    phone int(10),
    image varchar(255),
    
    foreign key (address_id) references address(address_id)
);

create table borrow_order(
	library_card_id int,
    book_id int,
    amount int,
    
    foreign key (library_card_id) references library_card(library_card_id),
    foreign key (book_id) references book(book_id)
);

create table student(
	student_number int primary key,
    student_name varchar(50),
    image varchar(255),
    address_id int,
    library_card_id int,
    foreign key (library_card_id) references borrow_order(library_card_id),
    foreign key (address_id) references address(address_id)
);
