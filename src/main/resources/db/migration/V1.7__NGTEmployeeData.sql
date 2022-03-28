CREATE TABLE IF NOT EXISTS ngt_employee_data
(
    ggid bigint NOT NULL,
    Shadow_Start_Date DATE,
    Shadow_End_Date DATE,
    Shadow_Account VARCHAR(255),
    FLP_Skills VARCHAR(255),
    NGT_Status VARCHAR(255),
    Created_Date date,
    Created_By character varying ,
    Last_Modified_Date date,
    CONSTRAINT PK_NGTEmployeeData_ID PRIMARY KEY (ggid)
);