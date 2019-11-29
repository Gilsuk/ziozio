drop table qna;
create table qna (
    account_no number not null, 
    qna_no number primary key,
    qna_title varchar(100) not null,
    qna_content varchar(500) not null,
    qna_writtendate DATE DEFAULT sysdate not null,
    
    	-- account 테이블과 외래키 연결
	CONSTRAINT qna_to_account_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no )
    
);


DROP SEQUENCE qna_seq;
CREATE SEQUENCE qna_seq;

-- 아래 트리거 생성 코드는 이클립스에서 실행 안됨
-- SQL Developer로 실행 할 것
CREATE OR REPLACE TRIGGER qna_on_insert_trg
  BEFORE INSERT ON qna
  FOR EACH ROW
BEGIN
  :new.qna_no := qna_seq.nextval;
END;
/




commit;

select * from qna;

-- account 테이블과 qna테이블 JOIN
SELECT * FROM account A, qna Q
WHERE A.account_no = Q.account_no
ORDER BY qna_no DESC;

