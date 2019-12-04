CREATE TABLE weather (
	weather_code NUMBER PRIMARY KEY,
	weather_name VARCHAR2(30) NOT NULL
);

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (1, '¸¼À½');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (2, 'Èå¸²');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (3, 'ºñ');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (4, '´«');

commit;
