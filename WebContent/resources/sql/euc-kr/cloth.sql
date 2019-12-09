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

CREATE OR REPLACE TRIGGER cloth_on_insert_trg
  BEFORE INSERT ON cloth
  FOR EACH ROW
BEGIN
  :new.cloth_code := cloth_seq.nextval;
END;
/

commit;
 
INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '에이라인치마', 'link', 'F', '/resources/img/look/aline_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '야구점퍼', 'link', 'N', '/resources/img/look/baseball_jumper.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '블라우스', 'link', 'F', '/resources/img/look/blouse.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '블루종자켓', 'link', 'N', '/resources/img/look/blouson.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '부츠컷바지', 'link', 'F', '/resources/img/look/bootcut.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '가디건', 'link', 'N', '/resources/img/look/cardigan.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '카고바지', 'link', 'N', '/resources/img/look/cargo.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '체크목도리', 'link', 'N', '/resources/img/look/check_muffler.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '체크바지', 'link', 'N', '/resources/img/look/check_pattern.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '체크셔츠', 'link', 'N', '/resources/img/look/check_shirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '기본코트', 'link', 'N', '/resources/img/look/coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '코듀로이바지', 'link', 'N', '/resources/img/look/corduroy.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '면바지', 'link', 'N', '/resources/img/look/cotton_trousers.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '떡볶이코트', 'link', 'N', '/resources/img/look/duffle_coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '플리츠치마', 'link', 'F', '/resources/img/look/flitz_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '퍼코트', 'link', 'F', '/resources/img/look/fur_coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '헨리넥셔츠', 'link', 'M', '/resources/img/look/henry_neck.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '하이웨스트바지', 'link', 'F', '/resources/img/look/high_west.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '에이치라인치마', 'link', 'F', '/resources/img/look/Hline_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '후드', 'link', 'N', '/resources/img/look/hoodie.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '히트텍상의', 'link', 'M', '/resources/img/look/Inner_top_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '히트텍상의', 'link', 'F', '/resources/img/look/Inner_top_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '히트텍하의', 'link', 'M', '/resources/img/look/Inner_under_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '히트텍하의', 'link', 'F', '/resources/img/look/Inner_under_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '기본자켓', 'link', 'N', '/resources/img/look/jacket.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '청바지', 'link', 'N', '/resources/img/look/jeans.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '조거바지', 'link', 'N', '/resources/img/look/jogger.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '니트', 'link', 'N', '/resources/img/look/knit.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '니트치마', 'link', 'F', '/resources/img/look/knit_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '가죽자켓', 'link', 'N', '/resources/img/look/leather_jacket.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '레깅스', 'link', 'F', '/resources/img/look/leggings.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '경량패딩', 'link', 'N', '/resources/img/look/lightweight_long_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '경량조끼패딩', 'link', 'N', '/resources/img/look/lightweight_vest_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '롱패딩', 'link', 'N', '/resources/img/look/long_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '롱치마', 'link', 'F', '/resources/img/look/long_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '긴팔원피스', 'link', 'F', '/resources/img/look/long_sleeved_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '긴팔셔츠', 'link', 'M', '/resources/img/look/long_sleeved_shirt_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '맨투맨', 'link', 'N', '/resources/img/look/mantoman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '목도리', 'link', 'N', '/resources/img/look/muffler.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '목폴라', 'link', 'N', '/resources/img/look/neck_shirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '야상자켓', 'link', 'N', '/resources/img/look/night_trading.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '팬티스타킹', 'link', 'F', '/resources/img/look/panty_stockings.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '반팔셔츠', 'link', 'N', '/resources/img/look/shirts_thin.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '숏패딩', 'link', 'N', '/resources/img/look/short_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '반팔체크셔츠', 'link', 'N', '/resources/img/look/short_sleeved_check_shirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '반팔원피스', 'link', 'F', '/resources/img/look/short_sleeved_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '반팔셔츠', 'link', 'M', '/resources/img/look/short_sleeved_shirts_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '반팔셔츠', 'link', 'F', '/resources/img/look/short_sleeved_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '반바지', 'link', 'M', '/resources/img/look/shorts_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '반바지', 'link', 'F', '/resources/img/look/shorts_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '슬랙스', 'link', 'N', '/resources/img/look/slacks.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '민소매', 'link', 'N', '/resources/img/look/sleeveless.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '민소매원피스', 'link', 'F', '/resources/img/look/sleeveless_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '나시', 'link', 'M', '/resources/img/look/sleeveless_shirt_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '나시', 'link', 'F', '/resources/img/look/sleeveless_shirt_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '스웨터', 'link', 'N', '/resources/img/look/sweater.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '테니스치마', 'link', 'F', '/resources/img/look/tennis_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '얇은가디건', 'link', 'N', '/resources/img/look/thin_cardigan.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '얇은니트', 'link', 'N', '/resources/img/look/thin_knit.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '기본긴팔', 'link', 'N', '/resources/img/look/thin_long_sleeved_shirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '트랜치코트', 'link', 'N', '/resources/img/look/trench_coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '트러커자켓', 'link', 'N', '/resources/img/look/trucker_jacket.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '조끼패딩', 'link', 'N', '/resources/img/look/vest_padding.png');

commit;