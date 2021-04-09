drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

create table vi_tri(
	id_vi_tri int primary key not null,
    ten_vi_tri varchar(45) not null
);

create table trinh_do(
	id_trinh_do int primary key not null,
    ten_trinh_do varchar(45) not null
);

create table bo_phan(
	id_bo_phan int primary key not null,
    ten_bo_phan varchar(45) not null
);

create table loai_khach(
	id_loai_khach int primary key not null,
    ten_loai_khach varchar(45) not null
);

create table kieu_thue(
	id_kieu_thue int primary key not null,
    ten_kieu_thue varchar(45) not null,
    gia int
);

create table loai_dich_vu(
	id_loai_dich_vu int primary key not null,
    ten_loai_dich_vu varchar(45) not null
);

create table dich_vu_di_kem(
	id_dich_vu_di_kem int primary key,
    ten_dich_vu_di_kem varchar(45) not null,
    gia int not null,
    don_vi int not null,
    trang_thai_kha_dung varchar(45) not null
);

create table nhan_vien(
	id_nhan_vien int primary key,
    ho_ten varchar(45) not null,
    id_vi_tri int not null,
    id_trinh_do int not null,
    id_bo_phan int not null,
    ngay_sinh date not null,
    cmnd int(9) not null,
    luong double not null,
    sdt int(10) not null,
    email varchar(45) not null,
    dia_chi varchar(45) not null,
    
    foreign key (id_vi_tri) references vi_tri(id_vi_tri),
    foreign key (id_trinh_do) references trinh_do(id_trinh_do),
    foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);

create table khach_hang(
	id_khach_hang int primary key not null,
    id_loai_khach int not null,
    ho_ten varchar(45) not null,
    ngay_sinh date not null,
    cmnd int(9) not null,
    sdt int(10) not null,
    email varchar(45) not null,
    dia_chi varchar(45) not null,
    
    foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);

