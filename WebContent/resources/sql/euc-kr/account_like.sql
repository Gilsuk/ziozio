CREATE TABLE account_like (
	account_no NUMBER,
	cloth_set_no NUMBER,
	cloth_category_code NUMBER,
	CONSTRAINT account_like_to_account_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no )
);

ALTER TABLE account_like
ADD PRIMARY KEY (account_no, cloth_set_no);
INSERT INTO ACCOUNT_LIKE (account_no, cloth_set_no)
VALUES (1, 1);
INSERT INTO ACCOUNT_LIKE (account_no, cloth_set_no)
VALUES (1, 2);
INSERT INTO ACCOUNT_LIKE (account_no, cloth_set_no)
VALUES (2, 1);

commit;
