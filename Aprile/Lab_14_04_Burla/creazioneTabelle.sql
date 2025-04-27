CREATE DATABASE libreria;

CREATE TABLE CaseEditrici(
	codiceCE char(5) PRIMARY KEY,
	nome varchar(30) NOT NULL,
	city varchar(15) NOT NULL,
	stato varchar(15) NOT NULL
);

CREATE TABLE Libri(
	isbn bigint(13) PRIMARY KEY,
	titolo varchar(30) NOT NULL,
	prezzo decimal(4,2) NOT NULL,
	numeroPagine integer,
	editore char(5) NOT NULL,
	FOREIGN KEY (editore) REFERENCES CaseEditrici(codiceCE)
);

CREATE TABLE Autori(
	codiceAutore char(5) PRIMARY KEY,
	nome varchar(30) NOT NULL,
	cognome varchar(30) NOT NULL,
	nascita date NOT NULL,
	nazionalita char(2) NOT NULL
);

CREATE TABLE LibriAutori(
	autore char(5),
	libro bigint(13),
	PRIMARY KEY(autore, libro),
	FOREIGN KEY (autore) REFERENCES Autori(codiceAutore),
	FOREIGN KEY (libro) REFERENCES Libri(isbn)
);