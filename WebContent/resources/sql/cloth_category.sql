DROP TABLE cloth_category CASCADE CONSTRAINT;

CREATE TABLE cloth_category (
	cloth_category_code NUMBER primary key,
	cloth_category_name VARCHAR2(50) NOT NULL
);

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (1, '상의');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (2, '하의');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (3, '외투');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (4, '우산');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (5, '마스크');

commit;

SELECT * FROM cloth_category;
