CREATE TABLE cloth_set (
	cloth_set_no NUMBER,
	cloth_category_code NUMBER,
	cloth_code NUMBER NOT NULL,
	color_code NUMBER NOT NULL,
    CONSTRAINT cloth_set_to_cloth_category_fk
	FOREIGN KEY ( cloth_category_code )
	REFERENCES cloth_category ( cloth_category_code ),
    CONSTRAINT cloth_set_to_color_fk
	FOREIGN KEY ( color_code )
	REFERENCES color ( color_code ),
    CONSTRAINT cloth_set_to_cloth_co_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code )
);

ALTER TABLE cloth_set
ADD PRIMARY KEY (cloth_set_no, cloth_category_code);

INSERT INTO CLOTH_SET (cloth_set_no, cloth_category_code, cloth_code, color_code)
VALUES (1, 1, 1, 1);

INSERT INTO CLOTH_SET (cloth_set_no, cloth_category_code, cloth_code, color_code)
VALUES (1, 3, 3, 1);

INSERT INTO CLOTH_SET (cloth_set_no, cloth_category_code, cloth_code, color_code)
VALUES (2, 1, 2, 1);

commit;
