drop database if exists shop;
create database shop;

use shop;

create table user(
	user_no int auto_increment primary key,
    id varchar(20) unique not null,
    pwd int not null,
    phone_no int not null
);

create table Category(
	category_no int auto_increment primary key,
    category_name varchar(30) not null unique
);

create table product(
	product_no int auto_increment primary key,
    product_name varchar(100) not null,
	price int unsigned not null,
    product_time datetime default now(),
    product_board varchar(100),
    role enum('판매중', '판매완료') not null,
    category_no_fk int,
    user_no_fk int,
    foreign key(category_no_fk) references category(category_no),
    foreign key(user_no_fk) references user(user_no)
);

create table porder(
	order_no int auto_increment primary key,
    buyer int,
    seller int, 
    text varchar(100) not null,
    foreign key(buyer) references user(user_no),
    foreign key(seller) references user(user_no)
);