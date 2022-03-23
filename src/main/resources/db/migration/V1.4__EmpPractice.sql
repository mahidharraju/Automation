CREATE TABLE IF NOT EXISTS Employee_Practice
(
    GGID bigint NOT NULL,
    Current_Practice_ID uuid,
    Current_Sub_Practice_ID uuid,
    New_Practice_ID uuid,
    New_Sub_Practice_ID uuid,
    Is_Practice_Changed boolean,
    Created_By character varying,
    Created_Date date,
    Modified_By character varying,
    Modified_Date date,
    CONSTRAINT PK_Employee_Practice_GGID PRIMARY KEY (GGID),
    CONSTRAINT Employee_Practice_ID_Currernt_Practice_ID FOREIGN KEY (Current_Practice_ID)
        REFERENCES Practice (ID) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT Employee_Practice_ID_Currernt_Sub_Practice_ID FOREIGN KEY (Current_Sub_Practice_ID)
        REFERENCES Sub_Practice (ID) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT Employee_Practice_ID_New_Practice_ID FOREIGN KEY (New_Practice_ID)
        REFERENCES Practice (ID) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT Employee_Practice_ID_New_Sub_Practice_ID FOREIGN KEY (New_Sub_Practice_ID)
        REFERENCES Sub_Practice (ID) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);