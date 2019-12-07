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

INSERT INTO cookie (
    cookie_id, cookie_ip, account_no
) VALUES (
    'ake49dj2', '127.0.0.1', 1
);

commit;

SELECT
A.account_no no, A.account_email email, A.account_nick nick,
A.account_gender gender, A.account_signed_date signed_date,
A.account_verified account_verified, A.account_grade_code grade_code
FROM cookie C
INNER JOIN account A ON A.account_no = C.account_no
WHERE cookie_id = 'ake49dj2'
AND cookie_ip = '127.0.0.1'
AND cookie_last_login >= sysdate - 1;

UPDATE cookie
SET cookie_last_login = sysdate
WHERE cookie_id = 'ake49dj2'
AND cookie_ip = '127.0.0.1';
