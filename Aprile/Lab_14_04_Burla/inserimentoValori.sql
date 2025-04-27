INSERT INTO CaseEditrici (codiceCE, nome, city, stato)
VALUES ('T0001', 'Tea', 'Milano', 'Italia'), ('M0002', 'Mondadori', 'Milano', 'Italia'), ('F0003', 'Feltrinelli', 'Milano', 'Italia'), ('E0004', 'Einaudi', 'Torino', 'Italia');

INSERT INTO Libri (isbn, titolo, prezzo, numeroPagine, editore)
VALUES (9788831018913, 'Le parole fanno il solletico', 14.15, 168, 'T0001'), (978880479396, 'Fuga dalla meraviglia', 16.50, 176, 'M0002'), (9788847732766, 'Falcone e Borsellino', 8.46, 80, 'E0004');

INSERT INTO Autori (codiceAutore, nome, cognome, nascita, nazionalita)
VALUES ('DNPC1', 'Daniel', 'Pennac', '1944-12-01', 'FR'), ('FDTD2', 'Federico', 'Taddia', '1972-02-07', 'IT'), ('FRAD3', 'Francesco', 'Adamo', '1949-02-02', 'IT');

INSERT INTO LibriAutori (autore, libro)
VALUES ('DNPC1', 9788831018913), ('FDTD2', 978880479396), ('FRAD3', 9788847732766);