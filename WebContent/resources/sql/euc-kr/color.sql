CREATE TABLE color (
	color_code NUMBER primary key,
	color_name VARCHAR2(16) NOT NULL,
	color_hue_rotate NUMBER NOT NULL,
	color_saturate NUMBER NOT NULL,
	color_brightness NUMBER NOT NULL,
	color_invert NUMBER NOT NULL
);

CREATE SEQUENCE color_seq;

CREATE OR REPLACE TRIGGER color_on_insert_trg
  BEFORE INSERT ON color
  FOR EACH ROW
BEGIN
  :new.color_code := color_seq.nextval;
END;
/

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('����', 0, 1, 1, 0);
-----------------------------------

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('��', 0, 0, 100, 100);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('����', 0, 0, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('īŰ', 71, 24, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('��Ȳ', 50, 100, 180, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('���', 65, 200, 380, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('����', 75, 300, 300, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('�ʷ�', 74, 300, 140, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('�ϴ�', 190, 200, 180, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('�Ķ�', 246, 200, 180, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('����', 255, 19, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('����', 259, 200, 200, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('��ũ', 265, 200, 200, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('������', 60, 100, 178, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('ȸ��', 255, 0, 200, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('��Ʈ', 178, 200, 180, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('������', 60, 37, 281, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('����', 297, 23, 85, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('����', 1, 27, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('��', 1, 9, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('���丮������', 407, 7, 200, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('���̺���', 0, 1, 1, 0);

commit;