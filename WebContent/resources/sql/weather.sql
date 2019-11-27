DROP TABLE weather;

CREATE TABLE weather (
	weather_code NUMBER PRIMARY KEY,
	weather_name VARCHAR2(30) NOT NULL
);

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (1, 'nameA');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (2, 'nameB');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (3, 'nameC');


SELECT * FROM weather;