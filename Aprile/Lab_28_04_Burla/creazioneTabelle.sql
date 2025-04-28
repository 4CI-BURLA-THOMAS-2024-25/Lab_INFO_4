CREATE DATABASE GestionalePersonale

CREATE TABLE Dipartimenti(
	codiceDipartimento char(4) PRIMARY KEY,
	nome varchar(50) NOT NULL,
	indirizzo varchar(50) NOT NULL,
	city varchar(30) NOT NULL,
	numeroDipendenti integer NOT NULL,
	costiTotaliAnnui decimal(20,2) NOT NULL,
	finanziamentoTotaleAnnuo decimal(20,2) NOT NULL
);

CREATE TABLE Docenti(
	matricola char(6) PRIMARY KEY,
	nome varchar(50) NOT NULL,
	cognome varchar(50) NOT NULL,
	ruolo varchar(20) NOT NULL,
	dataAssunzione date NOT NULL,
	codiceDipartimento char(4) NOT NULL,
	oreLezioneAnnue integer NOT NULL,
	pubblicazioniAnnue integer,
	stipendioAnnuo decimal(20,2) NOT NULL,
	FOREIGN KEY (codiceDipartimento) REFERENCES Dipartimenti(codiceDipartimento)
);