drop database if exists quan_ly_thu_vien;
create database quan_ly_thu_vien;
use quan_ly_thu_vien;

create table category(
	ma_the_loai int primary key,
    ten_the_loai varchar(50)
);

create table book(
	ma_sach int primary key,
    ten_sach varchar(50),
    nha_xuat_ban varchar(50),
    tac_gia varchar(50),
    nam_xuat_ban year,
    so_lan_xuat_ban int,
    gia double,
    anh varchar(255),
    ma_the_loai int,
    
    foreign key (ma_the_loai) references category(ma_the_loai)
);

create table student(
	ma_sinh_vien int primary key,
    ten_sinh_vien varchar(50),
    dia_chi varchar(50),
    anh varchar(255),
    
    ma_the int,
    foreign key (ma_the) references borrow_order(ma_the)
);

create table borrow_order(
	ma_the int primary key,
    ten_sinh_vien varchar(50),
    ngay_sinh date,
    dia_chi varchar(50),
    email varchar(50),
    sdt int(10),
    anh varchar(255)
);