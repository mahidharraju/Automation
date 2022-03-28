CREATE TABLE IF NOT EXISTS employee_location
(
    ggid bigint NOT NULL,
    location VARCHAR(255),
    Base_Location VARCHAR(255),
    Location_Standardization VARCHAR(255),
    Created_Date date,
    Created_By character varying ,
    Last_Modified_Date date,
    CONSTRAINT PK_Emp_location_ID PRIMARY KEY (ggid)
);