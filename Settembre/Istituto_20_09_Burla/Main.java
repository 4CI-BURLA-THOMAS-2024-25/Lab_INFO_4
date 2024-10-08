/**
 * classe Test, main
 * 
 * @author Thomas Burla
 * @version 2.0
 */
import java.util.*;
import javax.swing.JOptionPane;
import java.io.*;
public class Main{
    public static void main(String args[]){
        try{
            //variabile utilizzata dal menu di scelta iniziale
            int opzione;
            //variabili per la ricerca della scuola, tra quelle esistenti
            boolean scuolaTrovata;
            int c;
            Scuola scuolaCerca;
            //variabile per tornare al menu
            int menu = JOptionPane.YES_OPTION;
            //variabile utilizzata per il ciclo della visualizzazione delle info delle scuole
            int visualizzaScuole;
            //variabile utilizzata per il ciclo dell'aggiunta scuole
            int aggiungiScuole;
            //variabile utilizzata per il ciclo dell'aggiunta classi
            int aggiungiClassi;
            //variabile utilizzata per il ciclo dell'aggiunta del personale ata
            int aggiungiATA;
            //variabile utilizzata per il ciclo dell'aggiunta delle mansioni del personale ata
            int aggiungiMansioni;
            //variabile utilizzata per il ciclo dell'aggiunta degli studenti
            int aggiungiStudenti;
            //variabile utilizzata per il ciclo dell'aggiunta degli insegnanti
            int aggiungiInsegnanti;
            //variabile utilizzata per il ciclo dell'aggiunta dei voti ad unoi studente
            int aggiungiVoti;
            //varibili utilizzate per passare parametri agli oggetti di tipo Persone (e classi che ereditano i suoi attributi)
            String nome, cognome, email, codFiscale, numCell;
            //variabile che contiene stipendio all'ora del lavoratore scolastico
            double stipendio;
            //variabile per verificare che l'aggiunta della mansione sia andata a buon fine
            boolean mansioneOK;
            //variabile per verificare che l'aggiunta del personale ata alla scuola sia andata a buon fine
            boolean personaleATAOK;
            //piano su cui lavora la persona del personale ata
            int piano;
            //matricola dello studente da aggiungere alla classe
            int matricola;
            //variabili di un voto da aggiungere allo studente
            String materia;
            double valore;
            int giorno, mese,anno;
            String data[];
            //variabile utilizzata per il controllo della data
            boolean dataOK;
            //variabile per verificare che l'aggiunta del voto sia andata a buon fine
            boolean votoOK;
            //variabile per verificare che l'aggiunta dello studente alla classe sia andata a buon fine
            boolean studenteOK;
            //variabile per verificare che l'aggiunta della classe alla scuola sia andata a buon fine
            boolean classeOK;
            //disciplina insegnata dall'insegnante
            String corso;
            //lista degli insegnanti
            ArrayList <Insegnante> insegnanti = new ArrayList <Insegnante> ();
            //creo oggetto insegnate, che assegnero alla Classe dopo aver verificato che non sia già stato creato
            Insegnante insegnante;
            //variabili per verifica se un'insegnante è già stato inserito
            boolean esisteInsegnante;
            int ins;
            Insegnante insegnanteCerca;
            //variabile per verificare che l'aggiunta dell'insegnante alla classe sia andata a buon fine
            boolean insegnanteOK;
            //variabili scuola
            String codiceMeccanografico;
            String nomeScuola;
            //preparo file su cui salvo le info di ogni scuola
            File f = new File("scuole.txt");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter salvoScuola = new PrintWriter(fw);
            //nome del file da cui leggere le info sula scuola
            String pathLeggo;
            //separatore file csv di lettura
            String separatore;
            //variabile che interrompe la lettura da file nel caso in cui si siano problemi 
            boolean IOError;
            //riga successiva del file
            String leggoRiga[];
            //arraylist che contiene tutte le scuole da gestire
            ArrayList <Scuola> scuole = new ArrayList <Scuola> ();
            //chiedo all'utente di digitare un numero a seconda dell'opzione desiderata e ripeto la domanda se digitato un numero non valido
            do{
                //chiedo se l'utente vuole aggiungere scuole oppure visualizzare quelle già inserite
                opzione = Integer.parseInt(JOptionPane.showInputDialog(null, "BENVENUTO! Con questo programma potrai creare e gestire un elenco di scuole. Digita: \n1 per inserire una nuova scuola manualmente; \n2 per inserire una nuova scuola fornendo un file CSV correttamente formattato (vedi istruzioniCSV.csv); \n3 per visualizzare le informazioni di una scuola gia esistente;", "Opzione", JOptionPane.PLAIN_MESSAGE));
                //menu di scelta
                switch(opzione){
                    case 1:{
                        //ciclo per aggiungere scuole all'elenco finchè l'utente lo deisdera
                        do{
                            //chiedo il nome della scuola e lo controllo
                            do{
                                nomeScuola = JOptionPane.showInputDialog(null, "Inserire il nome della scuola", "Nome scuola", JOptionPane.QUESTION_MESSAGE);
                                //messaggio di errore
                                if((nomeScuola == null) || (nomeScuola.equalsIgnoreCase(" "))){
                                    JOptionPane.showMessageDialog(null, "ERRORE! Nome della scuola non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                }
                            }while((nomeScuola == null) || (nomeScuola.equalsIgnoreCase(" ")));
                            //chiedo il codice meccanografico della scuola e lo controllo
                            do{
                                codiceMeccanografico = JOptionPane.showInputDialog(null, "Inserire il codice meccanografico della scuola", "Inserisci codice meccanografico", JOptionPane.QUESTION_MESSAGE);
                                //messaggio di errore
                                if((codiceMeccanografico == null) || (codiceMeccanografico.equalsIgnoreCase(" "))){
                                    JOptionPane.showMessageDialog(null, "ERRORE! Codice meccanografico della scuola non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                }
                            }while((codiceMeccanografico == null) || (codiceMeccanografico.equalsIgnoreCase(" ")));
                            //creo oggetto scuola
                            Scuola scuola = new Scuola(null, null, codiceMeccanografico, nomeScuola);
                            //ciclo per aggiungere classi
                            do{
                                //chiedo nome della classe (numero + sezione)
                                nome = JOptionPane.showInputDialog(null, "Inserire il nome della classe, formato da un numero seguito dalla sezione, senza spazi", "Aggiungi nome", JOptionPane.QUESTION_MESSAGE);
                                Classe classe = new Classe(null, null, nome);
                                //ciclo per aggiungere studenti alla classe
                                do{
                                    //chiedo nome dello studente e lo controllo
                                    do{
                                        nome = JOptionPane.showInputDialog(null, "Inserire il nome dello studente da aggiungere alla classe", "Aggiungi nome", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((nome == null) || (nome.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Nome non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((nome == null) || (nome.equalsIgnoreCase(" ")));
                                    //chiedo cognome dello studente e lo controllo
                                    do{
                                        cognome = JOptionPane.showInputDialog(null, "Inserire il cognome dello studente", "Aggiungi cognome", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((cognome == null) || (cognome.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Cognome non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((cognome == null) || (cognome.equalsIgnoreCase(" ")));
                                    //chiedo email dello studente e la controllo
                                    do{
                                        email = JOptionPane.showInputDialog(null, "Inserire email dello studente", "Aggiungi email", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((email == null) || (email.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Email non valida", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((email == null) || (email.equalsIgnoreCase(" ")));
                                    //chiedo codice fiscale dello studente e lo "controllo"
                                    do{
                                        codFiscale = JOptionPane.showInputDialog(null, "Inserire il codice fiscale dello studente", "Aggiungi codice fiscale", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((codFiscale == null) || (codFiscale.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Codice fiscale non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((codFiscale == null) || (codFiscale.equalsIgnoreCase(" ")));
                                    //chiedo numero di cellulare dello studente e lo controllo
                                    do{
                                        numCell = JOptionPane.showInputDialog(null, "Inserire il numero di telefono dello studente", "Aggiungi numero di telefono", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((numCell == null) || (numCell.equalsIgnoreCase(" ")) || (numCell.equalsIgnoreCase("0000000000"))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Numero di telefono non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((numCell == null) || (numCell.equalsIgnoreCase(" ")) || (numCell.equalsIgnoreCase("0000000000")));
                                    //chiedo il numero di matricola dello studente e lo controllo
                                    do{
                                        matricola = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserire il numero di matricola dello studente", "Aggiungi numero di matricola", JOptionPane.QUESTION_MESSAGE));
                                        if(matricola <= 0){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Numero di matricola non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while(matricola <= 0);
                                    //creo studente e assegno i valori alle variabili d'istanza
                                    Studente studente = new Studente(nome, cognome, email, codFiscale, numCell, matricola, null);
                                    //ciclo per leggere i voti di uno studente
                                    do{
                                        //ciclo che richiede il voto finche l'utente desidera inserirne
                                        do{
                                            //ciclo che chiede la materia e la controlla
                                            do{
                                                materia = JOptionPane.showInputDialog(null, "Inserire la materia del voto che si vuole aggiungere allo studente", "Aggiungi materia", JOptionPane.QUESTION_MESSAGE);
                                                if((materia == null) || (materia.equalsIgnoreCase("")) || (materia.equalsIgnoreCase(" "))){
                                                    JOptionPane.showMessageDialog(null, "ERRORE! Voto gia presente", "Errore", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }while((materia == null) || (materia.equalsIgnoreCase("")) || (materia.equalsIgnoreCase(" ")));
                                            //ciclo che chiede il valore del voto e lo controlla
                                            do{
                                                valore = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserire il valore del voto, in decimi, compreso tra 1 e 10" , "Aggiungi valore del voto voto", JOptionPane.QUESTION_MESSAGE));
                                                //messaggio di errore
                                                if((valore < 1) || (valore > 10)){
                                                    JOptionPane.showMessageDialog(null, "ERRORE! Valore non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }while((valore < 1) || (valore > 10));
                                            //ciclo che chiede la data del voto e la controlla
                                            do{
                                                //chiedo giorno
                                                giorno = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserire il giorno in cui è stato registrato il voto", "Registra giorno", JOptionPane.QUESTION_MESSAGE));
                                                //chiedo mese
                                                mese = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserire il mese in cui è stato registrato il voto", "Registra mese", JOptionPane.QUESTION_MESSAGE));
                                                //chiedo anno
                                                anno = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserire l'anno in cui è stato registrato il voto", "Registra anno", JOptionPane.QUESTION_MESSAGE));
                                                //controllo data
                                                ControlloData controllodata = new ControlloData(giorno, mese, anno);
                                                dataOK = controllodata.controllaData();
                                                //messaggio di errore
                                                if(dataOK == false){
                                                    JOptionPane.showMessageDialog(null, "ERRORE! Data non valida", "Errore", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }while(dataOK == false);
                                            Voto voto = new Voto(materia, valore, giorno, mese, anno);
                                            votoOK = studente.addVoto(voto);
                                            //messaggio di errore
                                            if(votoOK == false){
                                                JOptionPane.showMessageDialog(null, "ERRORE! Voto già presente!", "Errore", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }while(votoOK == false);
                                        //chiedo all'utente se vuole aggiungere altri voti
                                        aggiungiVoti = JOptionPane.showConfirmDialog(null, "Aggiungere altri voti allo studente?", "Aggiungi voto", JOptionPane.YES_NO_OPTION);
                                    }while(aggiungiVoti == JOptionPane.YES_OPTION);
                                    //aggiugno studente alla classe
                                    do{
                                        studenteOK = classe.addStudente(studente);
                                        if(studenteOK == false){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Studente già presente!", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while(studenteOK == false);
                                    //chiedo se ci sono altri studenti da aggiungere alla classe
                                    aggiungiStudenti = JOptionPane.showConfirmDialog(null, "Ci sono altri studenti da aggiungere alla classe?", "Aggiungi studente", JOptionPane.YES_NO_OPTION);
                                }while(aggiungiStudenti == JOptionPane.YES_OPTION);
                                //ciclo per aggiungere insegnanti alla classe
                                do{
                                    //chiedo nome dell'insegnante e lo controllo
                                    do{
                                        nome = JOptionPane.showInputDialog(null, "Inserire il nome dell'insegnante da aggiungere alla classe", "Aggiungi nome", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((nome == null) || (nome.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Nome non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((nome == null) || (nome.equalsIgnoreCase(" ")));
                                    //chiedo cognome dell'insegnante e lo controllo
                                    do{
                                        cognome = JOptionPane.showInputDialog(null, "Inserire il cognome dell'insegnante", "Aggiungi cognome", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((cognome == null) || (cognome.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Cognome non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((cognome == null) || (cognome.equalsIgnoreCase(" ")));
                                    //controllo se l'insegnate è già stato inserito per altre classi
                                    esisteInsegnante = false;
                                    insegnanteCerca =  null;
                                    ins = 0;
                                    //ciclo che cerca tra gli insegnanti già inseriti
                                    while((esisteInsegnante == false) && (ins < insegnanti.size())){
                                        insegnanteCerca = insegnanti.get(ins);
                                        if((insegnanteCerca.getNome().equalsIgnoreCase(nome)) && (insegnanteCerca.getCognome().equalsIgnoreCase(cognome))){
                                            esisteInsegnante = true;
                                        }else{  
                                            ins++;
                                        }
                                    }
                                    //se l'insegnante esiste gia, aggiungo la classe al suo elenco classi
                                    if(esisteInsegnante == true){
                                        insegnante = insegnanti.get((ins));
                                        insegnante.addClasse(classe.getNome());
                                    //se l'insegnnate non esiste ancora, chiedo tutte le sue info
                                    }else{
                                        //chiedo email dell'insegnante e la controllo
                                        do{
                                            email = JOptionPane.showInputDialog(null, "Inserire email dell'insegnante", "Aggiungi email", JOptionPane.QUESTION_MESSAGE);
                                            //messaggio di errore
                                            if((email == null) || (email.equalsIgnoreCase(" "))){
                                                JOptionPane.showMessageDialog(null, "ERRORE! Email non valida", "Errore", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }while((email == null) || (email.equalsIgnoreCase(" ")));
                                        //chiedo codice fiscale dell'insegnante e lo "controllo"
                                        do{
                                            codFiscale = JOptionPane.showInputDialog(null, "Inserire il codice fiscale dell'insegnante", "Aggiungi codice fiscale", JOptionPane.QUESTION_MESSAGE);
                                            //messaggio di errore
                                            if((codFiscale == null) || (codFiscale.equalsIgnoreCase(" "))){
                                                JOptionPane.showMessageDialog(null, "ERRORE! Codice fiscale non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }while((codFiscale == null) || (codFiscale.equalsIgnoreCase(" ")));
                                        //chiedo numero di cellulare dell'insegnante e lo controllo
                                        do{
                                            numCell = JOptionPane.showInputDialog(null, "Inserire il numero di telefono dell'insegnante", "Aggiungi numero di telefono", JOptionPane.QUESTION_MESSAGE);
                                            //messaggio di errore
                                            if((numCell == null) || (numCell.equalsIgnoreCase(" ")) || (numCell.equalsIgnoreCase("0000000000"))){
                                                JOptionPane.showMessageDialog(null, "ERRORE! Numero di telefono non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }while((numCell == null) || (numCell.equalsIgnoreCase(" ")) || (numCell.equalsIgnoreCase("0000000000")));
                                        //chiedo la disciplina insegnata e la controllo
                                        do{
                                            corso = JOptionPane.showInputDialog(null, "Inserire la disciplina innsegnata", "Aggiungi disciplina", JOptionPane.QUESTION_MESSAGE);
                                            if((corso == null) || (corso.equalsIgnoreCase(" "))){
                                                JOptionPane.showMessageDialog(null, "ERRORE! Disciplina non valida", "Errore", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }while((corso == null) || (corso.equalsIgnoreCase(" ")));
                                        //chiedo stipendio dell'insegnante e lo controllo
                                        do{
                                            stipendio = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserire lo stipendio all'ora dell'insegnante", "Aggiungi stipendio orario", JOptionPane.QUESTION_MESSAGE));
                                            //messaggio di errore
                                            if(stipendio <= 0.0){
                                                JOptionPane.showMessageDialog(null, "ERRORE! Stipendio non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }while(stipendio <= 0.0);
                                        //creo insegnante e assegno i valori alle variabili d'istanza
                                        insegnante = new Insegnante(nome, cognome, email, codFiscale, numCell, corso, stipendio, classe.getNome());
                                        //aggiungo insegnante alla lista degli insegnanti
                                        insegnanti.add(insegnante);
                                    }
                                    //aggiugno insegnante alla classe
                                    do{
                                        insegnanteOK = classe.addInsegnante(insegnante);
                                        if(insegnanteOK == false){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Insegnante già presente!", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while(insegnanteOK == false);
                                    //chiedo se ci sono altri insegnanti da aggiungere alla classe
                                    aggiungiInsegnanti = JOptionPane.showConfirmDialog(null, "Ci sono altri insegnanti da aggiungere alla classe?", "Aggiungi insegnante", JOptionPane.YES_NO_OPTION);
                                }while(aggiungiInsegnanti == JOptionPane.YES_OPTION);
                                //aggiungo classe alla scuola
                                scuola.addClasse(classe);
                                //chiedo se ci sono altre classi da aggiungere
                                aggiungiClassi = JOptionPane.showConfirmDialog(null, "Ci sono altre classi da aggiungere alla scuola?", "Aggiungi classi", JOptionPane.YES_NO_OPTION);
                            }while(aggiungiClassi == JOptionPane.YES_OPTION);
                            //ciclo per aggiungere personale ata
                            do{
                                //ciclo per gestire l'aggiunta di personale ata già presente in lista
                                do{
                                    //chiedo nome della persona e lo controllo
                                    do{
                                        nome = JOptionPane.showInputDialog(null, "Inserire il nome della persona facente parte del gruppo Personale ATA", "Aggiungi nome", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((nome == null) || (nome.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Nome non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((nome == null) || (nome.equalsIgnoreCase(" ")));
                                    //chiedo cognome della persona e lo controllo
                                    do{
                                        cognome = JOptionPane.showInputDialog(null, "Inserire il cognome della persona", "Aggiungi cognome", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((cognome == null) || (cognome.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Cognome non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((cognome == null) || (cognome.equalsIgnoreCase(" ")));
                                    //chiedo email della persona e la controllo
                                    do{
                                        email = JOptionPane.showInputDialog(null, "Inserire email della persona", "Aggiungi email", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((email == null) || (email.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Email non valida", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((email == null) || (email.equalsIgnoreCase(" ")));
                                    //chiedo codice fiscale della persona e lo "controllo"
                                    do{
                                        codFiscale = JOptionPane.showInputDialog(null, "Inserire il codice fiscale della persona", "Aggiungi codice fiscale", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((codFiscale == null) || (codFiscale.equalsIgnoreCase(" "))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Codice fiscale non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((codFiscale == null) || (codFiscale.equalsIgnoreCase(" ")));
                                    //chiedo numero di cellulare della persona e lo controllo
                                    do{
                                        numCell = JOptionPane.showInputDialog(null, "Inserire il numero di telefono della persona", "Aggiungi numero di telefono", JOptionPane.QUESTION_MESSAGE);
                                        //messaggio di errore
                                        if((numCell == null) || (numCell.equalsIgnoreCase(" ")) || (numCell.equalsIgnoreCase("0000000000"))){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Numero di telefono non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while((numCell == null) || (numCell.equalsIgnoreCase(" ")) || (numCell.equalsIgnoreCase("0000000000")));
                                    //chiedo stipendio della persona e lo controllo
                                    do{
                                        stipendio = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserire lo stipendio all'ora della persona", "Aggiungi stipendio orario", JOptionPane.QUESTION_MESSAGE));
                                        //messaggio di errore
                                        if(stipendio <= 0.0){
                                            JOptionPane.showMessageDialog(null, "ERRORE! Stipendio non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }while(stipendio <= 0.0);
                                    //chiedo il piano in cui lavora la persona
                                    piano = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserire il piano dell'edificio in cui lavora la persona", "Aggiungi piano", JOptionPane.QUESTION_MESSAGE));
                                    //creo oggetto PersonaleATA
                                    PersonaleATA personaleATA = new PersonaleATA(nome, cognome, email, codFiscale, numCell, piano, stipendio, null);
                                    //ciclo per leggere le mansioni svolte
                                    do{
                                        //ciclo che richiede la mansione nel caso in cui sia già stata aggiunta in precedenza
                                        do{
                                            mansioneOK = personaleATA.addMansione(JOptionPane.showInputDialog(null, "Inserire mansione svolta", "Aggiungi mansione", JOptionPane.QUESTION_MESSAGE));
                                            //messaggio di errore
                                            if(mansioneOK == false){
                                                JOptionPane.showMessageDialog(null, "ERRORE! Mansione già presente!", "Errore", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }while(mansioneOK == false);
                                        //chiedo se ci sono altre mansioni da aggiungere
                                        aggiungiMansioni = JOptionPane.showConfirmDialog(null, "Ci sono altre mansioni da aggiungere a " + personaleATA.getNome() + " " + personaleATA.getCognome() + "?", "Aggiungi mansione", JOptionPane.YES_NO_OPTION);
                                    }while(aggiungiMansioni == JOptionPane.YES_OPTION);
                                    //aggiungo la persona alla scuola
                                    personaleATAOK = scuola.addPersonaleATA(personaleATA);
                                    //messaggio di errore
                                    if(personaleATAOK == false){
                                        JOptionPane.showMessageDialog(null, "ERRORE! Persona già inserita nella lista", "Errore", JOptionPane.ERROR_MESSAGE);
                                    }
                                }while(personaleATAOK == false);
                                //chiedo se ci sono altre persone del personale ata
                                aggiungiATA = JOptionPane.showConfirmDialog(null, "Ci sono altre persone che fanno parte del Personale ATA da aggiungere?", "Aggiungi Personale ATA", JOptionPane.YES_NO_OPTION);
                            }while(aggiungiATA == JOptionPane.YES_OPTION);
                            //aggiungo scuola all'elenco di scuole
                            scuole.add(scuola);
                            //creo file di scrittura, se non esiste già
                            if(f.createNewFile() == true){
                                //messaggio di creazione file
                                JOptionPane.showMessageDialog(null, "Sto creando il file su cui salvare i dati della scuola...", "Creo file", JOptionPane.WARNING_MESSAGE);
                            }
                            //scrivo su file
                            salvoScuola.println(scuola.toString());
                            salvoScuola.flush();
                            //chiedo se l'utente vuole aggiungere altre scuole
                            aggiungiScuole = JOptionPane.showConfirmDialog(null, "Vuoi aggiungere un'altra scuola?", "Aggiungi scuola", JOptionPane.YES_NO_OPTION);
                        }while(aggiungiScuole == JOptionPane.YES_OPTION);
                        //chiedo se l'utente vuole tornare al menù
                        menu = JOptionPane.showConfirmDialog(null, "Tornare al menu?", "Torna al menu", JOptionPane.YES_NO_OPTION);
                        break;
                    }
                    case 2:{
                        //creo puntatori degli oggetti e li inizializzo vuoti, così che siano visibili in tutti i rami della switch-case
                        Scuola scuola = null;
                        Classe classe = null;
                        Studente studente = null;
                        Voto voto = null;
                        insegnante = null;
                        PersonaleATA personaleATA = null;
                        //chiedo il nome del file e lo controllo
                        do{
                            pathLeggo = JOptionPane.showInputDialog(null, "Inserire il nome del file da cui leggere le info sulla scuola. NOTA BENE: Il file deve ssere nella stessa directory del programma", "Percorso file", JOptionPane.PLAIN_MESSAGE);
                            //messaggio di errore
                            if((pathLeggo == null) || (pathLeggo.equalsIgnoreCase(" ")) || (pathLeggo.equalsIgnoreCase(""))){
                                JOptionPane.showMessageDialog(null, "ERRORE! Nome non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                            }
                        }while((pathLeggo == null) || (pathLeggo.equalsIgnoreCase(" ")) || (pathLeggo.equalsIgnoreCase("")));
                        //chiedo quale separatore è stato utilizzato per il file csv da cui leggere
                        do{
                            separatore = JOptionPane.showInputDialog(null, "Inserire il separatore utilizzato nel file .csv da cui leggere le info sulla scuola", "Separatore file", JOptionPane.PLAIN_MESSAGE);
                            //messaggio di errore
                            if((separatore == null) || (separatore.equalsIgnoreCase(" ")) || (separatore.equalsIgnoreCase(""))){
                                JOptionPane.showMessageDialog(null, "ERRORE! Separatore non valido", "Errore", JOptionPane.ERROR_MESSAGE);
                            }
                        }while((separatore == null) || (separatore.equalsIgnoreCase(" ")) || (separatore.equalsIgnoreCase("")));
                        //preparo file da cui leggere le info sulla scuola
                        File f2 = new File(pathLeggo);
                        //controllo se il file esiste
                        if(f2.exists() == false){
                           JOptionPane.showMessageDialog(null, "ERRORE! File NON presente", "Errore", JOptionPane.ERROR_MESSAGE);
                        }
                        FileReader fr = new FileReader(f2);
                        Scanner leggoScuola = new Scanner(fr);
                        //imposto l'errore a falso
                        IOError = false;
                        //leggo file finche ci sono righe e finchè non ci sono errori
                        while((leggoScuola.hasNextLine()) && (IOError == false)){
                            leggoRiga = (leggoScuola.nextLine()).split(separatore);
                            //in base alla prima parola della riga, il programma capisce come procedere
                            switch(leggoRiga[0].toLowerCase()){
                                //caso in cui la prima parola sia scuola
                                case "scuola":{
                                    //controllo che siano stati forniti i parametri previsti
                                    if(leggoRiga.length == 3){
                                        //controllo primo parametro
                                        if((leggoRiga[1] != null) && (!(leggoRiga[1].equalsIgnoreCase(" "))) && (!(leggoRiga[1].equalsIgnoreCase("")))){
                                            //assegno nome scuola
                                            nomeScuola = leggoRiga[1];
                                            //controllo secondo parametro
                                            if((leggoRiga[2] != null) && (!(leggoRiga[2].equalsIgnoreCase(" "))) && (!(leggoRiga[2].equalsIgnoreCase("")))){
                                                //assegno codice meccanografico
                                                codiceMeccanografico = leggoRiga[2];
                                                //inizializzo scuola
                                                scuola = new Scuola(null, null, nomeScuola, codiceMeccanografico);
                                            }else{
                                                //parametro non valido
                                                IOError = true;
                                            }
                                        //parametro non valido
                                        }else{
                                            IOError = true;
                                        }
                                    //non sono stati forniti parametri a sufficienza
                                    }else {
                                        IOError = true;
                                    }
                                    break;
                                }
                                //caso in cui la prima parola sia classe (si presuppone di aver già creato una scuola, non ancora completata)
                                case "classe":{
                                    //controllo che siano stati forniti i parametri previsti
                                    if(leggoRiga.length == 2){
                                        //controllo parametro
                                        if((leggoRiga[1] != null) && (!(leggoRiga[1].equalsIgnoreCase(" "))) && (!(leggoRiga[1].equalsIgnoreCase("")))){
                                            nome = leggoRiga[1];
                                            //inizializzo classe
                                            classe = new Classe(null, null, nome);
                                        //parametro non valido
                                        }else{
                                            IOError = true;
                                        }
                                    //non sono stati forniti parametri a sufficienza
                                    }else{
                                        IOError = true;
                                    }
                                    break;
                                }
                                //caso in cui la prima parola sia studente (si presuppone di aver già creato una scuola e una classe, non ancora completati)
                                case "studente":{
                                    //controllo che siano stati forniti i parametri previsti
                                    if(leggoRiga.length == 7){
                                        //controllo primo parametro
                                        if((leggoRiga[1] != null) && (!(leggoRiga[1].equalsIgnoreCase(" "))) && (!(leggoRiga[1].equalsIgnoreCase("")))){
                                            nome = leggoRiga[1];
                                            //controllo secondo parametro
                                            if((leggoRiga[2] != null) && (!(leggoRiga[2].equalsIgnoreCase(" "))) && (!(leggoRiga[2].equalsIgnoreCase("")))){
                                                cognome = leggoRiga[2];
                                                //controllo terzo parametro
                                                if((leggoRiga[3] != null) && (!(leggoRiga[3].equalsIgnoreCase(" "))) && (!(leggoRiga[3].equalsIgnoreCase("")))){
                                                    email = leggoRiga[3];
                                                    //controllo quarto parametro
                                                    if((leggoRiga[4] != null) && (!(leggoRiga[4].equalsIgnoreCase(" "))) && (!(leggoRiga[4].equalsIgnoreCase("")))){
                                                        codFiscale = leggoRiga[4];
                                                        //controllo quinto parametro
                                                        if((leggoRiga[5] != null) && (!(leggoRiga[5].equalsIgnoreCase(" "))) && (!(leggoRiga[5].equalsIgnoreCase("")))){
                                                            numCell = leggoRiga[5];
                                                            //controllo sesto parametro
                                                            if((leggoRiga[6] != null) && (!(leggoRiga[6].equalsIgnoreCase(" "))) && (!(leggoRiga[6].equalsIgnoreCase("")))){
                                                                //controllo che la matricola sia un numero convertibile in intero
                                                                try{
                                                                    matricola = Integer.parseInt(leggoRiga[6]);
                                                                    //inizializzo studente
                                                                    studente = new Studente(nome, cognome, email, codFiscale, numCell, matricola, null);
                                                                //caso in cui la matricola non sia un numero intero
                                                                }catch(NumberFormatException e){
                                                                    IOError = true;
                                                                }
                                                            //parametro non valido
                                                            }else{
                                                                IOError = true;
                                                            }
                                                        //parametro non valido
                                                        }else{
                                                            IOError = true;
                                                        }
                                                    //parametro non valido
                                                    }else{
                                                        IOError = true;
                                                    }
                                                //parametro non valido
                                                }else{
                                                    IOError = true;
                                                }
                                            //parametro non valido
                                            }else{
                                                IOError = true;
                                            }
                                        //parametro non valido
                                        }else{
                                            IOError = true;
                                        }
                                    //non sono stati forniti parametri a sufficienza
                                    }else{
                                        IOError = true;
                                    }
                                    break;
                                }
                                //caso in cui la prima parola sia voto (si presuppone di aver già creato una scuola, una classe e uno studente,non ancora completati)
                                case "voto":{
                                    //controllo che siano stati forniti i parametri previsti
                                    if(leggoRiga.length == 4){
                                        //controllo primo parametro
                                        if((leggoRiga[1] != null) && (!(leggoRiga[1].equalsIgnoreCase(" "))) && (!(leggoRiga[1].equalsIgnoreCase("")))){
                                            materia = leggoRiga[1];
                                            //controllo secondo parametro
                                            if((leggoRiga[2] != null) && (!(leggoRiga[2].equalsIgnoreCase(" "))) && (!(leggoRiga[2].equalsIgnoreCase("")))){
                                                //controllo che il valore del voto sia convertibile in double
                                                try{
                                                    valore = Double.parseDouble(leggoRiga[2]);
                                                    //verifico che il voto sia compreso tra 1 e 10, altrimenti errore
                                                    if(valore < 1 || valore > 10){
                                                        IOError = true;
                                                    }else{
                                                        //controllo terzo parametro
                                                        if((leggoRiga[3] != null) && (!(leggoRiga[3].equalsIgnoreCase(" "))) && (!(leggoRiga[3].equalsIgnoreCase("")))){
                                                            //divido in un array il giorno, il mese e l'anno del voto, usando / come separatore
                                                            data = leggoRiga[3].split("/");
                                                            //effettuo la conversione dei valori ottenuti in interi, se possibile
                                                            try{
                                                                giorno = Integer.parseInt(data[0]);
                                                                mese = Integer.parseInt(data[1]);
                                                                anno = Integer.parseInt(data[2]);
                                                                //creo oggetto e invoco metodo per controllare la data
                                                                ControlloData controlloData = new ControlloData(giorno, mese, anno);
                                                                dataOK = controlloData.controllaData();
                                                                //controllo se la data è stata verificata
                                                                if(dataOK = true){
                                                                    //inizializzo Voto
                                                                    voto = new Voto(materia, valore, giorno, mese, anno);
                                                                    //assegno voto allo studente
                                                                    studente.addVoto(voto);
                                                                    //aggiungo lo studente, completo, alla classe: se esiste già, lo aggiorno rimuovendo quello vecchio e inserendo quello con i voti aggiornati
                                                                    studenteOK = classe.addStudente(studente);
                                                                    //caso di studente gia aggiunto, quindi da aggiornare
                                                                    if(studenteOK == false){
                                                                        //rimuovo studente "vecchio"
                                                                        classe.rimuoviStudente(studente.getNome() + " " + studente.getCognome());
                                                                        //aggiungo lo stesso studente, ma con i voti aggiornati
                                                                        classe.addStudente(studente);
                                                                    }
                                                                    //aggiugno la classe, se non vuota, alla scuola
                                                                    if((classe.getNumeroInsegnanti () > 0) && (classe.getNumeroStudenti() > 0)){
                                                                        //provo ad aggiungere la classe alla scuola; se già presente, laa rimuovo e la aggiorno
                                                                        classeOK = scuola.addClasse(classe);
                                                                        if(classeOK == false){
                                                                            //rimuovo "vecchia" classe
                                                                            scuola.rimuoviClasse(classe.getNome());
                                                                            //aggiungo la stessa classe, ma con insegnenti e studenti aggiornati
                                                                            scuola.addClasse(classe);
                                                                        }
                                                                    }
                                                                //data non valida
                                                                }else{
                                                                    IOError = true;
                                                                }
                                                            //conversione non possibile
                                                            }catch(NumberFormatException e){
                                                                IOError = true;
                                                            }
                                                        //parametro non valido
                                                        }else{
                                                            IOError = true;
                                                        }
                                                    }
                                                }catch(NumberFormatException e){
                                                    IOError = true;
                                                }
                                            //parametro non valido
                                            }else{
                                                IOError = true;
                                            }
                                        //parametro non valido
                                        }else{
                                            IOError = true;
                                        }
                                    //non sono stati forniti parametri a sufficienza
                                    }else{
                                        IOError = true;
                                    }
                                    break;
                                }
                                case "insegnante":{
                                    //controllo che siano stati forniti i parametri previsti
                                    if(leggoRiga.length == 8){
                                        //controllo primo parametro
                                        if((leggoRiga[1] != null) && (!(leggoRiga[1].equalsIgnoreCase(" "))) && (!(leggoRiga[1].equalsIgnoreCase("")))){
                                            nome = leggoRiga[1];
                                            //controllo secondo parametro
                                            if((leggoRiga[2] != null) && (!(leggoRiga[2].equalsIgnoreCase(" "))) && (!(leggoRiga[2].equalsIgnoreCase("")))){
                                                cognome = leggoRiga[2];
                                                //controllo se l'insegnate è già stato inserito per altre classi
                                                esisteInsegnante = false;
                                                insegnanteCerca =  null;
                                                ins = 0;
                                                //ciclo che cerca tra gli insegnanti già inseriti
                                                while((esisteInsegnante == false) && (ins < insegnanti.size())){
                                                    insegnanteCerca = insegnanti.get(ins);
                                                    if((insegnanteCerca.getNome().equalsIgnoreCase(nome)) && (insegnanteCerca.getCognome().equalsIgnoreCase(cognome))){
                                                        esisteInsegnante = true;
                                                    }else{  
                                                        ins++;
                                                    }
                                                }
                                                //se l'insegnante esiste gia, aggiungo la classe al suo elenco classi
                                                if(esisteInsegnante == true){
                                                    insegnante = insegnanti.get((ins));
                                                    insegnante.addClasse(classe.getNome());
                                                //se l'insegnante non esiste ancora, leggo le sue info e lo creo
                                                }else{
                                                    //controllo terzo parametro
                                                    if((leggoRiga[3] != null) && (!(leggoRiga[3].equalsIgnoreCase(" "))) && (!(leggoRiga[3].equalsIgnoreCase("")))){
                                                        email = leggoRiga[3];
                                                        //controllo quarto parametro
                                                        if((leggoRiga[4] != null) && (!(leggoRiga[4].equalsIgnoreCase(" "))) && (!(leggoRiga[4].equalsIgnoreCase("")))){
                                                            codFiscale = leggoRiga[4];
                                                            //controllo quinto parametro
                                                            if((leggoRiga[5] != null) && (!(leggoRiga[5].equalsIgnoreCase(" "))) && (!(leggoRiga[5].equalsIgnoreCase("")))){
                                                                numCell = leggoRiga[5];
                                                                //controllo sesto parametro
                                                                if((leggoRiga[6] != null) && (!(leggoRiga[6].equalsIgnoreCase(" "))) && (!(leggoRiga[6].equalsIgnoreCase("")))){
                                                                    corso = leggoRiga[6];
                                                                    //controllo settimo parametro
                                                                    if((leggoRiga[7] != null) && (!(leggoRiga[7].equalsIgnoreCase(" "))) && (!(leggoRiga[7].equalsIgnoreCase("")))){
                                                                        //converto stipendio in double, se possibile
                                                                        try{
                                                                            stipendio = Double.parseDouble(leggoRiga[7]);
                                                                            //inizializzo insegnante
                                                                            insegnante = new Insegnante(nome, cognome, email, codFiscale, numCell, corso, stipendio, classe.getNome());
                                                                            //aggiungo insegnante alla lista insegnanti
                                                                            insegnanti.add(insegnante);
                                                                            //aggiugno la classe, se non vuota, alla scuola
                                                                            if((classe.getNumeroInsegnanti () > 0) && (classe.getNumeroStudenti() > 0)){
                                                                                //provo ad aggiungere la classe alla scuola; se già presente, laa rimuovo e la aggiorno
                                                                                classeOK = scuola.addClasse(classe);
                                                                                if(classeOK == false){
                                                                                    //rimuovo "vecchia" classe
                                                                                    scuola.rimuoviClasse(classe.getNome());
                                                                                    //aggiungo la stessa classe, ma con insegnenti e studenti aggiornati
                                                                                    scuola.addClasse(classe);
                                                                                }
                                                                            }
                                                                        //conversione non possibile
                                                                        }catch(NumberFormatException e){
                                                                            IOError = true;
                                                                        }
                                                                    //parametro non valido
                                                                    }else{
                                                                        IOError = true;
                                                                    }
                                                                //parametro non valido
                                                                }else{
                                                                    IOError = true;
                                                                }
                                                            //parametro non valido
                                                            }else{
                                                                IOError = true;
                                                            }
                                                        //parametro non valido
                                                        }else{
                                                            IOError = true;
                                                        }
                                                    //parametro non valido
                                                    }else{
                                                        IOError = true;
                                                    }
                                                }
                                                //aggiungo insegnante alla classe
                                                classe.addInsegnante(insegnante);
                                            //parametro non valido
                                            }else{
                                                IOError = true;
                                            }
                                        //parametro non valido
                                        }else{
                                            IOError = true;
                                        }
                                    //non sono stati forniti parametri a sufficienza
                                    }else{
                                        IOError = true;
                                    }
                                    break;
                                }
                                case "personaleata":{
                                    //controllo che siano stati forniti i parametri previsti
                                    if(leggoRiga.length == 8){
                                        //controllo primo parametro
                                        if((leggoRiga[1] != null) && (!(leggoRiga[1].equalsIgnoreCase(" "))) && (!(leggoRiga[1].equalsIgnoreCase("")))){
                                            nome = leggoRiga[1];
                                            //controllo secondo parametro
                                            if((leggoRiga[2] != null) && (!(leggoRiga[2].equalsIgnoreCase(" "))) && (!(leggoRiga[2].equalsIgnoreCase("")))){
                                                cognome = leggoRiga[2];
                                                //controllo terzo parametro
                                                if((leggoRiga[3] != null) && (!(leggoRiga[3].equalsIgnoreCase(" "))) && (!(leggoRiga[3].equalsIgnoreCase("")))){
                                                    email = leggoRiga[3];
                                                    //controllo quarto parametro
                                                    if((leggoRiga[4] != null) && (!(leggoRiga[4].equalsIgnoreCase(" "))) && (!(leggoRiga[4].equalsIgnoreCase("")))){
                                                        codFiscale = leggoRiga[4];
                                                        //controllo quinto parametro
                                                        if((leggoRiga[5] != null) && (!(leggoRiga[5].equalsIgnoreCase(" "))) && (!(leggoRiga[5].equalsIgnoreCase("")))){
                                                            numCell = leggoRiga[5];
                                                            //controllo sesto parametro
                                                            if((leggoRiga[6] != null) && (!(leggoRiga[6].equalsIgnoreCase(" "))) && (!(leggoRiga[6].equalsIgnoreCase("")))){
                                                                //controllo che lo stipendio sia un numero convertibile in intero
                                                                try{
                                                                    stipendio = Double.parseDouble(leggoRiga[6]);
                                                                    //controllo settimo parametro
                                                                    if((leggoRiga[7] != null) && (!(leggoRiga[7].equalsIgnoreCase(" "))) && (!(leggoRiga[7].equalsIgnoreCase("")))){
                                                                        //controllo che il numero del piano sia convertibile in intero
                                                                        try{
                                                                            piano = Integer.parseInt(leggoRiga[7]);
                                                                            //inizializzo personaleata
                                                                            personaleATA = new PersonaleATA(nome, cognome, email, codFiscale, numCell, piano, stipendio, null);
                                                                            //caso in cui il numero del piano non sia convertibile in intero
                                                                        }catch(NumberFormatException e){
                                                                            IOError = true;
                                                                        }
                                                                    //parametro non valido
                                                                    }else{
                                                                        IOError = true;
                                                                    }
                                                                //caso in cui lo stipendio non sia un numero intero
                                                                }catch(NumberFormatException e){
                                                                    IOError = true;
                                                                }
                                                            //parametro non valido
                                                            }else{
                                                                IOError = true;
                                                            }
                                                        //parametro non valido
                                                        }else{
                                                            IOError = true;
                                                        }
                                                    //parametro non valido
                                                    }else{
                                                        IOError = true;
                                                    }
                                                //parametro non valido
                                                }else{
                                                    IOError = true;
                                                }
                                            //parametro non valido
                                            }else{
                                                IOError = true;
                                            }
                                        //parametro non valido
                                        }else{
                                            IOError = true;
                                        }
                                    //non sono stati forniti parametri a sufficienza
                                    }else{
                                        IOError = true;
                                    }
                                    break;
                                }
                                case "mansioni":{
                                    //aggiungo al personaleata le mansioni
                                    for(int m = 0; (m < leggoRiga.length) && (IOError == false); m++){
                                        //verifico mansione
                                        if((leggoRiga[m] != null) && (!(leggoRiga[m].equalsIgnoreCase(" "))) && (!(leggoRiga[m].equalsIgnoreCase("")))){
                                            //aggiungo mansione
                                            personaleATA.addMansione(leggoRiga[m]);
                                        //mansione non valida
                                        }else{
                                            IOError = true;
                                        }
                                    }
                                    //aggiungo personaleata alla scuola
                                    scuola.addPersonaleATA(personaleATA);
                                }
                            }
                        }
                        //aggiungo scuola alla lista delle scuole
                        scuole.add(scuola);
                        //messaggio di errore
                        if(IOError == true){
                            JOptionPane.showMessageDialog(null, "ERRORE! Parametri non validi", "Errore", JOptionPane.ERROR_MESSAGE);
                        }
                        //chiudo file di scrittura
                        leggoScuola.close();
                        break;
                    }
                    case 3:{
                        //cerco scuola finchè non si trova una scuola corrispondente al codice meccanografico fornito o finchè l'utente non esce dal ciclo tramite interfaccia grafica
                        do{
                            //inizializzo le variabili utilizzate per la ricerca della scuola tra quelle presenti in lista
                            scuolaTrovata = false;
                            c = 0;
                            scuolaCerca = null;
                            //inizializzo la variabile in modo tale da non ripetere la domanda per la ricerca. Se l'utente vuole cercare un'altra scuola, lo potrà fare solo se la prima scuola cercata è presente in lista. In questo modo, in caso di scuola cercata non presente, sarà rimandato al menù principale per poterla aggiungere
                            visualizzaScuole = JOptionPane.NO_OPTION;
                            //chiedo codice meccanografico della scuola da cercare
                            codiceMeccanografico = JOptionPane.showInputDialog(null, "Inserire il codice meccanografico della scuola da cercare tra quelle aggiunte", "Cerca scuola", JOptionPane.PLAIN_MESSAGE);
                            //ciclo per trovare la scuola corrispondente, dato il codice meccanografico fornito
                            while((scuolaTrovata == false) && (c < scuole.size())){
                                //prelevo la prossima scuola in lista
                                scuolaCerca = scuole.get(c);
                                //controllo, tramite il codice meccanografico, se la scuola estratta è quella giusta
                                if((scuolaCerca.getCodice()).equalsIgnoreCase(codiceMeccanografico)){
                                    //variabile di uscita dal ciclo, scuola trovata
                                    scuolaTrovata = true;
                                }
                                //incremento variabile ciclo
                                c++;
                            }
                            //controllo se la scuola è stata trovata
                            if(scuolaTrovata == true){
                                //messaggio di avviso per l'utente
                                JOptionPane.showMessageDialog(null, "Scuola trovata!", "Info", JOptionPane.WARNING_MESSAGE);
                                //output info scuola
                                System.out.println(scuolaCerca.toString());
                                //chiedo se si vogliono visualizzare le info di altre scuole nella lista
                                visualizzaScuole = JOptionPane.showConfirmDialog(null, "Si vogliono visualizzare le informazioni di un'altra scuola?", "Visualizza info scuola", JOptionPane.YES_NO_OPTION);
                            }else{
                                //messaggio di scuola non trovata
                                JOptionPane.showMessageDialog(null, "Scuola non trovata...cercare un'altra scuola oppure inserirla tramite l'opzione 1 del programma", "Info", JOptionPane.ERROR_MESSAGE);
                            }
                        }while(visualizzaScuole == JOptionPane.YES_OPTION);
                        //chiedo se l'utente vuole tornare al menù
                        menu = JOptionPane.showConfirmDialog(null, "Tornare al menu?", "Torna al menu", JOptionPane.YES_NO_OPTION);
                        break;
                    }
                    default:{
                        //caso in cui l'utente digita un numero non previsto in elenco
                        JOptionPane.showMessageDialog(null, "ERRORE! Opzione non valida", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }while((opzione != 1) && (opzione != 2) || (menu == JOptionPane.YES_OPTION));
            //chiudo file di scrittura
            salvoScuola.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "ERRORE di I/O", "Errore di I/O", JOptionPane.ERROR_MESSAGE);
        }
    }     
}