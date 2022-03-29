CREATE TABLE IF NOT EXISTS ngt_employee_data
(
    ggid bigint NOT NULL,
    Shadow_Start_Date DATE,
    Shadow_End_Date DATE,
    Shadow_Account VARCHAR(255),
    Shadow_BU VARCHAR(255),
    FLP_Skills VARCHAR(255),
    NGT_Status VARCHAR(255),
    Billable_Start_Date DATE,
    Duration_Days INT,
    Duration_Weeks INT,
    Contact_Number VARCHAR(255),
    Billable_ReqID VARCHAR(255),
    Created_Date date,
    Created_By character varying ,
    Last_Modified_Date date,
    CONSTRAINT PK_NGTEmployeeData_ID PRIMARY KEY (ggid)
);