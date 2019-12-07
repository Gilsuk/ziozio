DROP TRIGGER weather_info_on_insert_trg;
DROP TABLE weather_info CASCADE CONSTRAINT;

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
-- 프라임 키 설정
ALTER TABLE weather_info
ADD PRIMARY KEY (weather_info_date, location_code);

-- insert또는 update 발생시 temperature_grade_code 열을 자동으로 삽입해주는 트리거,
-- 따라서 데이터 삽입시 temperature_grade_code를 별도로 입력하지 말것
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

-- 날씨 더미데이터 추가 필요


-- 첫번째 : 날짜+시간
-- 두번째 : 지역코드 (1168091100:역삼1동, 1165090200:서초2동)
-- 세번째 : 날씨(1 맑음, 2 흐림, 3 비, 4 눈)
-- 네 번째 : 온도(섭씨) 소수점 가능
-- 다섯 : 미세먼지 농도


--1168091100:역삼1동 / 2019.12.06
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 00:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 4.3, 75);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 01:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 6.3, 53);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 02:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 3.9, 160);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 03:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 6, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 04:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 7.3, 123);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 05:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -1, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 06:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -4.6, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 07:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -2, 16);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 08:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 15.3, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 09:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 35.8, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 10:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 32, 88);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 11:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 10, 100);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 12:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -16.5, 143);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 13:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4, 213);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 14:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 23, 21);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 15:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 21.1, 344);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 16:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 2, 231);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 17:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -2, 42);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 18:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -3, 14);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 19:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 12.6, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 20:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 23, 75);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 21:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, -5, 24);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 22:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, -3.2, 234);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 23:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 23, 35);



--1168091100:역삼1동 / 2019.12.07
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 00:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 01:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -16.7, 342);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 02:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 2, 3);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 03:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -3.9, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 04:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 6.2, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 05:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, -2, 52);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 06:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 2, 2);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 07:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 1, 1);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 08:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -5.5, 342);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 09:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 3, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 10:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 23.7, 42);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 11:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -5.3, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 12:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 23.5, 4);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 13:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 17, 245);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 14:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 23, 174);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 15:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 9.7, 65);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 16:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -3, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 17:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 23, 25);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 18:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 40.2, 53);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 19:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 32, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 20:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -6, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 21:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 1, 2);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 22:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 0.6, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 23:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -3, 64);



--1168091100:역삼1동 / 2019.12.08
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 00:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -6, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 01:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -1, 22);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 02:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 2, 22);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 03:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 11.3, 111);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 04:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 3, 33);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 05:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 3, 333);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 06:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 3.6, 3);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 07:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, -4, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 08:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, -1, 323);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 09:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 0, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 10:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 12.4, 12);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 11:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -7, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 12:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -16, 342);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 13:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -1, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 14:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4, 54);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 15:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 0, 47);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 16:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -2, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 17:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 4.3, 24);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 18:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 34, 234);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 19:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -2.6, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 20:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -2.9, 37);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 21:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 12.3, 164);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 22:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 21.6, 12);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 23:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 6, 34);



--1168091100:역삼1동 / 2019.12.09
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 00:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 7.2, 24);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 01:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -6, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 02:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 9.7, 18);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 03:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -4, 44);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 04:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -3.8, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 05:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 23.3, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 06:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 23, 187);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 07:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -1, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 08:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 0.6, 31);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 09:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4, 39);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 10:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 2, 2);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 11:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 3.3, 3);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 12:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 1.1, 1);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 13:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -3, 3);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 14:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4, 4);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 15:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 4, 6);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 16:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 3, 9);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 17:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 9.5, 18);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 18:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4, 16);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 19:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 1, 2);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 20:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 6.7, 9);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 21:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 9, 81);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 22:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 2, 6);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 23:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -1.2, 29);



--1168091100:역삼1동 / 2019.12.10
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 00:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -2, 4);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 01:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, -14.6, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 02:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 23, 63);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 03:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 21.3, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 04:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -6, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 05:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -7, 117);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 06:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -34.7, 54);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 07:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -1, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 08:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -4.6, 31);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 09:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 4.5, 54);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 10:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 32, 87);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 11:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 0.8, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 12:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 0, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 13:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 11.1, 111);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 14:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 1.6, 1);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 15:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 33.6, 333);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 16:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, 2, 222);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 17:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 4, 44);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 18:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -1.1, 111);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 19:00','yyyy.mm.dd hh24:mi'), 1168091100, 4, -31, 32);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 20:00','yyyy.mm.dd hh24:mi'), 1168091100, 3, -1.6, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 21:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 4, 231);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 22:00','yyyy.mm.dd hh24:mi'), 1168091100, 2, 32.4, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 23:00','yyyy.mm.dd hh24:mi'), 1168091100, 1, 29.8, 65);












