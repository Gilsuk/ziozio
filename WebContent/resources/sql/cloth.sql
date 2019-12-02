DROP TRIGGER cloth_on_insert_trg;
DROP SEQUENCE cloth_seq;
DROP TABLE cloth;

CREATE TABLE cloth (
	cloth_code NUMBER primary key,
	cloth_category_code NUMBER NOT NULL,
	cloth_name VARCHAR2(50) NOT NULL,
	cloth_link_url VARCHAR2(255) NOT NULL,
	cloth_gender CHAR(1) NOT NULL,
	cloth_img VARCHAR2(255) DEFAULT '/resource/img/clothes/default.png' NOT NULL,
    
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

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_links, cloth_gender)
VALUES (1, '티셔츠', 'link', 'N'); -- 1(상의)

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_links, cloth_gender)
VALUES (1, '블라우스', 'link', 'F'); -- 2(하의)

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_links, cloth_gender)
VALUES (3, '롱패딩', 'link', 'N'); -- 3(외투)

commit;

SELECT * FROM cloth;
