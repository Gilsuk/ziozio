CREATE TABLE weather (
	weather_code NUMBER PRIMARY KEY,
	weather_name VARCHAR2(30) NOT NULL
);

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (1, '����');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (2, '�帲');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (3, '��');

INSERT INTO WEATHER (weather_code, weather_name)
VALUES (4, '��');

commit;
