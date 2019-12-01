DROP TRIGGER account_on_insert_trg;
DROP SEQUENCE account_seq;
DROP TABLE ACCOUNT;

CREATE TABLE ACCOUNT (

	account_no NUMBER PRIMARY KEY,
	account_email VARCHAR2(100) UNIQUE NOT NULL,
	account_pw CHAR(64) NOT NULL,
	account_nick VARCHAR2(30) UNIQUE NOT NULL,
	account_gender CHAR(1) NOT NULL,
	account_signed_date DATE DEFAULT SYSDATE NOT NULL,
	account_verified NUMBER DEFAULT 0 NOT NULL,
	account_grade_code NUMBER NOT NULL,

	-- account_grade 테이블과 외래키 연결
	CONSTRAINT account_to_account_grade_fk
	FOREIGN KEY ( account_grade_code )
	REFERENCES account_grade ( account_grade_code ),
	
	-- 성별에 N, M, F 이외의 데이터 입력 불가
	CONSTRAINT account_gender_ck
	CHECK (account_gender IN('N', 'M', 'F')),
	
	-- 계정 인증 완료 열에 0, 1만 입력가능
	CONSTRAINT account_verified_ck
	CHECK (account_verified IN(0, 1))
);

-- 기본 계정 등급 102(일반 유저)
ALTER TABLE account
MODIFY account_grade_code DEFAULT 102;

CREATE SEQUENCE account_seq;

-- 아래 트리거 생성 코드는 이클립스에서 실행 안됨
-- SQL Developer로 실행 할 것
CREATE OR REPLACE TRIGGER account_on_insert_trg
  BEFORE INSERT ON account
  FOR EACH ROW
BEGIN
  :new.account_no := account_seq.nextval;
END;
/

commit;
-- 여기 까지

-- 테스트 계정 생성
-- 관리자 계정 id:manager@ziozio.com pw:1234
INSERT INTO account (
	account_email,
	account_pw,
	account_nick,
	account_gender,
	account_grade_code,
	account_verified
) VALUES (
	'manager@ziozio.com',
	'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',
	'GM',
	'N',
	1,
	1
);

-- 유저 계정 id:user@ziozio.com pw:1234
INSERT INTO account (
	account_email,
	account_pw,
	account_nick,
	account_gender,
	account_grade_code,
	account_verified
) VALUES (
	'user@ziozio.com',
	'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',
	'user',
	'F',
	101,
	1
);

-- 미인증 유저계정 id:unvalid@ziozio.com pw:1234
INSERT INTO account (
	account_email,
	account_pw,
	account_nick,
	account_gender
) VALUES (
	'unvalid@ziozio.com',
	'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',
	'unvalidUser',
	'F'
);

commit;

-- 생성 확인
SELECT * FROM account;

