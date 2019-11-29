DROP TABLE weather_info;

CREATE TABLE weather_info (
	weather_info_date date NOT NULL,
	location_code NUMBER NOT NULL,
	weather_code NUMBER NOT NULL,
	temperature_grade_code NUMBER NOT NULL,
	weather_info_temperature NUMBER NOT NULL,
	weather_info_finedust NUMBER NOT NULL,
    
    CONSTRAINT weather_info_to_location_fk
	FOREIGN KEY ( location_code )
	REFERENCES location ( location_code ),
    
    CONSTRAINT weather_info_to_weather_fk
	FOREIGN KEY ( weather_code )
	REFERENCES weather ( weather_code ),
    
    CONSTRAINT weather_info_to_temp_gr_fk
	FOREIGN KEY ( temperature_grade_code )
	REFERENCES temperature_grade ( temperature_grade_code )
);

ALTER TABLE weather_info
ADD PRIMARY KEY (weather_info_date, location_code);

commit;

-- 날씨 더미데이터 추가 필요

SELECT * FROM weather_info;