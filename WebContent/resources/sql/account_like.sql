DROP TABLE account_like;--하트모음옷장

CREATE TABLE account_like (
	account_no NUMBER NOT NULL,
	cloth_combined_no  NUMBER NOT NULL,
    
    -- account, cloth_combined 테이블과 외래키 연결
	CONSTRAINT account_like_to_account_no_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no ),
    
    CONSTRAINT account_like_to_cloth_comb_fk
	FOREIGN KEY ( cloth_combined_no )
	REFERENCES cloth_combined ( cloth_combined_no )
    
    
);

INSERT INTO ACCOUNT_LIKE (account_no, cloth_combined_no)
VALUES (1, 1);

INSERT INTO ACCOUNT_LIKE (account_no, cloth_combined_no)
VALUES (2, 2);

INSERT INTO ACCOUNT_LIKE (account_no, cloth_combined_no)
VALUES (3, 3);

SELECT * FROM account_like;