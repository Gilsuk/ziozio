DROP TABLE account_style;

CREATE TABLE account_style (
	account_no NUMBER NOT NULL,
	style_code  NUMBER NOT NULL,
    
    -- account, style 테이블과 외래키 연결
	CONSTRAINT account_style_to_account_no_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no ),
    
    CONSTRAINT account_style_to_style_code_fk
	FOREIGN KEY ( style_code )
	REFERENCES style ( style_code )
    
);

INSERT INTO ACCOUNT_STYLE (account_no, style_code)
VALUES (1, 1);

INSERT INTO ACCOUNT_STYLE (account_no, style_code)
VALUES (2, 2);

INSERT INTO ACCOUNT_STYLE (account_no, style_code)
VALUES (3, 3);


SELECT * FROM account_style;