DROP TABLE cloth_style;

CREATE TABLE cloth_style (
	cloth_code NUMBER NOT NULL,
	style_code NUMBER NOT NULL,
	
    -- cloth, style 테이블과 외래키 연결
	CONSTRAINT cloth_style_to_cloth_code_fk
	FOREIGN KEY ( cloth_code )
	REFERENCES cloth ( cloth_code ),
    
    CONSTRAINT cloth_style_to_style_code_fk
	FOREIGN KEY ( style_code )
	REFERENCES style ( style_code )
	
);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (2, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (3, 3);

SELECT * FROM cloth_style;
--면티= 캐주얼, 비즈니스, (무제한연결가능, 혹은 연결안해도 무방)