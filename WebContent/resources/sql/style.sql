DROP TABLE style;

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
VALUES (4, '비지니스');

INSERT INTO style (style_code, style_name)
VALUES (5, '캐쥬얼');

commit;

SELECT * FROM style;