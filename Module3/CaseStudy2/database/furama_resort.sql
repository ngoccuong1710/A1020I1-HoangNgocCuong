drop database if exists furama_resort_casestudy;
create database furama_resort_casestudy;
use furama_resort_casestudy;

create table `position`(
	position_id int primary key not null,
    position_name varchar(45) not null
);

create table education_degree(
	education_degree_id int primary key not null,
    education_degree_name varchar(45) not null
);

create table division(
	division_id int primary key not null,
    division_name varchar(45) not null
);

create table `user`(
	username varchar(255) primary key not null,
    `password` varchar(255) default '123456'
);

create table `role`(
	role_id int primary key not null,
    role_name varchar(255) not null
);

create table user_role(
	role_id int not null,
    username varchar(255) not null,
    
    constraint foreign key (username) references user(username) ON DELETE CASCADE,
    constraint foreign key (role_id) references role(role_id) ON DELETE CASCADE
);

create table employee(
	employee_id int primary key not null auto_increment,
    employee_name varchar(45) not null,
    employee_birthday date not null,
    employee_id_card varchar(45) not null,
    employee_salary double not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45) not null,
    employee_address varchar(45) not null,
    position_id int not null,
    education_degree_id int not null,
    division_id int not null,
    username varchar(255),
    
    constraint foreign key (position_id) references `position`(position_id) ON DELETE CASCADE,
    constraint foreign key (education_degree_id) references education_degree(education_degree_id) ON DELETE CASCADE,
    constraint foreign key (division_id) references division(division_id) ON DELETE CASCADE,
    constraint foreign key (username) references user(username) ON DELETE CASCADE
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
    
    constraint foreign key (customer_type_id) references customer_type(customer_type_id) ON DELETE CASCADE
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
	service_id int primary key not null auto_increment,
    service_name varchar(45) not null,
    service_area int not null,
    service_cost double not null,
    service_max_people int not null,
    rent_type_id int not null,
    service_type_id int not null,
    standard_room varchar(45),
    decription_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    
    foreign key (rent_type_id) references rent_type(rent_type_id),
    foreign key (service_type_id) references service_type(service_type_id)
);

create table contract(
	contract_id int primary key not null auto_increment,
    contract_start_date datetime not null,
    contract_end_date datetime not null,
    contract_daposit double not null,
    contract_tatal_money double not null,
    employee_id int not null,
    customer_id int not null,
    service_id int not null,
    
    constraint foreign key (employee_id) references employee(employee_id) ON DELETE CASCADE,
    constraint foreign key (customer_id) references customer(customer_id) ON DELETE CASCADE,
    constraint foreign key (service_id) references service(service_id) ON DELETE CASCADE
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
    
    constraint foreign key (contract_id) references contract(contract_id) on delete cascade,
	constraint foreign key (attach_service_id) references attach_service(attach_service_id) on delete cascade
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

call customer_create('Trinh', '1021-5-25', 1, '123123123', '0987654321', 'Trinh@gmail.com', 2, 'Da nang');

DELIMITER $$
CREATE PROCEDURE customer_delete(
	IN id INT
)
BEGIN
    delete from customer where customer.customer_id = id;
END$$
DELIMITER ;

-- call customer_delete(10);

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

-- call customer_update(1,'Nguyễn Văn An', '1989-5-28', 0, 201132326, 0365978525, 'vanan89@gmail.com', 3, 'Danang');

DELIMITER $$
CREATE PROCEDURE get_customer_by_id(IN id INT)
BEGIN
    select customer_id, cus.customer_name, cus.customer_birthday, cus.customer_gender, cus.customer_id_card, cus.customer_phone, cus.customer_email, cus_type.customer_type_name, cus.customer_address from 
	customer cus left join customer_type cus_type
	on cus.customer_type_id = cus_type.customer_type_id
    where cus.customer_id = id;
END$$
DELIMITER ;

-- call get_customer_by_id(1);

DELIMITER $$
CREATE PROCEDURE search_customer(
	IN keywork varchar(50)
)
BEGIN
    select customer_id, cus.customer_name, cus.customer_birthday, cus.customer_gender, cus.customer_id_card, cus.customer_phone, cus.customer_email, cus_type.customer_type_name, cus.customer_address 
    from customer cus left join customer_type cus_type
	on cus.customer_type_id = cus_type.customer_type_id
    where cus.customer_name like concat('%', keywork, '%');
END$$
DELIMITER ;

-- call search_customer('A');

insert into position values
(1, 'Giám đốc'),
(2, 'Phó giám đốc'),
(3, 'Thư ký'),
(4, 'Trưởng phòng nhân sự'),
(5, 'Trưởng phòng tư vấn'),
(6, 'Trưởng phòng hành chính'),
(7, 'Nhân Viên'),
(8, 'Bảo vệ');

insert into education_degree values
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
(1, 'Giám đốc'),
(2, 'Quản lý');

insert into user_role values
(1, 'ngoccuong'),
(2, 'congdanh'),
(2, 'nguyenhuy'),
(2, 'huynhtam'),
(2, 'thanhthao');

insert into employee values
(1, 'Hoàng Ngọc Cường', '1999-10-17', 201783537, 8500000, 0365797022, 'ngoccuong@gmail.com', 'Đà Nẵng', 4, 2, 4, 'ngoccuong'),
(2, 'Đoàn Công Danh', '1999-12-24', 20171234, 7000000, 0963578925, 'congdanh123@gmail.com', 'Hà Nội', 7, 2, 1, 'congdanh'),
(3, 'Nguyễn Huy', '2000-6-20', 201815975, 4000000, 0365794267, 'huynguyen2k@gmail.com', 'Hồ Chí Minh', 8, 1, 2, 'nguyenhuy'),
(4, 'Huỳnh Tâm', '2001-2-28', 301789653, 7500000, 0691354781, 'tam123123123@gmail.com', 'Quảng Trị', 7, 1, 3, 'huynhtam'),
(5, 'Thanh Thảo', '1999-9-26', 201713987, 9000000, 0698342111, 'thanhthao99@gmail.com', 'Đà Nẵng', 1, 3, 1, 'thanhthao');

DELIMITER $$
CREATE PROCEDURE employee_list()
BEGIN
    select emp.employee_id, emp.employee_name, emp.employee_birthday, emp.employee_id_card, emp.employee_salary, emp.employee_phone, emp.employee_email, emp.employee_address, pos.position_name, edu.education_degree_name, `div`.division_name
    from employee emp left join position pos
	on emp.position_id = pos.position_id
    left join education_degree edu
    on emp.education_degree_id = edu.education_degree_id
    left join division `div`
    on emp.division_id = `div`.division_id;
END$$
DELIMITER ;

call employee_list();

DELIMITER $$
CREATE PROCEDURE employee_create(
	IN `name` varchar(45),
	IN birthday date,
    IN id_card int,
    IN salary double,
    IN phone int,
    IN email varchar(45),
    IN address varchar(45),
	IN position int,
    IN education_degree int,
    IN division int,
    IN username varchar(255)
    
)
BEGIN
	insert into `user`(username)
    values(username);
    insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username)
    values(`name`, birthday, id_card, salary, phone, email, address, position, education_degree, division, username);
