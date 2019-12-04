DROP TRIGGER cloth_on_insert_trg;
DROP SEQUENCE cloth_seq;
DROP TABLE cloth CASCADE CONSTRAINT;

CREATE TABLE cloth (
	cloth_code NUMBER primary key,
	cloth_category_code NUMBER NOT NULL,
	cloth_name VARCHAR2(50) NOT NULL,
	cloth_link_url VARCHAR2(255) NOT NULL,
	cloth_gender CHAR(1) NOT NULL,
	cloth_img VARCHAR2(255) DEFAULT '/resource/img/clothes/default.png' NOT NULL,
	-- 외래키
    CONSTRAINT cloth_to_cloth_category_fk
	FOREIGN KEY ( cloth_category_code )
	REFERENCES cloth_category ( cloth_category_code ),
	-- 제약조건
    CONSTRAINT cloth_gender_ck
	CHECK (cloth_gender IN('N', 'M', 'F'))
);

CREATE SEQUENCE cloth_seq;

CREATE OR REPLACE TRIGGER cloth_on_insert_trg
  BEFORE INSERT ON cloth
  FOR EACH ROW
BEGIN
  :new.cloth_code := cloth_seq.nextval;
END;
/

commit;
----------------------이미지 포함//링크는 미포함인거 아닌가...?실제 내옷장 칸을 이미지로 대체하는걸로 이해하고있었는뎅
----------------------목도리 왜 있는거지.. 겉옷에 포함시켜줘야하냐..?check_muffler, muffler
-- 카테고리 코드 1:상의 2:하의 3:겉옷 4:우산 5:마스크
 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '블라우스', 'link', 'F', '/resources/img/look/blouse.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '얇은긴팔', 'link', 'N', '/resources/img/look/thin_long_sleeved_shirt.png');------------------

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '체크 셔츠', 'link', 'N', '/resources/img/look/check_shirt.png' ); --------------------남방이랑 다른점?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '남성용 민소매', 'link', 'M', '/resources/img/look/sleeveless_shirt_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '여성용 민소매', 'link', 'F', '/resources/img/look/sleeveless_shirt_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '스웨터', 'link', 'N', '/resources/img/look/sweater.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '후드', 'link', 'N', '/resources/img/look/hoodie.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '남성용 내의', 'link', 'M', '/resources/img/look/innerwear_top_man.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '여성용 내의', 'link', 'F', '/resources/img/look/innerwear_top_woman.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '내의?', 'link', 'M', '/resources/img/look/long_sleeved_shirt_man.png');--남성용 내의와 다른점?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '맨투맨', 'link', 'N', '/resources/img/look/mantoman.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '터틀넥', 'link', 'N', '/resources/img/look/neck_shirt.png');-------------------------------왜 터틀넥..?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '여름용 셔츠', 'link', 'N', '/resources/img/look/shirts_thin.png'); -------------------------남성용과 다른점?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '체크남방', 'link', 'M', '/resources/img/look/short_sleeved_check.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '남자용셔츠', 'link', 'M', '/resources/img/look/short_sleeved_shirts_man.png'); --여름용 셔츠랑 다른점?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '여자용셔츠', 'link', 'F', '/resources/img/look/short_sleeved_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '민소매원피스', 'link', 'F', '/resources/img/look/sleeveless_dress.png'); ----------원피스는 분류가 모야?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '반팔원피스', 'link', 'M', '/resources/img/look/short_sleeved_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '긴팔원피스', 'link', 'F', '/resources/img/look/long_sleeved_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '남성용반바지', 'link', 'M', '/resources/img/look/shorts_man.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '여성용반바지', 'link', 'F', '/resources/img/look/shorts_woman.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '여성용 내의', 'link', 'F', '/resources/img/look/innerwear_under_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '남성용 내의', 'link', 'M', '/resources/img/look/innerwear_under_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '청바지', 'link', 'N', '/resources/img/look/jeans.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '면바지', 'link', 'N', '/resources/img/look/cotton_trousers.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '롱치마', 'link', 'F', '/resources/img/look/long_skirt.png');---------------------치마 한개 밖에 없어열..ㅠㅜ

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '얇은 가디건', 'link', 'N', '/resources/img/look/thin_cardigan.png');--그럼 위에 가디건은 두꺼운 가디건으로 바꿔야하나(통합)

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '가디건', 'link', 'N', '/resources/img/look/cardigan.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '코트', 'link', 'N', '/resources/img/look/coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '더플코트', 'link', 'F', '/resources/img/look/dufflecoat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '트렌치코트', 'link', 'N', '/resources/img/look/trenchcoat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '퍼코트', 'link', 'N', '/resources/img/look/fur_coat.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '재킷', 'link', 'N', '/resources/img/look/jackaet.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '헌팅재킷', 'link', 'M', '/resources/img/look/huntingjacket.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '라이더재킷', 'link', 'N', '/resources/img/look/leather_jacket.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '조끼패딩', 'link', 'N', '/resources/img/look/vest_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '숏패딩', 'link', 'N', '/resources/img/look/short_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '롱패딩', 'https://store.musinsa.com/app/product/detail/1094521/0', 'N', '/resources/img/look/long_padding.png' );


commit;

SELECT * FROM cloth;