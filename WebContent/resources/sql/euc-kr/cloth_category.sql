CREATE TABLE cloth_category (
	cloth_category_code NUMBER primary key,
	cloth_category_name VARCHAR2(50) NOT NULL
);

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (1, '����');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (2, '����');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (3, '����');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (4, '���');

INSERT INTO CLOTH_CATEGORY (cloth_category_code, cloth_category_name)
VALUES (5, '����ũ');

commit;