END$$
DELIMITER ;

-- call employee_create('La Chinh', '2000-5-25', '200035689', 8500000, '0987654321', 'lachinh123@gmail.com', 'Da nang', 2, 3, 1, 'lachinh');  

DELIMITER $$
CREATE PROCEDURE employee_delete(
	IN id INT
)
BEGIN
    delete from employee where employee.employee_id = id;
END$$
DELIMITER ;

-- call employee_delete(4);

DELIMITER $$
CREATE PROCEDURE employee_update(
	IN id INT,
	IN `name` varchar(45),
	IN birthday date,
    IN id_card int,
    IN salary double,
    IN phone int,
    IN email varchar(45),
    IN address varchar(45),
	IN position int,
    IN education_degree int,
    IN division int,
    IN username varchar(255)
)
BEGIN
    update employee emp
    set emp.employee_name = `name`, emp.employee_birthday = birthday, emp.employee_id_card = id_card, emp.employee_salary = salary, emp.employee_phone = phone, emp.employee_email = email, emp.employee_address = address, emp.position_id = position, emp.education_degree_id = education_degree, emp.division_id = division, emp.username = username
    where emp.employee_id = id;
END$$
DELIMITER ;

-- call employee_update(1, 'Hoàng Ngọc Cường', '1999-10-17', 201783537, 8500000, 0365797022, 'ngoccuong@gmail.com', 'Đà Nẵng', 4, 2, 4, 'ngoccuong');  

DELIMITER $$
CREATE PROCEDURE get_employee_by_id(IN id INT)
BEGIN
    select emp.employee_id, emp.employee_name, emp.employee_birthday, emp.employee_id_card, emp.employee_salary, emp.employee_phone, emp.employee_email, emp.employee_address, pos.position_name, edu.education_degree_name, `div`.division_name, `user`.username
    from employee emp left join position pos
	on emp.position_id = pos.position_id
    left join education_degree edu
    on emp.education_degree_id = edu.education_degree_id
    left join division `div`
    on emp.division_id = `div`.division_id
    left join `user`
    on emp.username = `user`.username
    where emp.employee_id = id;
END$$
DELIMITER ;

-- call get_employee_by_id(1);

