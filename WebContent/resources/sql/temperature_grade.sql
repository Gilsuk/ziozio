DROP TABLE temperature_grade;

CREATE TABLE temperature_grade (
	temperature_grade_code NUMBER PRIMARY KEY,
	temperature_grade_desc VARCHAR2(225) NOT NULL
);

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (1, ' 27도 이상 ');

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (2, ' 23~ 27도');

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (3, ' 20~ 23도');

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (4, ' 17~ 20도');

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (5, ' 12~ 17도');

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (6, ' 10~ 12도');

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (7, ' 6~ 10도');

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (8, ' 6도 이하 ');


SELECT * FROM temperature_grade;