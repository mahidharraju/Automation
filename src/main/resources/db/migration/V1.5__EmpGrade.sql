CREATE TABLE IF NOT EXISTS employee_grade
(
    ggid bigint NOT NULL,
    designation VARCHAR(255),
    Current_Global_Grade VARCHAR(255),
    Current_Local_Grade VARCHAR(255),
    New_Global_Grade VARCHAR(255),
    New_Local_Grade VARCHAR(255),
    Is_Promoted boolean DEFAULT false,
    Created_Date date,
    Created_By character varying ,
    Last_Modified_Date date,
    CONSTRAINT PK_Emp_grade_ID PRIMARY KEY (ggid)
);