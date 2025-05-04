/*
1.Estrarre i nomi e cognomi dei docenti e relativo 
indirizzo lavorativo
*/

SELECT Docenti.Nome, Cognome, Ruolo
FROM Docenti INNER JOIN Dipartimenti ON Docenti.CodiceDipartimento=Dipartimenti.CodiceDipartimento;



/*
2.Estrarre i cognomi docenti affiliati con il 
dipartimento di ingegneria dell’informazione
*/

SELECT Cognome
FROM Docenti
WHERE CodiceDipartimento IN (SELECT CodiceDipartimento
				FROM Dipartimenti
				WHERE Nome='Ingegneria Dell\'informazione');



/*
3.Estrarre il numero totale di ore di didattica svolte 
dai docenti di ogni dipartimento
*/

SELECT Dipartimenti.Nome, SUM(OreLezioneAnnue)
FROM Docenti INNER JOIN Dipartimenti ON Docenti.CodiceDipartimento=Dipartimenti.CodiceDipartimento
GROUP BY Dipartimenti.Nome;



/*
4. Trovare il nome del dipartimento con meno 
pubblicazioni annue
*/

SELECT Dipartimenti.Nome
FROM Dipartimenti INNER JOIN Docenti ON Dipartimenti.CodiceDipartimento=Docenti.CodiceDipartimento
GROUP BY Dipartimenti.Nome
HAVING SUM(PubblicazioniAnnue) <= ALL(SELECT SUM(PubblicazioniAnnue)
					FROM Docenti
					GROUP BY CodiceDipartimento);