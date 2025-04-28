INSERT INTO Dipartimenti (
    CodiceDipartimento,
    Nome,
    Indirizzo,
    city,
    NumeroDipendenti,
    CostiTotaliAnnui,
    FinanziamentoTotaleAnnuo) 
VALUES
('0001', 'Ingegneria Dell\'informazione', 'Via Caruso 2', 'Pisa', 10, 350000, 450000),
('0002', 'Ingegneria Civile', 'Via Diotisalvi 2', 'Pisa', 5, 250000, 250000),
('0003', 'Matematica', 'Largo Pontecorvo 5', 'Pisa', 6, 300000, 280000),
('0004', 'Letteratura e filologia', 'Piazza Evangelista Torricelli, 2', 'Pisa', 4, 220000, 230000),
('0005', 'Infermieristica', 'Viale Rinaldo Piaggio, 2', 'Pontedera', 6, 300000, 290000),
('0006', 'Medicina', 'Via Savi,10', 'Pisa', 6, 340000, 350000);

INSERT INTO Docenti (
    Matricola,
    Nome,
    Cognome,
    Ruolo,
    DataAssunzione,
    CodiceDipartimento,
    OreLezioneAnnue,
    PubblicazioniAnnue,
    StipendioAnnuo) 
VALUES
('000485', 'Chandler', 'Bing', 'Ricercatore', '1999-01-01', '0004', 80, NULL, 50000),
('001245', 'Vittorio', 'Verdi', 'Professore Associato', '2009-10-04', '0002', 90, 4, 53000),
('002473', 'Francesco', 'Rossi', 'Professore Ordinario', '2004-12-10', '0002', 110, 5, 55000),
('004178', 'Mario', 'Rossi', 'Professore Associato', '2010-05-16', '0001', 115, 15, 50000),
('004580', 'Francesco', 'Verdi', 'Professore Ordinario', '2005-01-30', '0001', 150, 20, 60000),
('004595', 'Dexter', 'Morgan', 'Professore Ordinario', '2004-06-10', '0001', 110, 14, 51000),
('005698', 'Carlo', 'Vallati', 'Ricercatore', '2016-01-04', '0001', 60, 10, 40000),
('007896', 'Tyrion', 'Lannister', 'Ricercatore', '2015-06-30', '0001', 70, 17, 45000),
('010102', 'Joey', 'Tribbiani', 'Professore Ordinario', '1999-01-02', '0005', 150, 10, 65000),
('010244', 'Jack', 'Bauer', 'Ricercatore', '2001-06-09', '0006', 75, NULL, 55000),
('010277', 'Jon', 'Snow', 'Professore Ordinario', '1995-02-05', '0006', 140, 15, 69000),
('014500', 'Francis', 'Underwood', 'Ricercatore', '2014-06-25', '0003', 100, 0, 45000),
('020150', 'Robin', 'Scherbatsky', 'Ricercatore', '2013-12-10', '0003', 110, 1, 47000),
('030012', 'Howard', 'Wolowitz', 'Professore Associato', '2001-12-30', '0004', 110, 3, 60000),
('030405', 'Ted', 'Mosby', 'Professore Associato', '2002-05-06', '0005', 120, 9, 55000),
('040512', 'Derek', 'Shepherd', 'Ricercatore', '2003-05-06', '0005', 40, 5, 39000),
('090104', 'Isobel', 'Stevens', 'Professore Associato', '1998-02-07', '0006', 125, 11, 45000);
