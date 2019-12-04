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

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���콺', 'link', 'F', '/resources/img/look/blouse.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '��������', 'link', 'N', '/resources/img/look/thin_long_sleeved_shirt.png');------------------

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, 'üũ ����', 'link', 'N', '/resources/img/look/check_shirt.png' ); --------------------�����̶� �ٸ���?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������ �μҸ�', 'link', 'M', '/resources/img/look/sleeveless_shirt_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������ �μҸ�', 'link', 'F', '/resources/img/look/sleeveless_shirt_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������', 'link', 'N', '/resources/img/look/sweater.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '�ĵ�', 'link', 'N', '/resources/img/look/hoodie.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������ ����', 'link', 'M', '/resources/img/look/innerwear_top_man.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������ ����', 'link', 'F', '/resources/img/look/innerwear_top_woman.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '����?', 'link', 'M', '/resources/img/look/long_sleeved_shirt_man.png');--������ ���ǿ� �ٸ���?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������', 'link', 'N', '/resources/img/look/mantoman.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '��Ʋ��', 'link', 'N', '/resources/img/look/neck_shirt.png');-------------------------------�� ��Ʋ��..?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '������ ����', 'link', 'N', '/resources/img/look/shirts_thin.png'); -------------------------������� �ٸ���?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, 'üũ����', 'link', 'M', '/resources/img/look/short_sleeved_check.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ڿ����', 'link', 'M', '/resources/img/look/short_sleeved_shirts_man.png'); --������ ������ �ٸ���?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ڿ����', 'link', 'F', '/resources/img/look/short_sleeved_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '�μҸſ��ǽ�', 'link', 'F', '/resources/img/look/sleeveless_dress.png'); ----------���ǽ��� �з��� ���?

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ȿ��ǽ�', 'link', 'M', '/resources/img/look/short_sleeved_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (1, '���ȿ��ǽ�', 'link', 'F', '/resources/img/look/long_sleeved_dress.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '������ݹ���', 'link', 'M', '/resources/img/look/shorts_man.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '������ݹ���', 'link', 'F', '/resources/img/look/shorts_woman.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '������ ����', 'link', 'F', '/resources/img/look/innerwear_under_woman.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '������ ����', 'link', 'M', '/resources/img/look/innerwear_under_man.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, 'û����', 'link', 'N', '/resources/img/look/jeans.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '�����', 'link', 'N', '/resources/img/look/cotton_trousers.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (2, '��ġ��', 'link', 'F', '/resources/img/look/long_skirt.png');---------------------ġ�� �Ѱ� �ۿ� ���..�Ф�

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '���� �����', 'link', 'N', '/resources/img/look/thin_cardigan.png');--�׷� ���� ������� �β��� ��������� �ٲ���ϳ�(����)

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�����', 'link', 'N', '/resources/img/look/cardigan.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '��Ʈ', 'link', 'N', '/resources/img/look/coat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '������Ʈ', 'link', 'F', '/resources/img/look/dufflecoat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, 'Ʈ��ġ��Ʈ', 'link', 'N', '/resources/img/look/trenchcoat.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '����Ʈ', 'link', 'N', '/resources/img/look/fur_coat.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '��Ŷ', 'link', 'N', '/resources/img/look/jackaet.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '������Ŷ', 'link', 'M', '/resources/img/look/huntingjacket.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '���̴���Ŷ', 'link', 'N', '/resources/img/look/leather_jacket.png'); 

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '�����е�', 'link', 'N', '/resources/img/look/vest_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '���е�', 'link', 'N', '/resources/img/look/short_padding.png');

INSERT INTO CLOTH (cloth_category_code, cloth_name, cloth_link_url, cloth_gender, cloth_img)
VALUES (3, '���е�', 'https://store.musinsa.com/app/product/detail/1094521/0', 'N', '/resources/img/look/long_padding.png' );


commit;
