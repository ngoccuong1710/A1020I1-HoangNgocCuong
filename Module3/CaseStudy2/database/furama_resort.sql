drop database if exists furama_resort_casestudy;
create database furama_resort_casestudy;
use furama_resort_casestudy;

create table `position`(
	position_id int primary key not null,
    position_name varchar(45) not null
);

create table education_degee(
	education_degree_id int primary key not null,
    education_degree_name varchar(45) not null
);

create table division(
	division_id int primary key not null,
    division_name varchar(45) not null
);

create table `user`(
	username varchar(255) primary key not null,
    `password` varchar(255) not null
);

create table `role`(
	role_id int primary key not null,
    role_name varchar(255) not null
);

create table user_role(
	role_id int not null,
    username varchar(255) not null,
    
    foreign key (username) references user(username),
    foreign key (role_id) references role(role_id)
);

create table employee(
	employee_id int primary key not null,
    employee_name varchar(45) not null,
    employee_bỉthday date not null,
    employee_id_card varchar(45) not null,
    employee_salary double not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45) not null,
    employee_address varchar(45) not null,
    position_id int not null,
    education_degree_id int not null,
    division_id int not null,
    username varchar(255) not null,
    
    foreign key (position_id) references `position`(position_id),
    foreign key (education_degree_id) references education_degee(education_degree_id),
    foreign key (division_id) references division(division_id),
    foreign key (username) references user(username)
);

create table customer_type(
	customer_type_id int primary key not null,
    customer_type_name varchar(45) not null
);

create table customer(
	customer_id int primary key not null auto_increment,
    customer_type_id int not null,
    customer_name varchar(45) not null,
    customer_birthday date not null,
    customer_gender bit(1) not null,
    customer_id_card varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email varchar(45) not null,
    customer_address varchar(45) not null,
    
    foreign key (customer_type_id) references customer_type(customer_type_id)
);

create table service_type(
	service_type_id int primary key not null,
    service_type_name varchar(45) not null
);

create table rent_type(
	rent_type_id int primary key not null,
    rent_type_name varchar(45) not null,
    rent_type_cost double not null
);

create table service(
	service_id int primary key not null,
    service_name varchar(45) not null,
    service_area int not null,
    service_cost double not null,
    service_max_people int not null,
    rent_type_id int not null,
    service_type_id int not null,
    standard_room varchar(45) not null,
    decription_other_convenience varchar(45) not null,
    pool_area double not null,
    snumber_of_floors int not null,
    
    foreign key (rent_type_id) references rent_type(rent_type_id),
    foreign key (service_type_id) references service_type(service_type_id)
);

create table contract(
	contract_id int primary key not null,
    contract_start_date datetime not null,
    contract_end_date datetime not null,
    contract_daposit double not null,
    contract_tatal_money double not null,
    employee_id int not null,
    customer_id int not null,
    service_id int not null,
    
    foreign key (employee_id) references employee(employee_id),
    foreign key (customer_id) references customer(customer_id),
    foreign key (service_id) references service(service_id)
);

create table attach_service(
	attach_service_id int primary key not null,
    attach_service_name varchar(45) not null,
    attach_service_cost double not null,
    attach_service_unit int not null,
    attach_service_status varchar(45) not null
);

create table contract_detail(
	contract_detail_id int primary key not null,
    contract_id int not null,
    attach_service_id int not null,
    quantity int not null,
    
    foreign key (contract_id) references contract(contract_id),
	foreign key (attach_service_id) references attach_service(attach_service_id)
);

insert into customer_type values
(1, 'Diamond'),
(2, 'Platinium'),
(3, 'Gold'),
(4, 'Silver'),
(5, 'Copper');

insert into customer values
(1, 1, 'Nguyễn Văn An', '1989-5-28', 1, 201132326, 0365978525, 'vanan89@gmail.com', 'Vinh'),
(2, 5, 'Thúy Kiều', '1865-7-21', 0,  123456789, 0365798451, 'kieu123@gmail.com', 'Đà Nẵng'),
(3, 3, 'Từ Hải', '2001-12-5', 1, 234567891, 0657984123, 'haiqd@gmail.com', 'Đà Nẵng'),
(4, 3, 'Võ Tòng', '2015-10-10', 0, 345678912, 0936421587, 'votong8123@gmail.com', 'Đà Nẵng'),
(5, 1, 'Thúy Kiều', '1950-1-18', 1, 912345678, 0978432155, 'vantien32@gmail.com', 'Quảng Trị'),
(6, 3, 'Kiều Nguyệt Nga', '1997-4-12', 0, 865412397, 0365125487, 'nguyetngazxc@gmail.com', 'Quãng Ngãi'),
(7, 4, 'Từ Hải', '1993-7-30', 1, 888999777, 0633321554, 'tuhai93@gmail.com', 'Quảng Trị'),
(8, 2, 'Lão Hạc', '1993-7-30', 0, 888999777, 0633321554, 'laohac93@gmail.com', 'Vinh'),
(9, 2, 'Cậu Vàng', '1993-7-30', 0, 888999777, 0633321554, 'vang93@gmail.com', 'Quảng Trị');

