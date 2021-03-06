DROP TABLE account_style CASCADE CONSTRAINT;

CREATE TABLE account_style (
	account_no NUMBER,
	style_code  NUMBER,
    -- account, style 테이블과 외래키 연결
	CONSTRAINT account_style_to_account_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no ),
    -- 외래키
    CONSTRAINT account_style_to_style_fk
	FOREIGN KEY ( style_code )
	REFERENCES style ( style_code )
);

ALTER TABLE account_style
ADD PRIMARY KEY (account_no, style_code);

-- 1번 유저(manager@ziozio.com)은 페미닌(스타일코드1)을 좋아함
INSERT INTO ACCOUNT_STYLE (account_no, style_code)
VALUES (1, 1);

-- 1번 유저는 댄디(3)를 좋아함
INSERT INTO ACCOUNT_STYLE (account_no, style_code)
VALUES (1, 3);

-- 2번 유저는 시크(2)를 좋아함
INSERT INTO ACCOUNT_STYLE (account_no, style_code)
VALUES (2, 2);

commit;

SELECT * FROM account_style;