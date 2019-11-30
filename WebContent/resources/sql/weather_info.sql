DROP TRIGGER weather_info_on_insert_trg;
DROP TABLE weather_info;

CREATE TABLE weather_info (
	weather_info_date date,
	location_code NUMBER,
	weather_code NUMBER NOT NULL,
	temperature_grade_code NUMBER NOT NULL,
	weather_info_temperature NUMBER NOT NULL,
	weather_info_finedust NUMBER NOT NULL,
    
    CONSTRAINT weather_info_to_location_fk
	FOREIGN KEY ( location_code )
	REFERENCES location ( location_code ),
    
    CONSTRAINT weather_info_to_temperature_grade_fk
	FOREIGN KEY ( temperature_grade_code )
	REFERENCES temperature_grade ( temperature_grade_code ),

    CONSTRAINT weather_info_to_weather_fk
	FOREIGN KEY ( weather_code )
	REFERENCES weather ( weather_code )
    
);

ALTER TABLE weather_info
ADD PRIMARY KEY (weather_info_date, location_code);

CREATE OR REPLACE TRIGGER weather_info_on_insert_trg
	BEFORE INSERT ON weather_info
	FOR EACH ROW
DECLARE
	tmpgrd NUMBER;
BEGIN
	SELECT temperature_grade_code INTO tmpgrd
	FROM temperature_grade
	WHERE :new.weather_info_temperature
	BETWEEN temperature_grade_from AND temperature_grade_to;
	:new.temperature_grade_code := tmpgrd;
END;
/

commit;

-- 날씨 더미데이터 추가 필요

SELECT * FROM weather_info;