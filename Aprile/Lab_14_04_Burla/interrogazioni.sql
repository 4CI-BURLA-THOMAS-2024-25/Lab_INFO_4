SELECT titolo, prezzo
FROM Libri
WHERE prezzo < 15.00;

SELECT titolo, numeroPagine
FROM Libri
WHERE numeroPagine < 150;

SELECT titolo, nome
FROM LibriAutori 
INNER JOIN Libri ON LibriAutori.libro = Libri.isbn
INNER JOIN Autori ON LibriAutori.autore = Autori.codiceAutore
WHERE autori.nome = 'Valerie' AND autori.cognome = 'Perrin';

SELECT *
FROM Libri
INNER JOIN CaseEditrici ON Libri.editore = CaseEditrici.codiceCE
WHERE CaseEditrici.nome = 'Mondadori';

SELECT Libri.titolo, Autori.nome, Autori.cognome, Autori.nascita, CaseEditrici.nome
FROM LibriAutori
INNER JOIN Autori ON Autori.codiceAutore = LibriAutori.autore
INNER JOIN Libri ON Libri.isbn = LibriAutori.libro
INNER JOIN CaseEditrici ON Libri.editore = CaseEditrici.codiceCE
WHERE Autori.nascita < '2000-01-01';