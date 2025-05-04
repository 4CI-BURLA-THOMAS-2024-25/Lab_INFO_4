/*
1.Estrarre i nomi e cognomi dei docenti il cui 
dipartimento NON ha sede a Pisa
*/

SELECT Nome, Cognome
FROM Docenti
WHERE CodiceDipartimento (SELECT CodiceDipartimento
	FROM Dipartimenti
WHERE Sede<>'Pisa');