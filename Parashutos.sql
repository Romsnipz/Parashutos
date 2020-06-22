CREATE TABLE User_reg (
    User_id NUMBER NOT NULL,
    User_Email VARCHAR2(50) NOT NULL,
    User_Password VARCHAR2(50) NOT NULL,
    User_Nickname VARCHAR2(50) NOT NULL,
    
    CONSTRAINT pk_user PRIMARY KEY (User_id),
    CONSTRAINT uk1_mail UNIQUE (User_Email),
    CONSTRAINT uk2_nick UNIQUE (User_Nickname)
);

CREATE SEQUENCE "HIBERNATE_SEQUENCE" MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 3 CACHE 20 NOORDER NOCYCLE ;

CREATE OR REPLACE TRIGGER User_reg
AFTER INSERT ON User_reg
FOR EACH ROW
BEGIN
    insert into Information(User_Nickname) 
        values(:new.User_Nickname);
END;

CREATE TABLE Information (
    User_Nickname VARCHAR2(50) NOT NULL,
    SurName VARCHAR2(50) NULL,
    FirstName VARCHAR2(50) NULL,
    SecondName VARCHAR2(50) NULL,
    Birthday DATE NULL,
    City VARCHAR2(50) NULL,
    Dropzone VARCHAR2(50) NULL,
	Quantity VARCHAR2(10) NULL,
    
    CONSTRAINT pk_info PRIMARY KEY (User_Nickname),
    CONSTRAINT fk_info FOREIGN KEY (User_Nickname)
        REFERENCES User_reg (User_Nickname)
);