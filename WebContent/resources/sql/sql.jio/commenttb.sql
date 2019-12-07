DROP TABLE COMMENTTB;
create table  commentTB (
   commentno NUMBER primary key,
   boardno NUMBER,
   userid VARCHAR2(100),
   content VARCHAR2(1000),
   writtendate DATE default SYSDATE
    );

DROP SEQUENCE commentTB_seq;
CREATE SEQUENCE commentTB_seq;

INSERT INTO commentTB( commentno, boardno, userid, content  ) VALUES (commentTB_seq.nextval, 38, 'GM', 'hi1');
INSERT INTO commentTB( commentno, boardno, userid, content  ) VALUES (commentTB_seq.nextval, 38, 'GM', 'hello2');
INSERT INTO commentTB( commentno, boardno, userid, content  ) VALUES (commentTB_seq.nextval, 38, 'GM', 'hi3');
INSERT INTO commentTB( commentno, boardno, userid, content  ) VALUES (commentTB_seq.nextval, 38, 'GM', 'hi4');
INSERT INTO commentTB( commentno, boardno, userid, content  ) VALUES (commentTB_seq.nextval, 37, 'GM', 'hi5');
INSERT INTO commentTB( commentno, boardno, userid, content  ) VALUES (commentTB_seq.nextval, 37, 'GM', 'hi6');
INSERT INTO commentTB( commentno, boardno, userid, content  ) VALUES (commentTB_seq.nextval, 36, 'GM', 'hi7');
INSERT INTO commentTB( commentno, boardno, userid, content  ) VALUES (commentTB_seq.nextval, 36, 'GM', 'hi8');
INSERT INTO commentTB( commentno, boardno, userid, content  ) VALUES (commentTB_seq.nextval, 35, 'GM', 'hi9');

commit;

select * from commentTB ORDER BY commentno;    