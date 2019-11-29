DROP TABLE cloth;

CREATE TABLE cloth (
	cloth_code NUMBER primary key,			--옷코드(외투1,상의2,하의3)
	cloth_category_code NUMBER NOT NULL,	--카테고리코드(상의-블라우스101, 면티,...)
	cloth_name VARCHAR2(50) NOT NULL,		--옷 이름
	cloth_description VARCHAR2(255) NOT NULL,--옷관련 설명(?)
	cloth_links VARCHAR2(255) NOT NULL,		--연결되는 사이트링크
	cloth_gender CHAR(1) NOT NULL,			--성별(여성,중성,남성)
    
    CONSTRAINT cloth_to_cloth_category_fk
	FOREIGN KEY ( cloth_category_code )
	REFERENCES cloth_category ( cloth_category_code ),
    
    CONSTRAINT cloth_gender_ck
	CHECK (cloth_gender IN('N', 'M', 'F'))
    
);

INSERT INTO CLOTH (cloth_code, cloth_category_code, cloth_name, cloth_description, cloth_links, cloth_gender)
VALUES (1, 101, 'nameA', 'descriptionA', 'linksA', 'F');

INSERT INTO CLOTH (cloth_code, cloth_category_code, cloth_name, cloth_description, cloth_links, cloth_gender)
VALUES (2, 201, 'nameB', 'descriptionB', 'linksA', 'M');

INSERT INTO CLOTH (cloth_code, cloth_category_code, cloth_name, cloth_description, cloth_links, cloth_gender)
VALUES (3, 3, 'nameC', 'descriptionC', 'linksA', 'N');

SELECT * FROM cloth;
