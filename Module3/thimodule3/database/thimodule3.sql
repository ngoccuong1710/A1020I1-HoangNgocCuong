drop database if exists thi_module3;
CREATE DATABASE thi_module3;
USE thi_module3;

create table mat_bang (
`no`int NOT NULL primary key AUTO_INCREMENT,
 ma varchar(45) NOT NULL,
 dien_tich varchar(120) NOT NULL,
 trang_thai bit(1) NOT NULL,
 tang int not null,
 loai_van_phong bit(1) not null,
 mo_ta varchar(255) not null,
 gia double not null,
 ngay_bat_dau date not null,
 ngay_ket_thuc date not null

);

DELIMITER $$
CREATE PROCEDURE them_mat_bang(
	in ma varchar(45) ,
	in dien_tich varchar(120) ,
	in trang_thai bit(1) ,
	in tang int ,
	in loai_van_phong bit(1),
	in mo_ta varchar(255) ,
	in gia double,
	in ngay_bat_dau date,
	in ngay_ket_thuc date 
)
BEGIN
    insert into mat_bang(ma, dien_tich, trang_thai, tang, loai_van_phong, mo_ta, gia, ngay_bat_dau, ngay_ket_thuc) 
    values(ma, dien_tich, trang_thai, tang, loai_van_phong, mo_ta, gia, ngay_bat_dau, ngay_ket_thuc) ;
END$$
DELIMITER ;

call them_mat_bang('MB-123', 45, 1, 2, 1, 'asdasd', '10000', '2021-10-2', '2021-10-15');


DELIMITER $$
CREATE PROCEDURE list_mat_bang()
BEGIN
    select * from mat_bang order by dien_tich;
END$$
DELIMITER ;

call list_mat_bang();

DELIMITER $$
CREATE PROCEDURE xoa_mat_bang(
	IN id INT
)
BEGIN
    delete from mat_bang where mat_bang.`no` = id;
END$$
DELIMITER ;

call xoa_mat_bang(2);
