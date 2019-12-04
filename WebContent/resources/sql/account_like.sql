DROP TABLE account_like CASCADE CONSTRAINT;--하트모음옷장

CREATE TABLE account_like (
	account_no NUMBER,
	cloth_set_no NUMBER,
	cloth_category_code NUMBER,
    
    -- account, cloth_combined 테이블과 외래키 연결
	CONSTRAINT account_like_to_account_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no ),
    
    CONSTRAINT account_like_to_cloth_set_fk
	FOREIGN KEY ( cloth_set_no, cloth_category_code )
	REFERENCES cloth_set ( cloth_set_no, cloth_category_code )
    
);

ALTER TABLE account_like
ADD PRIMARY KEY (account_no, cloth_set_no);

INSERT INTO ACCOUNT_LIKE (account_no, cloth_set_no)
VALUES (1, 1); -- 1번 유저가 1번 조합에 좋아요를 표시함

INSERT INTO ACCOUNT_LIKE (account_no, cloth_set_no)
VALUES (1, 2); -- 1번 유저가 2번 조합에 좋아요를 누름

INSERT INTO ACCOUNT_LIKE (account_no, cloth_set_no)
VALUES (2, 1); -- 2번 유저가 1번 조합에 좋아요를 누름

commit;

SELECT * FROM account_like;