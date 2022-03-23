
CREATE TABLE IF NOT EXISTS Practice
(
    id UUID default uuid_generate_v4(),
    Name character varying,
    CONSTRAINT PK_Practice_ID PRIMARY KEY (id)
);

INSERT INTO Practice(ID, Name)	VALUES (uuid_generate_v4(), 'GP-CLOUD');
INSERT INTO Practice(ID, Name)	VALUES (uuid_generate_v4(), 'GP-NGT');