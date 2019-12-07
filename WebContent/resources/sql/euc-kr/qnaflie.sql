DROP TABLE qnafile;
CREATE TABLE qnafile (
    qnafile_no NUMBER PRIMARY KEY,
    qna_no NUMBER,
    originname VARCHAR2(300),
    storedname VARCHAR2(300),
    filesize NUMBER,
    writedate DATE DEFAULT sysdate
);

ALTER TABLE qnafile
ADD CONSTRAINT qnafile_fk
    FOREIGN KEY (qna_no)
    REFERENCES qna(qna_no);

DROP SEQUENCE qnafile_seq;
CREATE SEQUENCE qnaFile_seq;

commit;