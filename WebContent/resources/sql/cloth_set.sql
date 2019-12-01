DROP TABLE cloth_set;--세트 조합(세개가 아니라 원피스?하나일수도)

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

-- 복수 프라임 키
ALTER TABLE cloth_set
ADD PRIMARY KEY (cloth_set_no, cloth_category_code);

INSERT INTO CLOTH_SET (cloth_set_no, cloth_category_code, cloth_code, color_code)
VALUES (1, 1, 1, 1); -- 1번 세트에 상의(1)가 티셔츠(1) 이고 빨강(1)색임.

INSERT INTO CLOTH_SET (cloth_set_no, cloth_category_code, cloth_code, color_code)
VALUES (1, 3, 3, 1); -- 1번 세트의 외투(3)가 롱패딩(3) 빨간색(1)

INSERT INTO CLOTH_SET (cloth_set_no, cloth_category_code, cloth_code, color_code)
VALUES (2, 1, 2, 1); -- 2번 세트의 상의(1)가 블라우스(2) 빨간색(1)

commit;

SELECT * FROM cloth_set;