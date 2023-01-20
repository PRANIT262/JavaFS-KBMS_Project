/*  
	Pranit Mahadev Patil
    date 28/12/2022
    Database Creation
*/
DROP DATABASE KBMS_PROJECT;

CREATE DATABASE KBMS_PROJECT;
USE KBMS_PROJECT;
CREATE TABLE USER(
Customer_name varchar(50), 
email VARCHAR(50), 
phone VARCHAR(20),
address TEXT, 
date_of_birth varchar(30), 
age INT,
password varchar(15),
identity_proof varchar(25),
preferred_login_id varchar(50),

constraint primary key (preferred_login_id)
);
drop table product;
CREATE TABLE PRODUCT
(
	PRODUCT_ID int primary key ,
   PRODUCT_NAME TEXT NOT NULL,
   PRODUCT_COUNT INT,
   TOTAL_STOCK INT NOT NULL,
   BEST_BEFORE DATE,
   PRICE_PER_UNIT DOUBLE NOT NULL,
   
TYPE_OF_PRODUCT VARCHAR(10)

) auto_increment=10001;


DROP TABLE order_details;
CREATE TABLE ORDER_DETAILS
(
   ORDER_ID INT PRIMARY KEY  AUTO_INCREMENT ,
  /*PREFERRED_LOGIN_ID VARCHAR(10)  NULL ,*/
   USERNAME_LOGIN varchar(10),
   PRODUCT_ID INT ,
   QUANTITY INT NOT NULL,
   TOTAL_PRICE DOUBLE NOT NULL,
   ORDER_DATE DATE NULL,
   STATUS varchar (7),
 /*  CANCELLATION_ID VARCHAR(10) UNIQUE NULL ,
CANCELLATION_DATE DATE NULL,
   CANCELLATION_REASON TEXT NULL ,
/*FOREIGN KEY(PREFERRED_LOGIN_ID) REFERENCES USER(PREFERRED_LOGIN_ID),*/
   FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)
);

create table User2
(
username varchar(10),
password varchar(10),
role varchar(10)
);

