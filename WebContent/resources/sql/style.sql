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

SELECT * FROM style;