DELIMITER $$
CREATE PROCEDURE customer_list()
BEGIN
    select customer_id, cus.customer_name, cus.customer_birthday, cus.customer_gender, cus.customer_id_card, cus.customer_phone, cus.customer_email, cus_type.customer_type_name, cus.customer_address 
    from customer cus left join customer_type cus_type
	on cus.customer_type_id = cus_type.customer_type_id ;
END$$
DELIMITER ;

call customer_list;

DELIMITER $$
CREATE PROCEDURE customer_create(
	IN `name` varchar(45),
	IN birthday date,
	IN gender bit(1),
    IN id_card int,
    IN phone int,
    IN email varchar(45),
    IN `type` varchar(45),
    IN address varchar(45)
)
BEGIN
    insert into customer(customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_type_id, customer_address) 
    values(`name`, birthday, gender, id_card, phone, email, `type`, address);
END$$
DELIMITER ;

-- call customer_create('Trinh', '1021-5-25', 1, '123123123', '0987654321', 'Trinh@gmail.com', 2, 'Da nang');

DELIMITER $$
CREATE PROCEDURE customer_delete(
	IN id INT
)
BEGIN
    delete from customer where customer.customer_id = id;
END$$
DELIMITER ;

-- call customer_delete(17);

DELIMITER $$
CREATE PROCEDURE customer_update(
	IN id INT,
	IN `name` varchar(45),
	IN birthday date,
	IN gender bit(1),
    IN id_card int,
    IN phone int,
    IN email varchar(45),
    IN `type` int,
    IN address varchar(45)
)
BEGIN
    update customer cus
    set cus.customer_name = `name`, cus.customer_birthday = birthday, cus.customer_gender = gender, cus.customer_id_card = id_card, cus.customer_phone = phone, cus.customer_email = email, cus.customer_type_id = `type`, cus.customer_address = address
    where cus.customer_id = id;
END$$
DELIMITER ;

-- call customer_update(1,'Nguyễn Văn An', '1989-5-28', 1, 201132326, 0365978525, 'vanan89@gmail.com', 3, 'Danang');

DELIMITER $$
CREATE PROCEDURE get_customer_by_id(IN id INT)
BEGIN
    select customer_id, cus.customer_name, cus.customer_birthday, cus.customer_gender, cus.customer_id_card, cus.customer_phone, cus.customer_email, cus_type.customer_type_name, cus.customer_address from 
	customer cus left join customer_type cus_type
	on cus.customer_type_id = cus_type.customer_type_id
    where cus.customer_id = id;
END$$
DELIMITER ;

call get_customer_by_id(1);

insert into position values
(1, 'Giám đốc'),
(2, 'Phó giám đốc'),
(3, 'Thư ký'),
(4, 'Trưởng phòng nhân sự'),
(5, 'Trưởng phòng tư vấn'),
(6, 'Trưởng phòng hành chính'),
(7, 'Nhân Viên'),
(8, 'Bảo vệ');

insert into education_degee values
(1, 'Bậc trung học'),
(2, 'Bậc đại học'),
(3, 'Bậc cao học');

insert into division values
(1, 'Bộ phận kinh doanh'),
(2, 'Bộ phận kỹ thuật'),
(3, 'Bộ phận kế toán'),
(4, 'Bộ phận nhân sự');

insert into `user` values
('ngoccuong', '123456'),
('congdanh', '132465'),
('nguyenhuy', '132465'),
('huynhtam', '132465'),
('thanhthao', '132465');

insert into `role` values
(1, 'Admin'),
(2, 'Member');


insert into user_role values
(1, 'ngoccuong'),
(2, 'congdanh'),
(2, 'nguyenhuy'),
(2, 'huynhtam'),
(2, 'thanhthao');

insert into employee values
(1, 'Hoàng Ngọc Cường', '1999-10-17', 201783537, 13000000, 0365797022, 'ngoccuong@gmail.com', 'Đà Nẵng', 4, 2, 4, 'ngoccuong'),
(2, 'Đoàn Công Danh', '1999-12-24', 20171234, 7000000, 0963578925, 'congdanh123@gmail.com', 'Hà Nội', 7, 2, 1, 'congdanh'),
(3, 'Nguyễn Huy', '2000-6-20', 201815975, 4000000, 0365794267, 'huynguyen2k@gmail.com', 'Hồ Chí Minh', 8, 1, 2, 'nguyenhuy'),
(4, 'Huỳnh Tâm', '2001-2-28', 301789653, 7500000, 0691354781, 'tam123123123@gmail.com', 'Quảng Trị', 7, 1, 3, 'huynhtam'),
(5, 'Thanh Thảo', '1999-9-26', 201713987, 30000000, 0698342111, 'thanhthao99@gmail.com', 'Đà Nẵng', 1, 3, 1, 'thanhthao');





