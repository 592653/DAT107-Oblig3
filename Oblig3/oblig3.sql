<!--Lim dette inn i sql databsen og kjør det der 
for å opprette tabellen ansatt -->


DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    
CREATE TABLE Ansatt
(
	ansattid SERIAL UNIQUE PRIMARY KEY,
	brukernavn VARCHAR(4) UNIQUE,
	fornavn VARCHAR(15),
	etternavn VARCHAR(15),
	ansdato DATE,
	stilling VARCHAR(15),
	mndlonn INT
 
);
INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansdato, stilling, mndlonn)
VALUES
    ('Luan', 'Luna', 'Andersen', '2021-09-15', 'Dataingenior', 30000),
    ('Lyma','Lydia','Markhus','2022-11-12', 'Assistent', 25000),
    ('Leki', 'Leo', 'Kilen', '2023-02-01', 'Leder', 40000),
    ('Tofa', 'Tore', 'Falsen', '2021-01-01', 'Recruiter', 20000),
    ('inpa', 'Inger Lise', 'Paulsen', '2000-08-05', 'Prosjektleder', 50000),
    ('Haho', 'Hannah', 'Hofseth', '2021-03-01', 'HR', 20000),
    ('Boma', 'Bodil', 'Markhus', '2013-05-01', 'Sivilingenior', 70000),
    ('AnSy', 'Anila', 'Syvertsen', '2005-06-01', 'IT-konsulent', 10000),
    ('Doje','Dorthe', 'Jensen', '2018-02-08', 'Resepsjonist', 25000),
    ('Libo', 'Lise', 'Bolle', '2020-03-11', 'Designer', 40000);


CREATE TABLE Avdeling 
(
	avdelingid SERIAL UNIQUE PRIMARY KEY,
	navn VARCHAR(10),
	sjef VARCHAR(20)
	
	CONSTRAINT Ansatt_FK FOREIGN KEY (Sjef) REFERENCES Ansatt(Id)
);

INSERT INTO 
	avdeling(navn, sjef)
VALUES
	('IT-avdeling', 1),
	('Markedsføring-avdeling', 2),
	('HR-avdeling', 3);
	
	
CREATE TABLE Prosjekt
(
	prosjektid SERIAL UNIQUE,
	navn VARCHAR(40),
	beskrivelse VARCHAR(60)
	
	CONSTRAINT Prosjektid_PK PRIMARY KEY (Prosjektid)
);
INSERT INTO 
	prosjekt(navn, beskrivelse)
VALUES
	('Project X', 'Veldig hemmelig'),
	('Database JPA', 'Veldig gøy'),
	('Katt', 'Koselig');
	

ALTER TABLE Avdeling
ADD FOREIGN KEY(Sjef) REFERENCES Ansatt(Id);
	
<!-- UPDATE sjefen til avdelingen -->














