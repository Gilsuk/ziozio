
DROP TABLE account;
CREATE TABLE account (
    useremail VARCHAR2(100),
    userpw VARCHAR2(100),
    username VARCHAR2(100),
    usernick VARCHAR2(100),
    userbirth_year VARCHAR2(100),
    userbirth_mon VARCHAR2(100),
    userbirth_day VARCHAR2(100),
    userphone VARCHAR2(100),
    usergender VARCHAR2(100)
    
);
DROP SEQUENCE account_seq;
CREATE SEQUENCE account_seq;