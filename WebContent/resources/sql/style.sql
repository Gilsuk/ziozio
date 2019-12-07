DROP TABLE style CASCADE CONSTRAINT;

CREATE TABLE style (
	style_code NUMBER primary key,	
	style_name VARCHAR2(30) UNIQUE NOT NULL
);

commit;

INSERT INTO style (style_code, style_name)
VALUES (1, '페미닌');

INSERT INTO style (style_code, style_name)
VALUES (2, '시크');

INSERT INTO style (style_code, style_name)
VALUES (3, '댄디');

INSERT INTO style (style_code, style_name)
VALUES (4, '비즈니스');

INSERT INTO style (style_code, style_name)
VALUES (5, '캐쥬얼');

INSERT INTO style (style_code, style_name)
VALUES (6, '심플베이직');

INSERT INTO style (style_code, style_name)
VALUES (7, '유니크');

INSERT INTO style (style_code, style_name)
VALUES (8, '데이트');

INSERT INTO style (style_code, style_name)
VALUES (9, '섹시글램');

commit;

SELECT * FROM style;