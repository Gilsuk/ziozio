DROP TABLE weather CASCADE CONSTRAINT;

CREATE TABLE weather (
	weather_code NUMBER PRIMARY KEY,
	weather_name VARCHAR2(30) NOT NULL
);

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (1, '맑음');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (2, '흐림');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (3, '비');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (4, '눈');

commit;

SELECT * FROM weather;