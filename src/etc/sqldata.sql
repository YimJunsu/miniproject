drop database if exists shop;
create database shop;

use shop;

CREATE TABLE user (
    user_no INT PRIMARY KEY AUTO_INCREMENT,  -- 사용자 고유번호 (PK)
    id VARCHAR(20) UNIQUE NOT NULL,  -- 사용자 아이디 (중복 불가)
    pwd_hash VARCHAR(255) NOT NULL,  -- 비밀번호 해시 저장
    phone_no VARCHAR(15) NOT NULL  -- 전화번호
);

CREATE TABLE category (
    category_no INT PRIMARY KEY AUTO_INCREMENT,  -- 카테고리 고유번호 (PK)
    category_name VARCHAR(30) UNIQUE NOT NULL  -- 카테고리명 (중복 불가)
);

CREATE TABLE product (
    product_no INT PRIMARY KEY AUTO_INCREMENT,  -- 상품 고유번호 (PK)
    product_name VARCHAR(100) NOT NULL,  -- 상품명
    price DECIMAL(10,2) NOT NULL,  -- 가격
    product_time DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 상품 등록 시간
    product_board VARCHAR(100),  -- 상품 설명
    role ENUM('SELLER', 'BUYER') NOT NULL,  -- 판매자/구매자 구분
    category_no INT NOT NULL,  -- 카테고리 ID (FK)
    seller_no INT NOT NULL,  -- 판매자 ID (FK)
    FOREIGN KEY (category_no) REFERENCES category(category_no),  -- 카테고리 연결
    FOREIGN KEY (seller_no) REFERENCES user(user_no)  -- 판매자 연결
);

CREATE TABLE porder (
    order_no INT PRIMARY KEY AUTO_INCREMENT,  -- 주문 고유번호 (PK)
    buyer INT NOT NULL,  -- 구매자 ID (FK)
    seller INT NOT NULL,  -- 판매자 ID (FK)
    product_no INT NOT NULL,  -- 주문한 상품 ID (FK)
    order_note VARCHAR(100),  -- 주문 메모
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 주문 시간
    status ENUM('PENDING', 'COMPLETED', 'CANCELLED') NOT NULL DEFAULT 'PENDING',  -- 주문 상태
    FOREIGN KEY (buyer) REFERENCES user(user_no),  -- 구매자 연결
    FOREIGN KEY (seller) REFERENCES user(user_no),  -- 판매자 연결
    FOREIGN KEY (product_no) REFERENCES product(product_no)  -- 주문한 상품 연결
);
