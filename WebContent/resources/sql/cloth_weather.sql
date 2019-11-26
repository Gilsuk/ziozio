DROP TABLE cloth_weather;

CREATE TABLE cloth_weather (
	cloth_code NUMBER NOT NULL,
	weather_code NUMBER NOT NULL,
    
    CONSTRAINT cloth_weather_to_cloth_co_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code ),
    
    CONSTRAINT cloth_weather_to_weather_co_fk
	FOREIGN KEY ( weather_code )
	REFERENCES weather ( weather_code )    
    
);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (1, 1);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (2, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (3, 3);


SELECT * FROM cloth_weather;