DROP TABLE account_grade;

CREATE TABLE account_grade (
	account_grade_code NUMBER PRIMARY KEY,
	account_grade_name VARCHAR2(30) NOT NULL
);

INSERT INTO ACCOUNT_GRADE (account_grade_code, account_grade_name)
VALUES (1, 'MANAGER');

INSERT INTO ACCOUNT_GRADE (account_grade_code, account_grade_name)
VALUES (101, 'VISITOR');

INSERT INTO ACCOUNT_GRADE (account_grade_code, account_grade_name)
VALUES (102, 'USER');

commit;

SELECT * FROM account_grade;