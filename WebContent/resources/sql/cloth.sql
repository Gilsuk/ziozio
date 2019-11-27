DROP TABLE cloth;

CREATE TABLE cloth (
	cloth_code NUMBER primary key,	--옷코드(외투,상의,하의)
	cloth_category_code NUMBER,		--카테고리코드(상의-블라우스, 면티,...)
	cloth_name VARCHAR2(50),		--옷 이름
	cloth_description VARCHAR2(255),--옷관련 설명(?)
	cloth_links VARCHAR2(255),		--연결되는 사이트링크
	cloth_gender CHAR(1),			--성별(여성,중성,남성)

	-- cloth_category TB 외래키 연결
	CONSTRAINT cloth_category_code_fk
	FOREIGN KEY (cloth_category_code)
	REFERENCES cloth_category(cloth_category_code)
);

--Test Data
INSERT INTO cloth (
	cloth_code, cloth_category_code,
	cloth_name, cloth_description,
	cloth_links, cloth_gender
)VALUES (
	1, 102, '코트', '롱코트', 
	'https://store.musinsa.com/app/product/detail/668860/0', 'N'
);

-- 데이터 확인
SELECT * FROM cloth;
