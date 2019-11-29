DROP TABLE cloth_category;

CREATE TABLE cloth_category (

	cloth_category_code NUMBER primary key,
	cloth_category_name VARCHAR2(50) NOT NULL
	
);

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (101, '리본블라우스');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (201, 'nameB');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (301, '롱패딩');

SELECT * FROM cloth_category;
