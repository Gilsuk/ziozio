DROP TABLE cloth_combined;

CREATE TABLE cloth_combined (
	cloth_combined_no NUMBER primary key,
	cloth_category_code NUMBER NOT NULL,
	cloth_code NUMBER NOT NULL,
    
    CONSTRAINT cloth_combined_to_cloth_ca_fk
	FOREIGN KEY ( cloth_category_code )
	REFERENCES cloth_category ( cloth_category_code ),
    
    CONSTRAINT cloth_combined_to_cloth_co_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code )
    
);

INSERT INTO CLOTH_COMBINED (cloth_combined_no, cloth_category_code, cloth_code)
VALUES (1, 1, 1);

INSERT INTO CLOTH_COMBINED (cloth_combined_no, cloth_category_code, cloth_code)
VALUES (2, 2, 2);

INSERT INTO CLOTH_COMBINED (cloth_combined_no, cloth_category_code, cloth_code)
VALUES (3, 3, 3);


SELECT * FROM cloth_combined;