DROP TABLE cloth_style;

CREATE TABLE cloth_style (
	cloth_code NUMBER,
	style_code NUMBER,
	
    -- cloth, style 테이블과 외래키 연결
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
VALUES (1, 4); -- 티셔츠(옷 코드1)는 비지니스(스타일 코드 4) 

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 5); -- 티셔츠(1)는 캐쥬얼(5) ** 비지니스이면서 캐쥬얼이기도 함

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (3, 3); -- 롱패딩(5)은 캐쥬얼(??? 5)

commit;

SELECT * FROM cloth_style;
--면티= 캐주얼, 비즈니스, (무제한연결가능, 혹은 연결안해도 무방)