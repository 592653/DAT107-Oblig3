--Lim dette inn i sql databsen og kjør det der for 
--å opprette tabellen ansatt
--Skal lage de andre tabellene etter hvert

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    
CREATE TABLE ansatt
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
    ('Leki', 'Leo', 'Kilen', '2023-02-01', 'Leder', 40000);

SELECT * FROM ansatt;











