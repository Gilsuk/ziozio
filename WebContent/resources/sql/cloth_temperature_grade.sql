DROP TABLE cloth_temperature_grade;

CREATE TABLE cloth_temperature_grade (
	cloth_code NUMBER,
	temperature_grade_code NUMBER    
);    

ALTER TABLE cloth_temperature_grade
ADD CONSTRAINT cloth_temp_grade_to_cloth_fk
FOREIGN KEY ( cloth_code )
REFERENCES cloth ( cloth_code );

ALTER TABLE cloth_temperature_grade
ADD CONSTRAINT cloth_temp_grd_to_temp_grd_fk
FOREIGN KEY ( temperature_grade_code )
REFERENCES temperature_grade ( temperature_grade_code );

ALTER TABLE cloth_temperature_grade
ADD PRIMARY KEY (cloth_code, temperature_grade_code);

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (1, 1); -- 티셔츠(1)은 27도 이상의 날씨(1)에 어울림

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (2, 2); -- 블라우스(2)는 23~27도(2)에 적합

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (3, 3); -- 롱패딩(3)은 20~23도(3)에 적합? 진짜로?

commit;