CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS employee
(
    --id UUID default uuid_generate_v4(),
    GGID bigint NOT NULL,
    LI_LR_ID character varying ,
    Region character varying ,
    First_Name character varying ,
    Middle_Name character varying ,
    Last_Name character varying ,
    NT_Login_ID character varying ,
    Global_Date_of_Joining date,
    Local_Date_of_Joining date,
    Supervisor_Email_ID character varying ,
    Supervisor_Full_Name character varying ,
    Email_ID character varying ,
    ACTIVE boolean DEFAULT true,
    Created_Date date,
    Created_By character varying ,
    Last_Modified_By character varying ,
    Last_Modified_Date date,
    CONSTRAINT PK_Employee_GGID PRIMARY KEY (GGID)
);

