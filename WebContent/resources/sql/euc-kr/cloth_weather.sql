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
VALUES (1, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (1, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (1, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (1, 4); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (2, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (2, 2); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (2, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (3, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (3, 2); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (3, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (4, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (4, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (5, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (5, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (6, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (6, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (6, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (6, 4); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (7, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (7, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (7, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (7, 4); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (11, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (11, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (11, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (11, 4); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (13, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (13, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (13, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (14, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (14, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (14, 3); 
 
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (15, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (15, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (15, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (15, 4); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (16, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (16, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (16, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (16, 4); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (17, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (17, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (18, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (18, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (19, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (19, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (19, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (19, 4); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (20, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (20, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (20, 3); 
 
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (21, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (21, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (21, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (24, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (24, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (24, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (24, 4); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (25, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (25, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (25, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (25, 4); 

commit;
