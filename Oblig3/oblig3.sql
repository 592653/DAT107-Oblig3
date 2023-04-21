DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    
CREATE TABLE Ansatt
(
	ansattId SERIAL,
	brukernavn VARCHAR(4) UNIQUE,
	fornavn VARCHAR(20),
	etternavn VARCHAR(20),
	ansdato DATE,
	stilling VARCHAR(30),
	mndlonn NUMERIC(10, 2),
	avdelingId INTEGER NOT NULL,
	ProsjektId INTEGER,
	
	CONSTRAINT Ansatt_PK PRIMARY KEY (ansattId)
);

CREATE TABLE Avdeling 
(
	avdelingId SERIAL,
	navn VARCHAR(40),
	
	CONSTRAINT Avdeling_PK PRIMARY KEY (avdelingId)
);
	
CREATE TABLE Prosjekt
(
	prosjektId SERIAL,
	navn VARCHAR(40),
	beskrivelse VARCHAR(60),
	
CONSTRAINT ProsjektId_PK PRIMARY KEY (prosjektId)
);
	
CREATE TABLE ProsjektDeltaker
(
  prosjektDelId SERIAL,
  ansattId      INTEGER REFERENCES Ansatt(ansattId) ,
  prosjektid    INTEGER REFERENCES Prosjekt(prosjektId),
  rolle         VARCHAR(30),
  timer         INTEGER,

  CONSTRAINT ProsjektDelId_PK PRIMARY KEY (prosjektDelId)
);

ALTER TABLE Ansatt
ADD COLUMN sjef INTEGER REFERENCES Avdeling(avdelingId);

ALTER TABLE Avdeling
ADD COLUMN sjef INTEGER REFERENCES Ansatt(ansattId);

INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansdato, stilling, mndlonn, avdelingId)
VALUES
    ('Luan', 'Luna', 'Andersen', '2021-09-15', 'Dataingenior', 30000, 1),
    ('Lyma','Lydia','Markhus','2022-11-12', 'Assistent', 25000, 2),
    ('Leki', 'Leo', 'Kilen', '2023-02-01', 'Leder', 40000, 3),
    ('Tofa', 'Tore', 'Falsen', '2021-01-01', 'Recruiter', 20000, 3),
    ('inpa', 'Inger Lise', 'Paulsen', '2000-08-05', 'Prosjektleder', 50000, 2),
    ('Haho', 'Hannah', 'Hofseth', '2021-03-01', 'HR', 20000, 1),
    ('Boma', 'Bodil', 'Markhus', '2013-05-01', 'Sivilingenior', 70000, 1),
    ('AnSy', 'Anila', 'Syvertsen', '2005-06-01', 'IT-konsulent', 10000, 2),
    ('Doje','Dorthe', 'Jensen', '2018-02-08', 'Resepsjonist', 25000, 3),
    ('Libo', 'Lise', 'Bolle', '2020-03-11', 'Designer', 40000, 3);

INSERT INTO 
	avdeling(navn, sjef)
VALUES
	('IT-avdeling', 1),
	('Markedsforing-avdeling', 2),
	('HR-avdeling', 3);

INSERT INTO 
	prosjekt(navn, beskrivelse)
VALUES
	('Project X', 'Veldig hemmelig'),
	('Database JPA', 'Veldig kjekt'),
	('Katt', 'Koselig');

INSERT INTO ProsjektDeltaker(ansattId, prosjektId, rolle, timer)
VALUES
    (1,1, 'Skriver java', 20),
    (2,1, 'Prokrastinere', 7),
    (3,1, 'Kundeservice', 32),
    (1,2, 'Skriver sql', 15),
    (2,2, 'Noterer', 3),
    (3,2, 'Lager papirfly', 4);