create table dich_vu(
	id_dich_vu int primary key not null,
    ten_dich_vu varchar(45) not null,
    dien_tich int not null,
    so_tang int not null,
    so_nguoi_toi_da varchar(45) not null,
    chi_phi_thue varchar(45) not null,
    id_kieu_thue int not null,
    id_loai_dich_vu int not null,
    trang_thai varchar(45) not null,
    
    foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
    foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table hop_dong(
	id_hop_dong int primary key not null,
    id_nhan_vien int not null,
    id_khach_hang int not null,
    id_dich_vu int not null,
	ngay_lam_hop_dong date not null,
    ngay_ket_thuc date not null,
    tien_dat_coc double not null,
    tong_tien double not null,
    
    foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
    foreign key (id_khach_hang) references khach_hang(id_khach_hang),
    foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int primary key not null,
    id_hop_dong int not null,
    id_dich_vu_di_kem int not null,
    so_luong int not null,
    
    foreign key (id_hop_dong) references hop_dong(id_hop_dong),
    foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

insert into vi_tri values 
(1, 'Giám đốc'),
(2, 'Phó giám đốc'),
(3, 'Thư ký'),
(4, 'Trưởng phòng nhân sự'),
(5, 'Trưởng phòng tư vấn'),
(6, 'Trưởng phòng hành chính'),
(7, 'Nhân Viên'),
(8, 'Bảo vệ');

insert into trinh_do values
(1, 'Bậc trung học'),
(2, 'Bậc đại học'),
(3, 'Bậc cao học');

insert into bo_phan values
(1, 'Bộ phận kinh doanh'),
(2, 'Bộ phận kỹ thuật'),
(3, 'Bộ phận kế toán'),
(4, 'Bộ phận nhân sự');

insert into nhan_vien value
(1, 'Hoàng Ngọc Cường', 4, 2, 4, '1999-10-17', 201783537, 13000000, 0365797022, 'ngoccuong@gmail.com', 'Đà Nẵng'),
(2, 'Đoàn Công Danh', 7, 2, 1, '1999-12-24', 20171234, 7000000, 0963578925, 'congdanh123@gmail.com', 'Hà Nội'),
(3, 'Nguyễn Huy', 8, 1, 2, '2000-6-20', 201815975, 4000000, 0365794267, 'huynguyen2k@gmail.com', 'Hồ Chí Minh'),
(4, 'Huỳnh Tâm', 7, 1, 3, '2001-2-28', 301789653, 7500000, 0691354781, 'tam123123123@gmail.com', 'Quảng Trị'),
(5, 'Thanh Thảo', 1, 3, 1, '1999-9-26', 201713987, 30000000, 0698342111, 'thanhthao99@gmail.com', 'Đà Nẵng'),
(6, 'Kiên Khang', 2, 2, 2, '2000-10-25', 301632156, 8000000, 0321654988, 'anzxc123@gmail.com', 'Huế'),
(7, 'Huỳnh Tâm', 7, 3, 4, '2001-3-29', 301789653, 7500000, 0691354781, 'tam123123123@gmail.com', 'Quảng Trị');

insert into loai_khach values
(1, 'Diamond'),
(2, 'Platinum'),
(3, 'Gold'),
(4, 'Silver'),
(5, 'Copper');

insert into khach_hang values
(1, 1, 'Nguyễn Văn An', '1989-5-28', 201132326, 0365978525, 'vanan89@gmail.com', 'Hà Nội'),
(2, 5, 'Thúy Kiều', '1865-7-21', 123456789, 0365798451, 'kieu123@gmail.com', 'Đà Nẵng'),
(3, 3, 'Từ Hải', '2001-12-5', 234567891, 0657984123, 'haiqd@gmail.com', 'Đà Nẵng'),
(4, 3, 'Võ Tòng', '2015-10-10', 345678912, 0936421587, 'votong8123@gmail.com', 'Đà Nẵng'),
(5, 1, 'Lục Vân Tiên', '1950-1-18', 912345678, 0978432155, 'vantien32@gmail.com', 'Quảng Trị'),
(6, 3, 'Kiều Nguyệt Nga', '1997-4-12', 865412397, 0365125487, 'nguyetngazxc@gmail.com', 'Hồ Chí Minh'),
(7, 4, 'Hồ Văn Dậu', '1993-7-30', 888999777, 0633321554, 'chidau93@gmail.com', 'Quảng Trị');

insert into kieu_thue values
(1, 'Theo năm', 70000000),
(2, 'Theo tháng', 56000000),
(3, 'Theo tuần', 30000000),
(4, 'Theo ngày', 15000000),
(5, 'Theo giờ', 4000000);

insert into loai_dich_vu values
(1, 'Karaoke'),
(2, 'Massage'),
(3, 'Car'),
(4, 'Food'),
(5, 'Drink');
 
insert into dich_vu values
(1, 'Villa Hòa Khánh', 50, 3, 9, 11000000, 4, 2, 'Còn'),
(2, 'Room Hà Nội', 15, 1, 9, 6000000, 5, 1, 'Đã cho thuê'),
(3, 'House Đà Nẵng', 25, 2, 9, 8000000, 2, 4, 'Còn'),
(4, 'Villa Hà Nội', 38, 4, 9, 15000000, 1, 3, 'Đã cho thuê'),
(5, 'Room Huế', 21, 1, 9, 6300000, 5, 5, 'Còn'),
(6, 'Room Đằ Nẵng', 18, 2, 9, 7000000, 3, 4, 'Còn');

insert into hop_dong values 
(1, 3, 5, 1, '2020-4-28', '2030-7-28', 4000000000, 13000000000),
(2, 4, 1, 3, '2018-6-12', '2035-5-21', 6000000000, 20000000000),
(3, 7, 3, 5, '2019-10-20', '2040-6-12', 4500000000, 15000000000),
(4, 1, 3, 2, '2019-10-20', '2040-6-12', 4500000000, 15000000000),
(5, 2, 2, 2, '2019-10-20', '2040-6-12', 4500000000, 15000000000),
(6, 3, 1, 2, '2019-10-20', '2040-6-12', 4500000000, 15000000000),
(7, 5, 1, 2, '2019-10-20', '2040-6-12', 4500000000, 15000000000),
(8, 3, 5, 1, '2020-4-28', '2030-7-28', 4000000000, 13000000000);

insert into dich_vu_di_kem values
(1, 'Karaoke', 100000, 3, 'còn'),
(2, 'car', 400000, 1, 'Hết'),
(3, 'food', 50000, 4, 'còn');

insert into hop_dong_chi_tiet values
(1, 2, 2, 100),
(2, 1, 1, 50),
(3, 3, 3, 40),
(4, 5, 3, 19),
(5, 8, 2, 5),
(6, 7, 2, 10),
(7, 6, 1, 30),
(8, 4, 1, 6);

-- cau 2
select * 
from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and length(ho_ten) <= 15;

-- cau3
select * 
from khach_hang
where (dia_chi = 'Đà Nẵng' or dia_chi = 'Quảng Trị') and ((year(current_date()) - year(ngay_sinh)) <=50) and ((year(current_date()) - year(ngay_sinh)) >= 18);

-- cau 4
select kh.ho_ten, count(id_hop_dong) 'Lần đặt phòng'
from khach_hang kh inner join hop_dong hd 
on kh.id_khach_hang = hd.id_khach_hang
inner join loai_khach lk
on kh.id_loai_khach = lk.id_loai_khach where ten_loai_khach = 'Diamond'
group by kh.id_khach_hang
order by count(hd.id_khach_hang) desc;

-- cau 5
select kh.id_khach_hang, kh.ho_ten, lkh.ten_loai_khach, hd.id_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, sum(dv.chi_phi_thue + dvdk.don_vi * dvdk.gia) 'Tổng Tiền'
from khach_hang kh inner join loai_khach lkh
on kh.id_loai_khach = lkh.id_loai_khach
inner join hop_dong hd
on hd.id_khach_hang = kh.id_khach_hang
inner join dich_vu dv
on dv.id_dich_vu = hd.id_dich_vu
inner join hop_dong_chi_tiet hdct
on hd.id_hop_dong = hdct.id_hop_dong
inner join dich_vu_di_kem dvdk
on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by hd.id_hop_dong
