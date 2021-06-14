create database BookStore;
drop database BookStore;
use BookStore;

create table ROLE(
	ROLE_ID int not null auto_increment,
    ROLE_NAME varchar(12) not null,
    DESCRIPTION nvarchar(100) null,
    
    primary key (ROLE_ID)
);

insert into ROLE(ROLE_NAME, DESCRIPTION) values
	("ADMIN", "Who holds all authority"),
    ("MODERATOR", ""),
    ("SUPERMOD", ""),
    ("MANAGER", ""),
    ("STAFF", "");
select * from ROLE;

create table ADDRESS(
	ADDRESS_ID int not null auto_increment,
    COUNTRY varchar(30) not null,
    CITY varchar(30) not null,
    DISTRICT varchar(30) not null,
    WARD varchar(30) not null,
    STREET varchar(30) not null,
    NUMBER varchar(30) not null,
    
    primary key (ADDRESS_ID)
);

insert into ADDRESS(COUNTRY, CITY, DISTRICT, WARD, STREET, NUMBER) values
	("Viet Nam", "Ho Chi Minh", "Hoc Mon", "Ba Diem", "Phan Van Hon", "116/6C"),
	("Viet Nam", "Ho Chi Minh", "Tan Phu", "Tay Thanh", "Nguyen Huu Tien", "26A"),
    ("Viet Nam", "Ho Chi Minh", "Tan Binh", "4", "Hoang Viet", "3"),
    ("Viet Nam", "Ho Chi Minh", "10", "14", "Ly Thuong Kiet", "268"),
    ("Viet Nam", "Ho Chi Minh", "9", "Long Thạnh Mỹ", "D1", "E2a-7");
select * from ADDRESS;

create table STAFF(
	STAFF_ID int not null auto_increment,
    USERNAME varchar(50) not null unique,
    PASSWORD varchar(100) not null,
    FIRST_NAME varchar(15) not null,
    LAST_NAME varchar(15) not null,
    EMAIL varchar(50) null unique,
    AGE int not null,
    GENDER varchar(10) not null,
    PHONE_NUMBER varchar(12) null unique,
    STATUS tinyint default 1,
    
    primary key (STAFF_ID)
);

insert into STAFF(USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, AGE, GENDER, PHONE_NUMBER, STATUS) values
	("admin", "$2a$10$kB6JF1h/zA15bmq0l4FH4uSd/Y86Zl9nXeqKDAIkwdJXldvkqQ6na", "Arys", "Duong", "add762603@gmail.com", "22", "Male", "0908-6655-74", "1"),
    ("moderator", "$2a$10$kFueMDOHb/3edy/k2sPt.ePUzx/SYWRmSkETcHyA3fOXYIcU4G.lK", "An", "Duong", "llvllinion26@gmail.com", "22", "Male", "0123-4567-89", "1"),
    ("supermod", "$2a$10$SfVkEutDs1Hxn58Yw7q1KO676nlrRqWSTIrUwLPQwChsHL6vwI8NS", "Tuan", "Nguyen", "llvllango@gmail.com", "22", "Male", "0123-4567-98", "1"),
    ("manager", "$2a$10$KkE0SmaSuL9It3AXEX3ab.RJNxDDqQkiIPINqeoH.wKeXHlf0JARW", "T", "Nguyen", "KindAries20@yahoo.com.vn", "22", "Male", "0123-4567-99", "1"),
    ("staff", "$2a$10$wwiBAFZ3EXoLucvNF8x3cupyVJS/k2XlKwJNZT/sUabuu3BWbtd0q", "Tuan", "NDT", "tuanndtse140748", "22", "Male", "0123-4567-88", "1");
select * from STAFF;
-- update STAFF set EMAIL = "tuanndtse140748@fpt.edu.vn" WHERE STAFF_ID = 5; 

create table CUSTOMER(
	CUSTOMER_ID int not null auto_increment,
    EMAIL varchar(50) not null unique,
    PASSWORD varchar(100) null,
    FIRST_NAME varchar(15) not null,
    LAST_NAME varchar(15) not null,
    AGE int not null,
    GENDER varchar(10) not null,
    PHONE_NUMBER varchar(12) null unique,
    RANK_MEMBER int null,
    CREATED_DATE datetime not null,
    STATUS tinyint default 1,
    
    primary key (CUSTOMER_ID)
);

insert into CUSTOMER(EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, AGE, GENDER, PHONE_NUMBER, RANK_MEMBER, CREATED_DATE, STATUS) values
	("add762603@gmail.com", "", "Arys", "Duong", "22", "Male", "0908-6655-74", "1", "", "1"),
    ("llvllinion26@gmail.com", "", "An", "Duong", "22", "Male", "0123-4567-89", "1", "", "1"),
    ("llvllango@gmail.com", "", "Tuan", "Nguyen", "22", "Male", "0123-4567-98", "1", "", "1"),
    ("KindAries20@yahoo.com.vn", "", "T", "Nguyen", "22", "Male", "0123-4567-99", "1", "", "1"),
    ("tuanndtse140748@fpt.edu.vn", "", "Tuan", "NDT", "22", "Male", "0123-4567-88", "1", "", "1");

