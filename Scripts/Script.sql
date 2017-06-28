SHOW DATABASES;
DROP DATABASE luuzun_spring_board;
CREATE DATABASE luuzun_spring_board;
USE luuzun_spring_board;

CREATE TABLE tbl_board(
    bno 	INT 		 NOT NULL auto_increment,
    title 	VARCHAR(200) NOT NULL,
    content TEXT 		 NULL,
    writer 	VARCHAR(50)  NOT NULL,
    regdate TIMESTAMP 	 NOT NULL DEFAULT now(),
    viewcnt INT 		 DEFAULT 0,
    PRIMARY KEY(bno)
);

CREATE TABLE tbl_reply(
   rno 			INT NOT NULL auto_increment,
   bno 			INT NOT NULL,
   replytext 	VARCHAR(1000) NOT NULL,
   replyer 		VARCHAR(50) NOT NULL,
   regdate 		TIMESTAMP NOT NULL DEFAULT NOW(),
   updatedate 	TIMESTAMP NOT NULL DEFAULT NOW(),
   PRIMARY KEY(rno)
);
ALTER TABLE tbl_reply ADD CONSTRAINT fk_board
	FOREIGN KEY(bno) REFERENCES tbl_board(bno)
	ON DELETE CASCADE;

SELECT * FROM tbl_board;
SELECT * FROM tbl_reply;
SELECT COUNT(*) FROM tbl_board;

SELECT * FROM tbl_board WHERE title LIKE "%te%";
SELECT bno, title, content, writer, regdate, viewcnt 
   FROM tbl_board 
   WHERE bno > 0 
   ORDER BY bno DESC, regdate DESC 
   LIMIT 1, 10;

   
CREATE PROCEDURE insert_board_sample()
BEGIN
	DECLARE i INT DEFAULT 1;
	WHILE i <= 1000 DO
		INSERT INTO tbl_board (title, content, writer)
			VALUES (CONCAT('Article Title',i), CONCAT('Content ',i), 'Admin');
		SET i=i+1;
	END WHILE;
END;

CREATE PROCEDURE insert_reply_sample()
BEGIN
	DECLARE i INT DEFAULT 1;
	WHILE i <= 1000 DO
		INSERT INTO tbl_reply (bno, replytext, replyer)
			VALUES (CONCAT(i), CONCAT('Reply ',i), 'Admin');
		SET i=i+1;
	END WHILE;
END;

DROP PROCEDURE insert_board_sample;
DROP PROCEDURE insert_reply_sample;

SHOW PROCEDURE STATUS;
CALL insert_board_sample;
CALL insert_reply_sample;