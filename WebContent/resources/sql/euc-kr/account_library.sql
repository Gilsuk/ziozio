CREATE TABLE account_library (
	account_no NUMBER,
	cloth_code NUMBER,
	color_code NUMBER,
	CONSTRAINT account_library_to_account_fk
	FOREIGN KEY ( account_no )
	REFERENCES account ( account_no ),
	CONSTRAINT account_library_to_color_fk
	FOREIGN KEY ( color_code )
	REFERENCES color ( color_code ),
    CONSTRAINT account_library_to_cloth_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code )
);

ALTER TABLE account_library
ADD PRIMARY KEY (account_no, cloth_code, color_code);
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (1, 1, 1);
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (1, 2, 1);
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (1, 3, 1);
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (2, 2, 1);
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (2, 3, 1);
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (2, 1, 1);
INSERT INTO ACCOUNT_LIBRARY (account_no, cloth_code, color_code)
VALUES (3, 3, 1);

commit;
