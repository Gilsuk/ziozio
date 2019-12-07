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

commit;