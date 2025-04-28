/*
1. Trovare tutti i docenti assunti nel 1999
*/

SELECT *
FROM Docenti
WHERE DataAssunzione BETWEEN '2000-01-01' AND '2010-12-31';


/*
2. Trovare l’anno di assunzione di tutti i professori.
Ordinare il risultato in modo decrescente
*/

SELECT 
FROM Docenti
WHERE ruolo LIKE 'Professore%';