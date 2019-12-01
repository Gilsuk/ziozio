DROP TABLE BOARD CASCADE CONSTRAINTS;

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

INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목1', '작성자아이디1', '내용1',1);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목2', '작성자아이디2', '내용2',2);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목3', '작성자아이디3', '내용3',3);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목4', '작성자아이디4', '내용4',4);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목5', '작성자아이디5', '내용5',5);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목6', '작성자아이디6', '내용6',6);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목7', '작성자아이디7', '내용7',7);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목8', '작성자아이디8', '내용8',8);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목9', '작성자아이디9', '내용9',9);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목10', '작성자아이디10', '내용10',10);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목11', '작성자아이디11', '내용11',11);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목12', '작성자아이디12', '내용12',12);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목13', '작성자아이디13', '내용13',13);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목14', '작성자아이디14', '내용14',14);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목15', '작성자아이디15', '내용15',15);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목16', '작성자아이디16', '내용16',16);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목17', '작성자아이디17', '내용17',17);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목18', '작성자아이디18', '내용18',18);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목19', '작성자아이디19', '내용19',19);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목20', '작성자아이디20', '내용20',20);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목21', '작성자아이디21', '내용21',21);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목22', '작성자아이디22', '내용22',22);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목23', '작성자아이디23', '내용23',23);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목24', '작성자아이디24', '내용24',24);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목25', '작성자아이디25', '내용25',25);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목26', '작성자아이디26', '내용26',26);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목27', '작성자아이디27', '내용27',27);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목28', '작성자아이디28', '내용28',28);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목29', '작성자아이디29', '내용29',29);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목30', '작성자아이디30', '내용30',30);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목31', '작성자아이디31', '내용31',31);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목32', '작성자아이디32', '내용32',32);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목33', '작성자아이디33', '내용33',33);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목34', '작성자아이디34', '내용34',34);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목35', '작성자아이디35', '내용35',35);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목36', '작성자아이디36', '내용36',36);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목37', '작성자아이디37', '내용37',37);
INSERT INTO board ( boardno, title, id, content, hit ) VALUES ( board_seq.nextval, '제목38', '작성자아이디38', '내용38',38);

commit;

SELECT * FROM board ORDER BY boardno;