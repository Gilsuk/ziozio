DROP TABLE account_like CASCADE CONSTRAINT;
DROP TABLE account_library CASCADE CONSTRAINT;
DROP TABLE account_style CASCADE CONSTRAINT;
DROP TABLE cloth_temperature_grade CASCADE CONSTRAINT;
DROP TABLE cloth_weather CASCADE CONSTRAINT;
DROP TABLE cloth_style CASCADE CONSTRAINT;
DROP TABLE cloth_set CASCADE CONSTRAINT;
DROP TRIGGER color_on_insert_trg;
DROP SEQUENCE color_seq;
DROP TABLE color CASCADE CONSTRAINT;
DROP TRIGGER cloth_on_insert_trg;
DROP SEQUENCE cloth_seq;
DROP TABLE cloth CASCADE CONSTRAINT;
DROP TABLE style CASCADE CONSTRAINT;
DROP TABLE cloth_category CASCADE CONSTRAINT;
DROP TRIGGER weather_info_on_insert_trg;
DROP TABLE weather_info CASCADE CONSTRAINT;
DROP TABLE temperature_grade CASCADE CONSTRAINT;
DROP TABLE weather CASCADE CONSTRAINT;
DROP TABLE location CASCADE CONSTRAINT;
DROP TABLE cookie CASCADE CONSTRAINT;
DROP TRIGGER account_on_insert_trg;
DROP SEQUENCE account_seq;
DROP TABLE ACCOUNT CASCADE CONSTRAINT;
DROP TABLE account_grade CASCADE CONSTRAINT;
DROP TABLE verification CASCADE CONSTRAINT;