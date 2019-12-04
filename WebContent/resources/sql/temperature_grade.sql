DROP TABLE temperature_grade CASCADE CONSTRAINT;

CREATE TABLE temperature_grade (
	temperature_grade_code NUMBER PRIMARY KEY,
	temperature_grade_from NUMBER NOT NULL,
	temperature_grade_to NUMBER NOT NULL
);

INSERT INTO TEMPERATURE_GRADE
VALUES (1, 27, 100);

INSERT INTO TEMPERATURE_GRADE
VALUES (2, 23, 26.99);

INSERT INTO TEMPERATURE_GRADE
VALUES (3, 20, 22.99);

INSERT INTO TEMPERATURE_GRADE
VALUES (4, 17, 19.99);

INSERT INTO TEMPERATURE_GRADE
VALUES (5, 12, 16.99);

INSERT INTO TEMPERATURE_GRADE
VALUES (6, 10, 11.99);

INSERT INTO TEMPERATURE_GRADE
VALUES (7, 6, 9.99);

INSERT INTO TEMPERATURE_GRADE
VALUES (8, -100, 5.99);

commit;

SELECT * FROM temperature_grade;