drop database if exists quan_ly_user;
CREATE DATABASE quan_ly_user;
USE quan_ly_user;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
