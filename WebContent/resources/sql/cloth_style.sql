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
--clothcode안에 여러가지 style_code들어갈수있음. 
--ex)VALUES (1, 4); VALUES (1, 5);  티셔츠(1)는 비지니스(4)이면서 캐쥬얼(5)이기도 함

--★cloth_code: 3,8,9,10,12★ 22부터 없어용


--블라우스/ 페미닌, 시크, 비즈니스, 데이트
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 4);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (1, 8);

--얇은긴팔/페미닌, 시크, 캐주얼, 심플베이직
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (2, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (2, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (2, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (2, 6);

--남성용 민소매
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (4, 5);

--여성용 민소매
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (5, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (5, 9);

--스웨터/페미닌, 시크, 댄디, 캐주얼, 심플베이직, 데이트
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

--후드/캐주얼, 심플베이직
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (7, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (7, 6);

--맨투맨/캐주얼, 심플베이직
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (11, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (11, 6);

--여름용 셔츠/시크, 댄디, 비즈니스, 데이트
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (13, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (13, 3);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (13, 4);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (13, 8);

--체크남방/캐주얼
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (14, 5);

--남자용셔츠/시크, 댄디, 비즈니스, 심플, 데이트
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

--여자용 셔츠/페미닌, 시크, 비즈니스, 심플베이직
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (16, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (16, 2);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (16, 4);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (16, 6);

--민소매 원피스/페미닌, 데이트, 섹시
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (17, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (17, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (17, 9);

--반팔 원피스/페미닌, 데이트, 섹시
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (18, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (18, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (18, 9);

--긴팔 원피스/페미닌, 데이트, 섹시
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (19, 1);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (19, 8);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (19, 9);

--남성용반바지/비즈니스, 캐주얼, 심플베이직
INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (20, 4);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (20, 5);

INSERT INTO CLOTH_STYLE (cloth_code, style_code)
VALUES (20, 6);

--여성용 반바지/시크, 캐주얼, 심플베이직, 유니크, 섹시글램
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

--청바지/페미닌, 시크, 댄디, 캐주얼, 심플베이직, 유니크, 데이트
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

SELECT * FROM cloth_style;
--면티= 캐주얼, 비즈니스, (무제한연결가능, 혹은 연결안해도 무방)