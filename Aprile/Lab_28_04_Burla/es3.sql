/*
1.Contare il numero totale dei docenti
dell’università
*/

SELECT COUNT(*)
FROM Docenti;



/*
2.Ricavare lo stipendio massimo tra i docenti
rinominando il campo trovato in
StipendioMassimo
*/

SELECT MAX(StipendioAnnuo) AS StipendioMassimo
FROM Docenti;



/*
3.Ricavare il numero di docenti per dipartimento ,
mostrare numero docenti e codice dipartimento
(usare GROUP BY)
*/

SELECT CodiceDipartimento, COUNT(*)
FROM Docenti
GROUP BY CodiceDipartimento;



/*
4.Ricavare l’elenco dei codici dei dipartimenti i cui
docenti pubblicano un numero totale di
pubblicazioni maggiore di dieci
*/

SELECT CodiceDipartimento, SUM(PubblicazioniAnnue)
FROM Docenti
GROUP BY CodiceDipartimento
HAVING SUM(PubblicazioniAnnue) > 10;