create table STAFF_ROLE(
	STAFF_ID int not null,
    ROLE_ID int not null,
    
    primary key (STAFF_ID, ROLE_ID),
    foreign key (STAFF_ID) references STAFF(STAFF_ID),
    foreign key (ROLE_ID) references ROLE(ROLE_ID)
);

insert into STAFF_ROLE(STAFF_ID, ROLE_ID) values
	("1", "1"),
    ("2", "2"),
    ("3", "3"),
    ("4", "4"),
    ("5", "5");
insert into STAFF_ROLE(STAFF_ID, ROLE_ID) values
	("1", "2"),
    ("1", "3"),
    ("1", "4"),
    ("1", "5");
    
--  select ROLE_ID from STAFF_ROLE where STAFF_ID = "1";

create table ADDRESS_STAFF_CUSTOMER(
    ADDRESS_ID int not null,
    STAFF_ID int null,
    CUSTOMER_ID int null,
    
    primary key (ADDRESS_ID),
    foreign key (ADDRESS_ID) references ADDRESS(ADDRESS_ID),
    foreign key (CUSTOMER_ID) references CUSTOMER(CUSTOMER_ID),
    foreign key (STAFF_ID) references STAFF(STAFF_ID)
);

insert into ADDRESS_STAFF_CUSTOMER(STAFF_ID, CUSTOMER_ID) values
	(),

create table CATEGORY(
	CATEGORY_ID int not null auto_increment,
    CATEGORY_NAME varchar(50) not null,
    
    primary key (CATEGORY_ID)
);

create table PUBLISHER(
	PUBLISHER_ID int not null auto_increment,
    PUBLISHER_NAME varchar(50) not null,
    
    primary key (PUBLISHER_ID)
);

create table AUTHOR(
	AUTHOR_ID int not null auto_increment,
    AUTHOR_NAME varchar(50) not null,
    
    primary key (AUTHOR_ID)
);

create table DISCOUNT(
	DISCOUNT_ID int not null auto_increment,
    DESCRIPTION varchar(300) null,
    VALUE int not null,
    EXPIRED datetime not null,
    
    primary key (DISCOUNT_ID)
);

create table CUSTOMER_DISCOUNT(
	CUSTOMER_ID int not null,
    DISCOUNT_ID int not null,
    
    primary key (CUSTOMER_ID, DISCOUNT_ID),
    foreign key (CUSTOMER_ID) references CUSTOMER(CUSTOMER_ID),
    foreign key (DISCOUNT_ID) references DISCOUNT(DISCOUNT_ID)
);

create table BOOK(
	BOOK_ID int not null auto_increment,
    TITLE varchar(50) not null,
	EDITION int not null,
    PUBLICATION_DATE datetime not null,
    PRICE bigint not null,
    primary key (BOOK_ID)
);

create table BOOK_DETAIL(
	BOOK_ID int not null,
    AUTHOR_ID int not null,
    PUBLISHER_ID int not null,
    CATEGORY_ID int not null,
    
    primary key (BOOK_ID, AUTHOR_ID, PUBLISHER_ID, CATEGORY_ID),
    foreign key (BOOK_ID) references BOOK(BOOK_ID),
    foreign key (AUTHOR_ID) references AUTHOR(AUTHOR_ID),
    foreign key (PUBLISHER_ID) references PUBLISHER(PUBLISHER_ID),
    foreign key (CATEGORY_ID) references CATEGORY(CATEGORY_ID)
);

create table ORDERS(
	ORDER_ID int not null auto_increment,
    STAFF_ID int not null,
    ORDER_DATE datetime not null,
    
    primary key (ORDER_ID),
    foreign key (STAFF_ID) references STAFF(STAFF_ID)
);

create table ORDER_DETAIL(
	ORDER_DETAIL_ID int not null auto_increment,
    ORDER_ID int not null,
    BOOK_ID int not null,
    CUSTOMER_ID int not null,
    DISCOUNT_ID int not null,
    TOTAL_PRICE bigint not null,
    
    primary key (ORDER_DETAIL_ID),
    foreign key (ORDER_ID) references ORDERS(ORDER_ID),
    foreign key (CUSTOMER_ID) references CUSTOMER(CUSTOMER_ID),
    foreign key (DISCOUNT_ID) references DISCOUNT(DISCOUNT_ID),
    foreign key (BOOK_ID) references BOOK(BOOK_ID)
);

create table REVIEW(
	REVIEW_ID int not null auto_increment,
    STAFF_ID int null,
    CUSTOMER_ID int null,
    BOOK_ID int not null,
    CONTENT varchar(300) null,
    POSTING_DATE datetime not null,
    
    primary key (REVIEW_ID),
    foreign key (STAFF_ID) references STAFF(STAFF_ID),
    foreign key (CUSTOMER_ID) references CUSTOMER(CUSTOMER_ID),
    foreign key (BOOK_ID) references BOOK(BOOK_ID)
);