DELIMITER $$
CREATE PROCEDURE search_employee(
	IN keywork varchar(50)
)
BEGIN
    select emp.employee_id, emp.employee_name, emp.employee_birthday, emp.employee_id_card, emp.employee_salary, emp.employee_phone, emp.employee_email, emp.employee_address, pos.position_name, edu.education_degree_name, `div`.division_name
    from employee emp left join position pos
	on emp.position_id = pos.position_id
    left join education_degree edu
    on emp.education_degree_id = edu.education_degree_id
    left join division `div`
    on emp.division_id = `div`.division_id
    where emp.employee_name like concat('%', keywork, '%');
END$$
DELIMITER ;

call search_employee('Cường');

insert into rent_type values
(1, 'Hour', 100000),
(2, 'Day', 300000),
(3, 'Month', 500000),
(4, 'Year', 700000);

insert into service_type values
(1, 'Villa'),
(2, 'House'),
(3, 'Room');

insert into service values
(1, 'Villa-1', 50, 1200000, 10, 2, 1, '5 sao', 'foor', 40, 3),
(2, 'Villa-2', 43, 700000, 7, 1, 2, '4 sao', 'drink', 50, 2),
(3, 'House-1', 43, 700000, 7, 1, 2, '4 sao', 'drink', null, 2),
(4, 'House-2', 43, 700000, 7, 1, 2, '4 sao', 'drink', null, 2),
(5, 'Room-1', 20, 400000, 4, 3, 3, null, null, null, null),
(6, 'Room-2', 20, 400000, 4, 3, 3, null, null, null, null);

insert into attach_service values
(1, 'Karaoke', 100000, 3, 'còn'),
(2, 'car', 400000, 1, 'hết'),
(3, 'food', 50000, 4, 'còn'),
(4, 'drink', 50000, 4, 'còn');

insert into contract values
(1, '2018-1-28', '2030-7-28', 4000000, 13000000, 1, 2, 1),
(2, '2019-3-12', '2035-5-21', 5000000, 17000000, 5, 6, 3),
(3, '2019-2-20', '2040-6-12', 6000000, 23000000, 3, 1, 2),
(4, '2018-1-20', '2040-6-12', 7000000, 11000000, 2, 3, 1);

insert into contract_detail values
(1, 2, 1, 50),
(2, 3, 2, 40),
(3, 1, 4, 60);

DELIMITER $$
CREATE PROCEDURE service_list()
BEGIN
    select *
    from service;
END$$
DELIMITER ;

call service_list();

DELIMITER $$
CREATE PROCEDURE service_create(
	IN `name` varchar(45),
	IN area int,
    IN cost double,
    IN max_people int,
    IN rent_type int,
    IN service_type int,
    IN standard_room varchar(45),
	IN decription_other_convenience varchar(45),
    IN pool_area double,
    IN number_of_floors int
)
BEGIN
	insert into service(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, decription_other_convenience, pool_area, number_of_floors) values
	(`name`, area, cost, max_people, rent_type, service_type, standard_room, decription_other_convenience, pool_area, number_of_floors);
	
END$$
DELIMITER ;

-- call service_create('Villa-3', 43, 700000, 7, 1, 2, '4 sao', 'drink', 12, 2);

DELIMITER $$
CREATE PROCEDURE service_delete(
	IN id INT
)
BEGIN
    delete from service where service.service_id = id;
END$$
DELIMITER ;

-- call service_delete(8);

DELIMITER $$
CREATE PROCEDURE service_update(
	IN id INT,
	IN `name` varchar(45),
	IN area int,
    IN cost double,
    IN max_people int,
    IN rent_type int,
    IN service_type int,
    IN standard_room varchar(45),
	IN decription_other_convenience varchar(45),
    IN pool_area double,
    IN number_of_floors int
)
BEGIN
    update service ser
    set ser.service_name = `name`, ser.service_area = area, ser.service_cost = cost, ser.service_max_people = max_people, ser.rent_type_id = rent_type, ser.service_type_id = service_type, ser.standard_room = standard_room, ser.decription_other_convenience = decription_other_convenience, ser.pool_area = pool_area, ser.number_of_floors = number_of_floors
    where ser.service_id = id;
END$$
DELIMITER ;

-- call service_update(1, 'Villa-123', 50, 1200000, 10, 2, 1, '5 sao', 'foor', 40, 3)

DELIMITER $$
CREATE PROCEDURE get_service_by_id(IN id INT)
BEGIN
    select *
    from service
    where service.service_id = id;
END$$
DELIMITER ;

-- call get_service_by_id(1)

DELIMITER $$
CREATE PROCEDURE search_service(
	IN keywork varchar(50)
)
BEGIN
    select *
    from service ser
    where ser.service_name like concat('%', keywork, '%');
END$$
DELIMITER ;

call search_service('villa');