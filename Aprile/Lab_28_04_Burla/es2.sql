/*
1. Indicare le città in cui hanno sede i dipartimenti
*/

SELECT DISTINCT city
FROM Dipartimenti;



/*
2. Indicare l’elenco dei possibili ruoli, rinominare il
campo con la dicitura RuoliPossibili
*/

SELECT DISTINCT ruolo as RuoliPossibili
FROM Docenti;



/*
3. Indicare l’elenco dei dipartimenti elencato per costo
totale annuo crescente
*/

SELECT *
FROM Dipartimenti
ORDER BY costiTotaliAnnui;



/*
4. Indicare l’elenco dei dipartimenti elencato per
finanziamento annuo decrescente
*/

SELECT *
FROM Dipartimenti
ORDER BY finanziamentoTotaleAnnuo DESC;



/*
5. Indicare i dipartimenti che abbiano nell’indirizzo una
via o un viale
*/

SELECT *
FROM Dipartimenti
WHERE indirizzo LIKE 'Via%' OR indirizzo LIKE 'Viale%';



/*
6. Indicare i dipartimenti il cui saldo totale è > 0.
Elencare i risultati per costo medio ( rispetto al
numero di dipendenti) crescente
*/

SELECT *, costiTotaliAnnui / numeroDipendenti AS costoMedio
FROM Dipartimenti
WHERE (finanziamentoTotaleAnnuo - costiTotaliAnnui) > 0
ORDER BY costoMedio;