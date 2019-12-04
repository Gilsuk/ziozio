DROP TABLE cloth_weather CASCADE CONSTRAINT;

CREATE TABLE cloth_weather (
	cloth_code NUMBER,
	weather_code NUMBER,
	-- 외래키
    CONSTRAINT cloth_weather_to_cloth_co_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code ),
	-- 외래키
    CONSTRAINT cloth_weather_to_weather_co_fk
	FOREIGN KEY ( weather_code )
	REFERENCES weather ( weather_code )    
);

ALTER TABLE cloth_weather
ADD PRIMARY KEY (cloth_code, weather_code);

-- 블라우스(1)는 맑은 날(1), 흐린날(2), 비(3), 눈이 오는날(4) 어울림
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (1, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (1, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (1, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (1, 4); 

--얇은 긴팔
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (2, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (2, 2); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (2, 3); 

--체크셔츠
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (3, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (3, 2); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (3, 3); 

--남성용 민소매
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (4, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (4, 2);

--여성용 민소매
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (5, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (5, 2);

--스웨터
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (6, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (6, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (6, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (6, 4); 

-- 후드
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (7, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (7, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (7, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (7, 4); 

-- 맨투맨
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (11, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (11, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (11, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (11, 4); 

-- 여름용 셔츠
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (13, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (13, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (13, 3); 

-- 체크남방
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (14, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (14, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (14, 3); 
 
--남성용 셔츠
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (15, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (15, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (15, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (15, 4); 

--여성용 셔츠
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (16, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (16, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (16, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (16, 4); 

--민소매 원피스
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (17, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (17, 2);

--반팔 원피스
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (18, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (18, 2);

--긴팔원피스
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (19, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (19, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (19, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (19, 4); 

--남성용반바지
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (20, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (20, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (20, 3); 
 
--여성용반바지
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (21, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (21, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (21, 3); 

--청바지
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (24, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (24, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (24, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (24, 4); 

--면바지
INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (25, 1); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (25, 2);

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (25, 3); 

INSERT INTO CLOTH_WEATHER (cloth_code, weather_code)
VALUES (25, 4); 



commit;

SELECT * FROM cloth_weather;