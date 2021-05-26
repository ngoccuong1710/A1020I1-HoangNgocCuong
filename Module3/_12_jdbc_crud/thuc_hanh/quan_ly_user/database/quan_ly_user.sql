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

create table permision(
id int(11) primary key,
`name` varchar(50)
);

create table user_permision(
permision_id int(11),
user_id int(11)
);

insert into users
value (1, 'Cuong', 'cuong@gmail.com', 'Danang'),
(2, 'Danh', 'danh@gmail.com', 'Hanoi'),
(3, 'Tien', 'tien@gmail.com', 'Quangnam'),
(4, 'Nhan', 'nhan@gmail.com', 'Dalat'),
(5, 'Huong', 'houng@gmail.com', 'Nhatrang');

insert into permision
value(1, 'add'),
(2, 'edit'),
(3, 'delete'),
(4, 'view');

select * from users;

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;

call get_user_by_id(2);

DELIMITER $$
CREATE PROCEDURE insert_user(
	IN user_name varchar(50),
	IN user_email varchar(50),
	IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE show_users(
	
)
BEGIN
    SELECT *
    FROM users;
END$$
DELIMITER ;

call show_users();

DELIMITER $$
CREATE PROCEDURE update_users(
	IN user_id INT,
	IN user_name varchar(50),
	IN user_email varchar(50),
	IN user_country varchar(50)
)
BEGIN
    update users 
    set users.name = user_name, users.email = user_email, users.country = user_country 
    where users.id = user_id;
END$$
DELIMITER ;

call update_users(1, 'Cuong', 'cuong123@gmail.com', 'Danang')

DELIMITER $$
CREATE PROCEDURE delete_users(
	IN user_id INT
)
BEGIN
    delete from users where users.id = user_id;
END$$
DELIMITER ;

call delete_users(7)

DELIMITER $$
CREATE PROCEDURE search_users(
	IN keywork varchar(50)
)
BEGIN
    SELECT *
    FROM users
    where users.country like concat('%', keywork, '%');
END$$
DELIMITER ;

call search_users('D')