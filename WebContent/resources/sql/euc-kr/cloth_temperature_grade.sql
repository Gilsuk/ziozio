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
VALUES (1, 3); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (1, 4); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (1, 5);

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (1, 6); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (1, 7); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (2, 2); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (2, 3); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (2, 4); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (3, 3); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (3, 4); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (4, 1); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (4, 2); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (5, 1); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (5, 2); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (6, 6); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (6, 7);

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (6, 8);

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (7, 4); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (7, 5); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (7, 6); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (7, 7); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (11, 4); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (11, 5); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (11, 6); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (11, 7); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (13, 1); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (13, 2);

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (13, 3);

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (14, 4); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (14, 5); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (14, 6); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (15, 2); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (15, 3); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (15, 4); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (15, 5); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (15, 6); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (15, 7); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (15, 8); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (16, 2); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (16, 3); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (16, 4); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (16, 5); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (16, 6); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (16, 7); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (17, 1); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (17, 2); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (18, 2); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (18, 3); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (19, 4); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (19, 5); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (19, 6); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (19, 7); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (20, 1); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (20, 2); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (20, 3); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (21, 1); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (21, 2); 

INSERT INTO CLOTH_TEMPERATURE_GRADE (cloth_code, temperature_grade_code)
VALUES (21, 3); 

commit;
