DROP TABLE weather_info;

CREATE TABLE weather_info (
	weather_info_date date DEFAULT SYSDATE NOT NULL PRIMARY KEY,
	location_code NUMBER NOT NULL,
	weather_code NUMBER NOT NULL,
	temperature_grade_code NUMBER NOT NULL,
	weather_info_temperature NUMBER NOT NULL,
	weather_info_finedust NUMBER NOT NULL,
    
    CONSTRAINT weather_info_to_location_co_fk
	FOREIGN KEY ( location_code )
	REFERENCES location ( location_code ),
    
    CONSTRAINT weather_info_to_weather_co_fk
	FOREIGN KEY ( weather_code )
	REFERENCES weather ( weather_code ),
    
    CONSTRAINT weather_info_to_temp_gr_fk
	FOREIGN KEY ( temperature_grade_code )
	REFERENCES temperature_grade ( temperature_grade_code )
);

INSERT INTO WEATHER_INFO (location_code, weather_code, temperature_grade_code, weather_info_temperature, weather_info_finedust)
VALUES (1, 1, 1, 1, 1);

INSERT INTO WEATHER_INFO (location_code, weather_code, temperature_grade_code, weather_info_temperature, weather_info_finedust)
VALUES (2, 2, 2, 2, 2);

INSERT INTO WEATHER_INFO (location_code, weather_code, temperature_grade_code, weather_info_temperature, weather_info_finedust)
VALUES (3, 3, 3, 3, 3);

SELECT * FROM weather_info;