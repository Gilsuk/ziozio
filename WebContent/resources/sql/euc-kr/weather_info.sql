CREATE TABLE weather_info (
	weather_info_date date,
	location_code NUMBER,
	weather_code NUMBER NOT NULL,
	temperature_grade_code NUMBER NOT NULL,
	weather_info_temperature NUMBER NOT NULL,
	weather_info_finedust NUMBER NOT NULL
);

ALTER TABLE weather_info
ADD CONSTRAINT weather_info_to_location_fk
FOREIGN KEY ( location_code )
REFERENCES location ( location_code );

ALTER TABLE weather_info
ADD CONSTRAINT weather_info_to_temp_grade_fk
FOREIGN KEY ( temperature_grade_code )
REFERENCES temperature_grade ( temperature_grade_code );

ALTER TABLE weather_info
ADD CONSTRAINT weather_info_to_weather_fk
FOREIGN KEY ( weather_code )
REFERENCES weather ( weather_code );
ALTER TABLE weather_info
ADD PRIMARY KEY (weather_info_date, location_code);

CREATE OR REPLACE TRIGGER weather_info_on_insert_trg
	BEFORE INSERT OR UPDATE ON weather_info
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

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 00:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 4.5, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 01:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 4.5, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 02:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 4, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 03:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 0.1, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 04:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 0.5, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 05:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -1, 30);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 06:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -2.4, 30);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 07:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -1.6, 30);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 08:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -5, 14);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 09:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -10.1, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 10:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, -6, 4);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 11:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 5, 36);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 12:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 10, 70);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 13:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 16.7, 100);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 14:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 15, 100);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 15:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 13, 120);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 16:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -13.8, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 17:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 10, 5);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 18:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 4.7, 70);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 19:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, -3, 21);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 20:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, -12, 10);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 21:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -2, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 22:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 0.3, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 23:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 0, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 00:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, 0, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 01:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4.5, 70);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 02:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 13.5, 100);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 03:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 13, 95);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 04:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 10, 77);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 05:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 6.7, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 06:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 8.9, 80);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 07:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 4, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 08:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -30, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 09:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -34, 100);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 10:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -5, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 11:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -15, 58);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 12:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 0, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 13:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 0, 150);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 14:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -7, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 15:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 17.2, 75);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 16:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 4, 98);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 17:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -18, 88);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 18:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 12, 5);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 19:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 40, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 20:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 36, 100);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 21:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 29, 93);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 22:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 34, 161);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 23:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -30, 173);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 00:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -1, 152);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 01:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 4.5, 56);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 02:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 4, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 03:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4.5, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 04:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -3, 3);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 05:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 2, 20);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 06:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 11, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 07:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 21, 150);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 08:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 4, 124);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 09:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 35, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 10:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -12, 110);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 11:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -2, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 12:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 30, 22);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 13:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 16, 200);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 14:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4.5, 150);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 15:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 8, 194);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 16:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 17, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 17:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 0, 30);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 18:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 9, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 19:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -30, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 20:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 2, 120);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 21:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 2, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 22:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 4, 80);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 23:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 43, 4);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 00:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 21, 1);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 01:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 4, 44);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 02:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -20, 170);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 03:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -34, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 04:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -22, 120);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 05:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -3, 4);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 06:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -5, 120);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 07:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 4.6, 10);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 08:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 15.2, 70);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 09:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, -1, 33);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 10:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 6.3, 20);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 11:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 7.1, 30);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 12:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, -2.5, 68);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 13:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 40, 10);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 14:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, -4.3, 130);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 15:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -32, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 16:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -0.3, 42);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 17:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -2.6, 70);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 18:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 14, 30);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 19:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 6, 20);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 20:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -21.5, 36);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 21:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, -23, 200);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 22:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 4.5, 55);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.03 23:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, -2, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 00:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -2, 40);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 01:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -32, 6);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 02:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -12, 210);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 03:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, -0.6, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 04:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -4.5, 67);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 05:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, -17, 80);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 06:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -2, 76);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 07:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -5, 20);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 08:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -8.4, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 09:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -3, 130);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 10:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 43, 20);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 11:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 23.5, 120);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 12:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 4.5, 54);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 13:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 4, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 14:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 43, 55);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 15:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -12, 60);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 16:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, -2, 82);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 17:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 32, 53);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 18:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, -4.5, 10);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 19:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, -4.5, 11);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 20:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -4, 70);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 21:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 19, 19);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 22:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 5, 51);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.04 23:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 12, 5);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 00:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 7.3, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 01:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -4.5, 112);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 02:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -5, 150);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 03:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 27, 130);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 04:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -7.6, 90);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 05:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 3, 76);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 06:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 5, 82);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 07:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 16, 77);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 08:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -3, 70);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 09:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 32, 19);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 10:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 18, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 11:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, -10, 130);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 12:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -10.4, 13);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 13:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, -3, 50);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 14:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 2.4, 70);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 15:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 41, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 16:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 25, 2);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 17:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -2, 37);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 18:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 14, 85);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 19:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, -3, 8);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 20:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -4.7, 25);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 21:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -23, 30);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 22:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, -2, 130);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.05 23:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 2, 10);