--1168091100:역삼1동 / 2019.12.06
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 00:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 12.5, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 01:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 32, 98);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 02:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 1.7, 100);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 03:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 4, 341);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 04:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -3, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 05:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -3.3, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 06:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 2, 98);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 07:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 13.7, 78);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 08:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 4.5, 134);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 09:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 31.8, 85);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 10:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 32, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 11:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 11.5, 234);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 12:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 12, 46);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 13:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -14.5, 98);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 14:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 8, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 15:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -16.8, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 16:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 24.3, 1);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 17:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 32, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 18:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 32.9, 8);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 19:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 12.4, 234);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 20:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 5, 65);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 21:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -7.4, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 22:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 8.1, 1);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.06 23:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 5, 0);






--1168091100:역삼1동 / 2019.12.07
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 00:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 34.7, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 01:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 2.8, 67);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 02:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 6, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 03:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 4.7, 98);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 04:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 2, 199);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 05:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 7, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 06:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 8.4, 100);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 07:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 12, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 08:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -16.8, 101);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 09:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -9, 54);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 10:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 32.6, 24);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 11:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -24, 6);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 12:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 2, 65);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 13:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 8.5, 87);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 14:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 4, 98);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 15:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -5.5, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 16:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 8, 56);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 17:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 5.2, 85);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 18:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -27.7, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 19:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 32, 46);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 20:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 34.9, 324);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 21:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 2, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 22:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 7.3, 1);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.07 23:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 5, 6);





--1168091100:역삼1동 / 2019.12.08
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 00:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 6, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 01:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 12.5, 5);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 02:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 24, 1);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 03:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 36.8, 245);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 04:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -4.5, 78);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 05:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -5.8, 87);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 06:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, -3.9, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 07:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 8, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 08:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 5, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 09:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 3.3, 21);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 10:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 8, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 11:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 9.7, 213);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 12:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -23.3, 43);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 13:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 4, 32);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 14:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 7, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 15:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 4.7, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 16:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -9, 32);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 17:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 10.4, 87);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 18:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 0.7, 78);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 19:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 0, 109);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 20:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 0.6, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 21:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 34.2, 47);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 22:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 5, 24);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.08 23:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -3, 187);





--1168091100:역삼1동 / 2019.12.09
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 00:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 7.4, 32);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 01:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 0, 8);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 02:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 23, 16);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 03:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -12.5, 28);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 04:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 11, 32);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 05:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 22.6, 48);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 06:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 33, 5);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 07:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 42.3, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 08:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 8, 90);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 09:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 3, 194);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 10:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -5.7, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 11:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 3.6, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 12:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -5, 87);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 13:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 8.2, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 14:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 9, 81);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 15:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 3.6, 72);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 16:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 6, 104);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 17:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -4.4, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 18:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 3, 74);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 19:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 5.7, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 20:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 8.4, 74);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 21:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 5.6, 87);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 22:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 9.3, 105);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.09 23:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 19.7, 142);





--1168091100:역삼1동 / 2019.12.10
INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 00:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 3, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 01:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 5.5, 23);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 02:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 5.6, 76);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 03:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -3, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 04:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -8, 239);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 05:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -34.1, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 06:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 34, 2);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 07:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 3, 6);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 08:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 8.5, 45);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 09:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 9, 6);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 10:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 0, 245);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 11:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 3.5, 56);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 12:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -1, 98);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 13:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -5.8, 99);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 14:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 5.5, 33);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 15:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 4.6, 65);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 16:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 8.9, 88);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 17:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 19, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 18:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 45.4, 2);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 19:00','yyyy.mm.dd hh24:mi'), 1165090200, 1, 3, 5);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 20:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -6.5, 0);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 21:00','yyyy.mm.dd hh24:mi'), 1165090200, 4, -9, 34);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 22:00','yyyy.mm.dd hh24:mi'), 1165090200, 3, 20.5, 76);

INSERT INTO weather_info (weather_info_date, location_code,
weather_code, weather_info_temperature, weather_info_finedust)
VALUES (to_date('2019.12.10 23:00','yyyy.mm.dd hh24:mi'), 1165090200, 2, 25, 78);




SELECT * FROM weather_info;