DROP TABLE cookie;

CREATE TABLE cookie (
    cookie_id CHAR(8),
    cookie_ip VARCHAR2(15),
    account_no NUMBER NOT NULL,
    cookie_last_login DATE DEFAULT sysdate NOT NULL
);

ALTER TABLE cookie
ADD PRIMARY KEY (cookie_id, cookie_ip);

ALTER TABLE cookie
ADD FOREIGN KEY (account_no)
REFERENCES account (account_no);