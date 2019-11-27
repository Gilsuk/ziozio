DROP TABLE cloth_category;

CREATE TABLE cloth_category (

	cloth_category_code NUMBER primary key,
	cloth_category_name VARCHAR2(50) NOT NULL
	
);

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (1, 'nameA');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (2, 'nameB');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (3, 'nameC');

SELECT * FROM cloth_category;