DROP TABLE FILETB;
DROP TABLE COMMENTTB;
DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP TABLE BOARD_CATE;
DROP TABLE USERTB;
DROP TABLE REPORT;
DROP TABLE GRADE;

CREATE TABLE board (
   boardno NUMBER primary key, -- 글번호
   title VARCHAR2(500), -- 제목
   id VARCHAR2(100), -- 작성자 아이디
   content VARCHAR2(4000), -- 본문
   hit NUMBER, -- 조회수
   writtendate DATE DEFAULT sysdate -- 최초작성일
);

DROP SEQUENCE board_seq;
CREATE SEQUENCE board_seq;

SELECT * FROM board;







-------------------------------------------------------

DROP TABLE member;

CREATE TABLE member (
    userid VARCHAR2(100) PRIMARY KEY,
    userpw VARCHAR2(100),
    usernick VARCHAR2(100)
);


SELECT * from member;

------------------------------------------------

INSERT INTO member( userid, userpw, usernick ) VALUES ('a', 'b', 'c');
INSERT INTO member( userid, userpw, usernick ) VALUES ('writer1', 'writer11', 'writer111');
INSERT INTO member( userid, userpw, usernick ) VALUES ('writer2', 'writer22', 'writer222');
INSERT INTO member( userid, userpw, usernick ) VALUES ('writer3', 'writer33', 'writer333');

commit;

SELECT * FROM member;


------------------------------------------------

DROP TABLE boardfile;
CREATE TABLE boardfile (
    fileno NUMBER PRIMARY KEY,
    boardno NUMBER,
    originname VARCHAR2(300),
    storedname VARCHAR2(300),
    filesize NUMBER,
    writedate DATE DEFAULT sysdate
);

ALTER TABLE boardfile
ADD CONSTRAINT boardfile_fk
    FOREIGN KEY (boardno)
    REFERENCES board(boardno);

DROP SEQUENCE boardfile_seq;
CREATE SEQUENCE boardFile_seq;

----------------------------------
SELECT
   boardno,
   title,
   (SELECT COUNT(*) FROM recommend WHERE boardno = board.boardno) AS recommend
FROM board;

--------------------------------------

create table  commentTB (
   commentno NUMBER primary key,
   boardno NUMBER,
   userid VARCHAR2(100),
   content VARCHAR2(1000),
   writtendate DATE default SYSDATE
    );

CREATE Sequence commentTB_seq;

create TABLE recommend (
   userid VARCHAR2(100) Not null,
   boardno NUMBER Not null
    );
    
    SELECT * FROM recommend;
    
    
--    DROP TABLE commenttb;
    
--    delete FROM board;


select * from commentTB;    