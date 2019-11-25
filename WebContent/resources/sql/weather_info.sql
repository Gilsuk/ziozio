DROP TABLE weather_info;

CREATE TABLE weather_info (
	weather_info_date date PRIMARY KEY,
	local_code NUMBER,
	weather_code NUMBER,
	temperature_grade_code NUMBER,
	weather_info_temperature NUMBER,
	weather_info_finedust NUMBER
);