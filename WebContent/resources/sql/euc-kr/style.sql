CREATE TABLE style (
	style_code NUMBER primary key,	
	style_name VARCHAR2(30) UNIQUE NOT NULL
);

commit;

INSERT INTO style (style_code, style_name)
VALUES (1, '��̴�');

INSERT INTO style (style_code, style_name)
VALUES (2, '��ũ');

INSERT INTO style (style_code, style_name)
VALUES (3, '���');

INSERT INTO style (style_code, style_name)
VALUES (4, '����Ͻ�');

INSERT INTO style (style_code, style_name)
VALUES (5, 'ĳ���');

INSERT INTO style (style_code, style_name)
VALUES (6, '���ú�����');

INSERT INTO style (style_code, style_name)
VALUES (7, '����ũ');

INSERT INTO style (style_code, style_name)
VALUES (8, '����Ʈ');

INSERT INTO style (style_code, style_name)
VALUES (9, '���ñ۷�');

commit;
