DROP TRIGGER cloth_on_insert_trg;
DROP SEQUENCE cloth_seq;
DROP TABLE cloth;

CREATE TABLE cloth (
	cloth_code NUMBER primary key,			--옷코드(외투1,상의2,하의3)
	cloth_category_code NUMBER NOT NULL,	--카테고리코드(상의-블라우스101, 면티,...)
	cloth_name VARCHAR2(50) NOT NULL,		--옷 이름
	cloth_links VARCHAR2(255) NOT NULL,		--연결되는 사이트링크
	cloth_gender CHAR(1) NOT NULL,			--성별(여성,중성,남성)
    
    CONSTRAINT cloth_to_cloth_category_fk
	FOREIGN KEY ( cloth_category_code )
	REFERENCES cloth_category ( cloth_category_code ),
    
    CONSTRAINT cloth_gender_ck
	CHECK (cloth_gender IN('N', 'M', 'F'))
    
);
CREATE SEQUENCE cloth_seq;

-- 아래 트리거 생성 코드는 이클립스에서 실행 안됨
-- SQL Developer로 실행 할 것
CREATE OR REPLACE TRIGGER cloth_on_insert_trg
  BEFORE INSERT ON cloth
  FOR EACH ROW
BEGIN
  :new.cloth_code := cloth_seq.nextval;
END;
/

commit;



INSERT INTO CLOTH (cloth_code, cloth_category_code, cloth_name, cloth_links, cloth_gender)
VALUES (1, 101, 'nameA', 'linksA', 'F');

INSERT INTO CLOTH (cloth_code, cloth_category_code, cloth_name, cloth_links, cloth_gender)
VALUES (2, 201, 'nameB', 'linksA', 'M');

INSERT INTO CLOTH (cloth_code, cloth_category_code, cloth_name, cloth_links, cloth_gender)
VALUES (3, 3, 'nameC', 'linksA', 'N');

SELECT * FROM cloth;
