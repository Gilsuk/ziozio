DROP TABLE cookie;

CREATE TABLE cookie (

	cookie_id CHAR(8) NOT NULL,
	cookie_ip VARCHAR(15) NOT NULL,
	account_no NUMBER NOT NULL,
	cookie_date DATE DEFAULT SYSDATE NOT NULL,

	-- 쿠키와 ip를 복수 기본키로 지정
	CONSTRAINT cookie_pk PRIMARY KEY (cookie_id, cookie_ip),

	-- account 테이블과 외래키 연결
	CONSTRAINT cookie_to_account_no_fk
	FOREIGN KEY ( account_no )
	REFERENCES account( account_no )
	
);

INSERT INTO cookie (
	cookie_id, cookie_ip,
	account_no
) VALUES (
	'a72jgdia', '127.0.0.1',
	1
);

SELECT * FROM cookie;