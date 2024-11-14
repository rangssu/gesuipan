Create Table Project1;

USE Project1;

drop table gesuipan;

Create Table gesuipan(
 id int auto_increment primary key,			/* 작성 글번호*/
 title varchar(255) Not Null,				/* 작성 글제목*/
 content TEXT Not Null,						/* 글내용 */
 Writer varchar(50) Not Null,				/* 작성자*/
 reg timestamp default current_timestamp	/* 작성시*/ 
);
