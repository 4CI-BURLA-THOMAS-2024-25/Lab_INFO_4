/*
1. Indicare il Nome e Cognome dei docenti che
hanno uno stipendio annuo maggiore di 50000EU
*/

SELECT nome, cognome
FROM Docenti
WHERE stipendioAnnuo > 50000;



/*
2. Indicare il Nome e Cognome dei Ricercatori che
hanno uno stipendio maggiore di 50000 EU
*/

SELECT nome, cognome
FROM Docenti
WHERE ruolo = 'Ricercatore' AND stipendioAnnuo > 50000;



/*
3. Indicare Il Nome, Cognome e Ruolo dei docenti
che hanno uno stipendio compreso tra 30000 EU
e 50000 EU
*/

SELECT nome, cognome, ruolo
FROM Docenti
WHERE stipendioAnnuo BETWEEN 30000 AND 50000;

/*
4. Indicare il Nome, Cognome e Mansione dei
docenti che non hanno fornito dati riguardo al
numero annuale di pubblicazioni
*/

SELECT nome, cognome, ruolo
FROM Docenti
WHERE pubblicazioniAnnue IS NULL;