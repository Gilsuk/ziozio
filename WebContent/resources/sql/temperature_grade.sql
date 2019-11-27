DROP TABLE temperature_grade;

CREATE TABLE temperature_grade (
	temperature_grade_code NUMBER PRIMARY KEY,
	temperature_grade_desc VARCHAR2(225) NOT NULL
);

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (1, ' temperatureA');

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (2, ' temperatureB');

INSERT INTO TEMPERATURE_GRADE (temperature_grade_code, temperature_grade_desc)
VALUES (3, ' temperatureC');

SELECT * FROM temperature_grade;