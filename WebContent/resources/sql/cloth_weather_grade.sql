DROP TABLE cloth_weather_grade;

CREATE TABLE cloth_weather_grade (
	cloth_code NUMBER NOT NULL,
	temperature_grade_code NUMBER NOT NULL,

    CONSTRAINT cloth_weather_gr_to_clo_co_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code ),
    
    CONSTRAINT cloth_weather_gr_to_temp_co_fk
	FOREIGN KEY ( temperature_grade_code )
	REFERENCES temperature_grade ( temperature_grade_code )
    
);    

INSERT INTO CLOTH_WEATHER_GRADE (cloth_code, temperature_grade_code)
VALUES (1, 1);

INSERT INTO CLOTH_WEATHER_GRADE (cloth_code, temperature_grade_code)
VALUES (2, 2);

INSERT INTO CLOTH_WEATHER_GRADE (cloth_code, temperature_grade_code)
VALUES (3, 3);

SELECT * FROM cloth_weather_grade;