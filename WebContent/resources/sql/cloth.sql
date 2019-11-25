CREATE TABLE cloth (
	cloth_code NUMBER primary key,	--옷코드(외투,상의,하의)
	cloth_category_code NUMBER,			--카테고리코드(상의-블라우스, 면티,...)
	cloth_name VARCHAR2(50),		--옷 이름
	cloth_description VARCHAR2(255),--옷관련 설명(?)
	cloth_links VARCHAR2(255),		--연결되는 사이트링크
	cloth_gender NUMBER				--성별(여성,중성,남성)
);

SELECT * FROM cloth;

INSERT INTO cloth(
	cloth_code, category_code, 
	cloth_name, cloth_description, 
	cloth_links, cloth_gender)
VALUES ();

CREATE TABLE style (
	style_code NUMBER primary key,	--
	style_name VARCHAR2(30)			--
);

CREATE TABLE cloth_style (
	cloth_code NUMBER,
	style_code NUMBER
);

CREATE TABLE cloth_combined (
	cloth_combined_no NUMBER
	cloth_category_code NUMBER
	cloth_code NUMBER

	
);

CREATE TABLE cloth_category (
	cloth_category_code NUMBER,
	cloth_category_name VARCHAR2(50)
);

CREATE TABLE cloth_weather (
	cloth_code NUMBER,
	weather_code NUMBER

);

CREATE TABLE cloth_weather_grade (
	cloth_code NUMBER,
	temperature_grade_code)
);

CREATE TABLE temperature_grade (
	temperature_grade_code NUMVBER,
	temperature_grade_desc VARCHAR2(225)

);

CREATE TABLE weather_info (
	weather_info_date date PRIMARY KEY,
	local_code NUMBER,
	weather_code,
	temperature_grade_code,
	weather_info_temperature,
	weather_info_finedust
);

CREATE TABLE local (
	local_code NUMBER PRIMARY KEY,
	local_do   VARCHAR2(15),
	local_si   VARCHAR2(15),
	local_dong VARCHAR2(15)
);

CREATE TABLE weather (
	weather_code NUMBER PRIMARY KEY,
	weather_name VARCHAR2(30)
);
