CREATE TABLE cloth_style (
	cloth_code NUMBER,
	style_code NUMBER,
	CONSTRAINT cloth_style_to_cloth_code_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code ),
    CONSTRAINT cloth_style_to_style_code_fk
	FOREIGN KEY ( style_code )
	REFERENCES style ( style_code )	
);

ALTER TABLE cloth_style
ADD PRIMARY KEY (cloth_code, style_code);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 4);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (2, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (2, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (2, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (2, 6);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (4, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (5, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (5, 9);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (6, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (6, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (6, 3);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (6, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (6, 6);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (6, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (7, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (7, 6);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (11, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (11, 6);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (13, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (13, 3);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (13, 4);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (13, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (14, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (15, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (15, 3);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (15, 4);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (15, 6);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (15, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (16, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (16, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (16, 4);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (16, 6);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (17, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (17, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (17, 9);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (18, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (18, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (18, 9);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (19, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (19, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (19, 9);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (20, 4);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (20, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (20, 6);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (21, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (21, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (21, 6);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (21, 7);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (21, 9);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (24, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (24, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (24, 3);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (24, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (24, 6);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (24, 7);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (24, 8);

commit;
