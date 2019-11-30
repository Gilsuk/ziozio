DROP TABLE cloth_weather;

CREATE TABLE cloth_weather (
	cloth_code NUMBER,
	weather_code NUMBER,
    
    CONSTRAINT cloth_weather_to_cloth_co_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code ),
    
    CONSTRAINT cloth_weather_to_weather_co_fk
	FOREIGN KEY ( weather_code )
	REFERENCES weather ( weather_code )    
    
);

ALTER TABLE cloth_weather
ADD PRIMARY KEY (cloth_code, weather_code);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (1, 1); -- 티셔츠(1)는 맑은 날(1)에 어울림

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (2, 2); -- 블라우스(2)는 흐린 날(2)에 어울림

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (3, 3); -- 롱패딩(3)은 비오늘 날(3)에 어울림

commit;

SELECT * FROM cloth_weather;