DROP TABLE cloth_category;

CREATE TABLE cloth_category (

	cloth_category_code NUMBER primary key,
	cloth_category_name VARCHAR2(50) NOT NULL
	
);

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (1, '상의');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (2, '하의');ㄴ

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (3, '외투');

SELECT * FROM cloth_category;
