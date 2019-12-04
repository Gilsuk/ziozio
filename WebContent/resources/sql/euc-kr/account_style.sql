CREATE TABLE account_style (
	account_no NUMBER,
	style_code  NUMBER,
	CONSTRAINT account_style_to_account_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no ),
    CONSTRAINT account_style_to_style_fk
	FOREIGN KEY ( style_code )
	REFERENCES style ( style_code )
);

ALTER TABLE account_style
ADD PRIMARY KEY (account_no, style_code);

INSERT INTO ACCOUNT_STYLE (account_no, style_code)
VALUES (1, 1);

INSERT INTO ACCOUNT_STYLE (account_no, style_code)
VALUES (1, 3);

INSERT INTO ACCOUNT_STYLE (account_no, style_code)
VALUES (2, 2);

commit;
