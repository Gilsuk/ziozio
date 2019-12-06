CREATE TABLE verification (
    verification_type CHAR(1),
    account_no NUMBER,
    verification_code CHAR(64) NOT NULL,
    verification_date DATE DEFAULT sysdate NOT NULL,
	CONSTRAINT verification_type_ck
	CHECK (verification_type IN('M', 'F'))
);

ALTER TABLE verification
ADD PRIMARY KEY (verification_type, account_no);

ALTER TABLE verification
ADD FOREIGN KEY (account_no)
REFERENCES account (account_no);