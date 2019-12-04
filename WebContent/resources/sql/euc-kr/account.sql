CREATE TABLE ACCOUNT (
	account_no NUMBER PRIMARY KEY,
	account_email VARCHAR2(100) UNIQUE NOT NULL,
	account_pw CHAR(64) NOT NULL,
	account_nick VARCHAR2(30) UNIQUE NOT NULL,
	account_gender CHAR(1) NOT NULL,
	account_signed_date DATE DEFAULT SYSDATE NOT NULL,
	account_verified NUMBER DEFAULT 0 NOT NULL,
	account_grade_code NUMBER NOT NULL,
	CONSTRAINT account_to_account_grade_fk
	FOREIGN KEY ( account_grade_code )
	REFERENCES account_grade ( account_grade_code ),
	CONSTRAINT account_gender_ck
	CHECK (account_gender IN('N', 'M', 'F')),
	CONSTRAINT account_verified_ck
	CHECK (account_verified IN(0, 1))
);

ALTER TABLE account
MODIFY account_grade_code DEFAULT 102;

CREATE SEQUENCE account_seq;

CREATE OR REPLACE TRIGGER account_on_insert_trg
  BEFORE INSERT ON account
  FOR EACH ROW
BEGIN
  :new.account_no := account_seq.nextval;
END;
/

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
