DROP TABLE account_library CASCADE CONSTRAINT;--실제 옷장

CREATE TABLE account_library (
	account_no NUMBER,
	cloth_code NUMBER,
	color_code NUMBER,
    -- 외래키
	CONSTRAINT account_library_to_account_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no ),
    -- 외래키
	CONSTRAINT account_library_to_color_fk
	FOREIGN KEY ( color_code )
	REFERENCES color ( color_code ),
	-- 외래키
    CONSTRAINT account_library_to_cloth_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code )
);

ALTER TABLE account_library
ADD PRIMARY KEY (account_no, cloth_code, color_code);
-- 1번 유저가 티셔츠(1) 빨간색(1)을 가지고 있음
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (1, 1, 1);
-- 1번 유저가 블라우스(2) 빨간색(1)을 보유중
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (1, 2, 1);
-- 1번 유저가 롱패딩(3) 빨간색(1)을 보유중
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (1, 3, 1);
-- 1번 유저가 롱패딩(3) 빨간색(1)을 보유중
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (2, 2, 1);
-- 1번 유저가 롱패딩(3) 빨간색(1)을 보유중
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (2, 3, 1);
-- 1번 유저가 롱패딩(3) 빨간색(1)을 보유중
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (2, 1, 1);
-- 1번 유저가 롱패딩(3) 빨간색(1)을 보유중
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (3, 3, 1);

commit;

SELECT * FROM account_library;