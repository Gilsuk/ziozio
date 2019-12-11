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
VALUES (2, '���̶���ġ��', 'link', 'F', '/resources/img/look/aline_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�߱�����', 'link', 'N', '/resources/img/look/baseball_jumper.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���콺', 'link', 'F', '/resources/img/look/blouse.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '���������', 'link', 'N', '/resources/img/look/blouson.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '�����ƹ���', 'link', 'F', '/resources/img/look/bootcut.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�����', 'link', 'N', '/resources/img/look/cardigan.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, 'ī�����', 'link', 'N', '/resources/img/look/cargo.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, 'üũ�񵵸�', 'link', 'N', '/resources/img/look/check_muffler.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, 'üũ����', 'link', 'N', '/resources/img/look/check_pattern.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, 'üũ����', 'link', 'N', '/resources/img/look/check_shirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�⺻��Ʈ', 'link', 'N', '/resources/img/look/coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '�ڵ���̹���', 'link', 'N', '/resources/img/look/corduroy.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '�����', 'link', 'N', '/resources/img/look/cotton_trousers.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '��������Ʈ', 'link', 'N', '/resources/img/look/duffle_coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '�ø���ġ��', 'link', 'F', '/resources/img/look/flitz_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '����Ʈ', 'link', 'F', '/resources/img/look/fur_coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '��ؼ���', 'link', 'M', '/resources/img/look/henry_neck.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '���̿���Ʈ����', 'link', 'F', '/resources/img/look/high_west.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '����ġ����ġ��', 'link', 'F', '/resources/img/look/Hline_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '�ĵ�', 'link', 'N', '/resources/img/look/hoodie.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '��Ʈ�ػ���', 'link', 'M', '/resources/img/look/Inner_top_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '��Ʈ�ػ���', 'link', 'F', '/resources/img/look/Inner_top_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '��Ʈ������', 'link', 'M', '/resources/img/look/Inner_under_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '��Ʈ������', 'link', 'F', '/resources/img/look/Inner_under_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�⺻����', 'link', 'N', '/resources/img/look/jacket.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, 'û����', 'link', 'N', '/resources/img/look/jeans.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '���Ź���', 'link', 'N', '/resources/img/look/jogger.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '��Ʈ', 'link', 'N', '/resources/img/look/knit.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '��Ʈġ��', 'link', 'F', '/resources/img/look/knit_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '��������', 'link', 'N', '/resources/img/look/leather_jacket.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '���뽺', 'link', 'F', '/resources/img/look/leggings.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�淮�е�', 'link', 'N', '/resources/img/look/lightweight_long_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�淮�����е�', 'link', 'N', '/resources/img/look/lightweight_vest_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '���е�', 'link', 'N', '/resources/img/look/long_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '��ġ��', 'link', 'F', '/resources/img/look/long_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ȿ��ǽ�', 'link', 'F', '/resources/img/look/long_sleeved_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ȼ���', 'link', 'M', '/resources/img/look/long_sleeved_shirt_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������', 'link', 'N', '/resources/img/look/mantoman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�񵵸�', 'link', 'N', '/resources/img/look/muffler.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������', 'link', 'N', '/resources/img/look/neck_shirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�߻�����', 'link', 'N', '/resources/img/look/night_trading.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '��Ƽ��Ÿŷ', 'link', 'F', '/resources/img/look/panty_stockings.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ȼ���', 'link', 'N', '/resources/img/look/shirts_thin.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '���е�', 'link', 'N', '/resources/img/look/short_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '����üũ����', 'link', 'N', '/resources/img/look/short_sleeved_check_shirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ȿ��ǽ�', 'link', 'F', '/resources/img/look/short_sleeved_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ȼ���', 'link', 'M', '/resources/img/look/short_sleeved_shirts_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ȼ���', 'link', 'F', '/resources/img/look/short_sleeved_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '�ݹ���', 'link', 'M', '/resources/img/look/shorts_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '�ݹ���', 'link', 'F', '/resources/img/look/shorts_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '������', 'link', 'N', '/resources/img/look/slacks.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '�μҸ�', 'link', 'N', '/resources/img/look/sleeveless.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '�μҸſ��ǽ�', 'link', 'F', '/resources/img/look/sleeveless_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '����', 'link', 'M', '/resources/img/look/sleeveless_shirt_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '����', 'link', 'F', '/resources/img/look/sleeveless_shirt_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������', 'link', 'N', '/resources/img/look/sweater.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '�״Ͻ�ġ��', 'link', 'F', '/resources/img/look/tennis_skirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '���������', 'link', 'N', '/resources/img/look/thin_cardigan.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������Ʈ', 'link', 'N', '/resources/img/look/thin_knit.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '�⺻����', 'link', 'N', '/resources/img/look/thin_long_sleeved_shirt.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, 'Ʈ��ġ��Ʈ', 'link', 'N', '/resources/img/look/trench_coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, 'Ʈ��Ŀ����', 'link', 'N', '/resources/img/look/trucker_jacket.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�����е�', 'link', 'N', '/resources/img/look/vest_padding.png');

commit;