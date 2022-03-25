CREATE TABLE IF NOT EXISTS Account
(
    id uuid NOT NULL,
    ultimate_account_name VARCHAR(255),
    account_name VARCHAR(255),
    CONSTRAINT PK_Account_ID PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Project
(
    id uuid NOT NULL,
    project_pu_name VARCHAR(255),
    project_name VARCHAR(255),
    project_number bigint,
    CONSTRAINT PK_Project_ID PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Employee_project
(
    ggid bigint NOT NULL,
    project_id uuid,
    account_id uuid,
    project_start_date date,
    project_roll_off_date date,
    CONSTRAINT PK_Emp_prj_ID PRIMARY KEY (ggid)
);