DROP TABLE location;

CREATE TABLE location (
	location_code NUMBER PRIMARY KEY,
	location_do   VARCHAR2(15) NOT NULL,
	location_si   VARCHAR2(15) NOT NULL,
	location_dong VARCHAR2(15) NOT NULL
);

INSERT INTO LOCATION (location_code, location_do, location_si, location_dong)
VALUES (1, 'doA', 'siA', 'dongA');

INSERT INTO LOCATION (location_code, location_do, location_si, location_dong)
VALUES (2, 'doB', 'siB', 'dongB');

INSERT INTO LOCATION (location_code, location_do, location_si, location_dong)
VALUES (3, 'doC', 'siC', 'dongC');

SELECT * FROM location;
