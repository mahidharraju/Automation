
CREATE TABLE IF NOT EXISTS Sub_Practice
(
    id UUID default uuid_generate_v4(),
    Name character varying,
    CONSTRAINT PK_Sub_Practice_ID PRIMARY KEY (ID)
);

INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'CLD-OS');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'CLD-MS');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'CLD-CPES');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'CLD-AGIEM');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'CLD-INT');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'NGT-TRN');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'CLD-CT');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'CLD-Azure');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'NGT-CT');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'CLD-AWS');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'NGT-P');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'CLD-GCP');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'NGT-ERP');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'NGT-DGTL');
INSERT INTO Sub_Practice(ID, Name)	VALUES (uuid_generate_v4(), 'GP-NGT-P');

