DROP TABLE weather;

CREATE TABLE weather (
	weather_code NUMBER PRIMARY KEY,
	weather_name VARCHAR2(30) NOT NULL
);

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (1, 'sunny');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (2, 'cloudy');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (3, 'rainy');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (4, 'snowy');

SELECT * FROM weather;