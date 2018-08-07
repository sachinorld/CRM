-- Oarcle
--INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(1, 'sachin','111@yahoo.com', TO_DATE('2017-02-11', 'yyyy-mm-dd'));
--INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(2, 'springbaba','222@yahoo.com', TO_DATE('2017-02-12', 'yyyy-mm-dd'));
--INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(3, 'gadade','333@yahoo.com', TO_DATE('2017-02-13', 'yyyy-mm-dd'));

-- MySQL

--create table customer(id bigint NOT NULL AUTO_INCREMENT, name varchar(30), email varchar(100), created_date datetime, PRIMARY KEY (id));

INSERT INTO CUSTOMER(ID, NAME, EMAIL, CREATED_DATE) VALUES(1, 'sachin','111@yahoo.com', STR_TO_DATE('06-08-2018', '%d-%m-%Y'));
INSERT INTO CUSTOMER (ID, NAME, EMAIL, CREATED_DATE) VALUES(2, 'springbaba','222@yahoo.com', STR_TO_DATE('06-08-2018', '%d-%m-%Y'));
INSERT INTO CUSTOMER (ID, NAME, EMAIL, CREATED_DATE) VALUES(3, 'gadade','333@yahoo.com', STR_TO_DATE('06-08-2018', '%d-%m-%Y'));