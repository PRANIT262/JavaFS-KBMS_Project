/*Author Pranit Patil
Date-28/12/2022
DataBase Creation
*/
use Kbms_project;
create table USER_INFO
(
  USER_NAME VARCHAR(50) NOT NULL ,
  USER_EMAIL VARCHAR(30) unique not null,
  PHONE_NO CHAR(12) NOT NULL,
  ADDRESS TEXT NOT NULL,
  DATE_OF_BIRTH DATE NOT NULL,
  ID_PROOF char(12) NOT NULL,
  USER_ID INT AUTO_INCREMENT ,
  USER_PASSWORD VARCHAR(20) ,
  PRIMARY KEY(USER_ID)
)AUTO_INCREMENT = 1000;

CREATE TABLE PRODUCT
(
   PRICE_PER_UNIT INT NOT NULL ,
   PRODUCT_ID INT auto_increment PRIMARY KEY ,
   PRODUCT_NAME TEXT NOT NULL,
   TOTAL_STOCK INT NOT NULL,
   BEST_BEFORE DATE 
) auto_increment=10001;

CREATE TABLE ORDER_DETAILS
(
   PRODUCT_ID INT PRIMARY KEY ,
   PRODUCT_NAME TEXT ,
   QUANTITY TINYINT NOT NULL,
   PRICE INT NOT NULL,
   PRO_STATUS BOOLEAN DEFAULT(1),
   USER_ID INT NOT NULL ,
   fOREIGN KEY(USER_ID) REFERENCES USER_INFO(USER_ID),
   FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)
);
