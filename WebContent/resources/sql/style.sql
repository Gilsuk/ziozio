DROP TABLE style;

CREATE TABLE style (
	style_code NUMBER primary key,	
	style_name VARCHAR2(30) NOT NULL
);

INSERT INTO style (style_code, style_name)
VALUES (1, 'feminine');

INSERT INTO style (style_code, style_name)
VALUES (2, 'chic');

INSERT INTO style (style_code, style_name)
VALUES (3, 'dandy');

INSERT INTO style (style_code, style_name)
VALUES (4, 'dandy');

INSERT INTO style (style_code, style_name)
VALUES (5, 'dandy');
--페미닌 시크 댄디
--비즈니스 캐주얼 

SELECT * FROM style;