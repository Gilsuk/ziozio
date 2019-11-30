DROP TRIGGER color_on_insert_trg;
DROP SEQUENCE color_seq;
DROP TABLE color;

CREATE TABLE color (
	color_code NUMBER primary key,
	color_name VARCHAR2(16) NOT NULL,
	color_hue_rotate NUMBER NOT NULL,
	color_saturate NUMBER NOT NULL,
	color_brightness NUMBER NOT NULL,
    
    CONSTRAINT color_hue_rotate_ck
	CHECK (color_hue_ratate BETWEEN 0 AND 450),

    CONSTRAINT color_saturate_ck
	CHECK (color_saturate BETWEEN 0 AND 1)
    
);
CREATE SEQUENCE cloth_seq;

-- 아래 트리거 생성 코드는 이클립스에서 실행 안됨
-- SQL Developer로 실행 할 것
CREATE OR REPLACE TRIGGER color_on_insert_trg
  BEFORE INSERT ON color
  FOR EACH ROW
BEGIN
  :new.color_code := color_seq.nextval;
END;
/

INSERT INTO color VALUES ('빨강', 0, 1, 1);

commit;