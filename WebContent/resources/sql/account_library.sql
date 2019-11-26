DROP TABLE account_library;

CREATE TABLE account_library (
	account_no NUMBER NOT NULL,
	cloth_code  NUMBER NOT NULL,
    
    -- account, cloth 테이블과 외래키 연결 (식별자 길이가 너무길어 account_no_fk로 생성이 안됨)
	CONSTRAINT account_library_to_account_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no ),
    
    CONSTRAINT account_library_to_cloth_co_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code )
    
    
);

INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code)
VALUES (1, 1);

INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code)
VALUES (2, 2);

INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code)
VALUES (3, 3);


SELECT * FROM account_library;