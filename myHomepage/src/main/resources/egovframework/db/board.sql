CREATE TABLE BOARD(IDX NUMERIC(20) PRIMARY KEY auto_increment, TITLE VARCHAR(200), CONTENT VARCHAR(2000), USE_YN CHAR(1), VIEW_CNT NUMERIC(20), ATCH_FILE_ID VARCHAR(255), REGDATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, USERNAME VARCHAR(20))