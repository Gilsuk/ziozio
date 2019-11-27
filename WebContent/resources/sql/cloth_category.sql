DROP TABLE cloth_category;

CREATE TABLE cloth_category (

	cloth_category_code NUMBER,
	cloth_category_name VARCHAR2(50)
	,
    CONSTRAINT cloth_category_pk
    PRIMARY KEY ( cloth_category_code )
);

--Test Data
INSERT INTO cloth_category (
	cloth_category_name, cloth_category_code
)VALUES (
	'coat', 102);

-- 데이터 확인
SELECT * FROM cloth_category;
