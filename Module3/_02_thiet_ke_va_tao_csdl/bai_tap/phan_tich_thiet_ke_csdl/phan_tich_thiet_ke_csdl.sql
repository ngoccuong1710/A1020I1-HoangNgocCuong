drop database if exists phan_tich_thiet_ke_csdl;
create database phan_tich_thiet_ke_csdl;
use phan_tich_thiet_ke_csdl;

create table productlines(
	productLine int primary key not null,
    textDescription text not null,
    image varchar(50) not null
);

create table offices(
	officeCode int primary key not null,
    city varchar(50) not null,
	phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50) not null,
    state varchar(50) not null,
    country varchar(50) not null,
    postalCode varchar(15) not null
);

create table employees(
	employeeNumber int primary key not null,
    lastName varchar(50) not null,
    firstName varchar(50) not null,
    email varchar(100) not null,
    jobTitle varchar(50) not null,

    reportTo int not null,
    foreign key (reportTo) references employees(employeeNumber),
    
    officeCode int not null,
    foreign key (officeCode) references employees(officeCode)
);

create table customers(
	customerNumber int primary key not null,
    customerName varchar(50) not null,
    contactLastName varchar(50) not null,
    contactFirstName varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50) not null,
    city varchar(50) not null,
    state varchar(50) not null,
    postalCode varchar(50) not null,
    country varchar(50) not null,
    creditLimit double not null,
    
    employeeNumber int,
    foreign key (employeeNumber) references employees(employeeNumber)
);

create table orders(
	orderNumber int primary key not null,
    orderDate date not null,
    requiredDate date not null,
    shippedDate date not null,
    `status` varchar(15) not null,
    comments text not null,
    quantityOrdered int not null,
    priceEach double not null,
    
    customerNumber int,
    foreign key (customerNumber) references customers(customerNumber)
);

create table payments(
	customerNumber int primary key not null,
    checkNumber varchar(50) not null,
    paymentDate date not null,
    amount double not null,
    
    customerNumber int,
    foreign key (customerNumber) references customers(customerNumber)
);

create table products(
	productCode int primary key not null,
    productName varchar(70) not null,
    productScale varchar(10) not null,
    productVendor varchar(50) not null,
    productDescription text not null,
    quantityInStock int not null,
    buyPrice double not null,
    MSRP double not null,
    
    productLine int not null,
    foreign key (productLine) references productlines(productLine)
);

create table OrederDetails(
	products_id int not null,
    orders_id int not null,
    
    primary key(products_id, orders_id),
    foreign key(products_id) references products(productCode),
    foreign key(orders_id) references orders(orderNumber)
);