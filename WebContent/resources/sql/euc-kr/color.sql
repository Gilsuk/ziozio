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
VALUES ('빨강', 0, 1, 1, 0);
-----------------------------------

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('검정', 0, 0, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('카키', 71, 24, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('주황', 50, 100, 180, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('노랑', 65, 200, 380, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('연두', 75, 300, 300, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('초록', 74, 300, 140, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('하늘', 190, 200, 180, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('파랑', 246, 200, 180, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('남색', 255, 19, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('보라', 259, 200, 200, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('핑크', 265, 200, 200, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('연갈색', 60, 100, 178, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('회색', 255, 0, 200, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('민트', 178, 200, 180, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('베이지', 60, 37, 281, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('와인', 297, 23, 85, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('갈색', 1, 27, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('고동', 1, 9, 100, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('코토베이지', 407, 7, 200, 0);

INSERT INTO color (color_name, color_hue_rotate, color_saturate, color_brightness, color_invert)
VALUES ('아이보리', 0, 1, 1, 0);

commit;