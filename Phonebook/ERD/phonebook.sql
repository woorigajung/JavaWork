
/* Drop Tables */

DROP TABLE phonebook CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE phonebook
(
	pb_uid number NOT NULL 야야야,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob 야야야야,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);



