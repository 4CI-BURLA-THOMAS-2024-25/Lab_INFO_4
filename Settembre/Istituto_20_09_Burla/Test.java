/**
 * classe Test, main
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Test {
    public static void main(String args[]){
        //variabile utilizzata dal menu di scelta iniziale
        int opzione;
        //variabili per la ricerca della scuola, tra quelle esistenti
        boolean scuolaTrovata;
        int c;
        Scuola scuolaCerca;
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
        //varibili utilizzate per passare parametri agli oggetti di tipo Persone (e classi che ereditano i suoi attributi)
        String nome, cognome, email, codFiscale, numCell;
        //variabile che contiene stipendio all'ora del lavoratore scolastico
        double stipendio;
        //variabile per verificare che l'aggiunta della mansione sia andata a buon fine
        boolean mansioneOK;
        //piano su cui lavora la persona del personale ata
        int piano;
        //matricola dello studente da aggiungere alla classe
        int matricola;
        //variabile per verificare che l'aggiunta dello studente alla classe sia andata a buon fine
        boolean studenteOK;
        //disciplina insegnata dall'insegnante
        String corso;
        //variabile per verificare che l'aggiunta dell'insegnante alla classe sia andata a buon fine
        boolean insegnanteOK;
        //variabili scuola
        String codiceMeccanografico;
        String nomeScuola;
        //arraylist che contiene tutte le scuole da gestire
        ArrayList <Scuola> scuole = new ArrayList <Scuola> ();
        //chiedo se l'utente vuole aggiungere scuole oppure visualizzare quelle già inserite
        opzione = Integer.parseInt(JOptionPane.showInputDialog(null, "BENVENUTO! Con questo programma potrai creare e gestire un elenco di scuole. Digita: \n1 per inserire una nuova scuola; \n2 per visualizzare le informazioni di una scuola già esistente ", "Opzione", JOptionPane.PLAIN_MESSAGE));
        //chiedo all'utente di digitare un numero a seconda dell'opzione desiderata e riepto la domanda se digitato un numero non valido
        do{
            //menu di scelta
            switch(opzione){
                case 1:{
                    //ciclo per aggiungere scuole all'elenco finchè l'utente lo deisdera
                    do{
                        //chiedo il nome della scuola
                        nomeScuola = JOptionPane.showInputDialog(null, "Inserire il nome della scuola", "Nome scuola", JOptionPane.QUESTION_MESSAGE);
                        //chiedo il codice meccanografico della scuola
                        codiceMeccanografico = JOptionPane.showInputDialog(null, "Inserire il codice meccanografico della scuola", "Inserisci codice meccanografico", JOptionPane.QUESTION_MESSAGE);
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
                                Studente studente = new Studente(nome, cognome, email, codFiscale, numCell, matricola);
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
                                Insegnante insegnante = new Insegnante(nome, cognome, email, codFiscale, numCell, corso, stipendio, null);
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
                            scuola.addPersonaleATA(personaleATA);
                            //chiedo se ci sono altre persone del personale ata
                            aggiungiATA = JOptionPane.showConfirmDialog(null, "Ci sono altre persone che fanno parte del Personale ATA da aggiungere?", "Aggiungi Personale ATA", JOptionPane.YES_NO_OPTION);
                        }while(aggiungiATA == JOptionPane.YES_OPTION);
                        //chiedo se l'utente vuole aggiungere altre scuole
                        aggiungiScuole = JOptionPane.showConfirmDialog(null, "Vuoi aggiungere un'altra scuola?", "Aggiungi scuola", JOptionPane.YES_NO_OPTION);
                    }while(aggiungiScuole == JOptionPane.YES_OPTION);
                    break;
                }
                case 2:{
                    //cerco scuola finchè non si trova una scuola corrispondente al codice meccanografico fornito o finchè l'utente non esce dal ciclo tramite interfaccia grafica
                    do{
                        //inizializzo le variabili utilizzate per la ricerca della scuola tra quelle presenti in lista
                        scuolaTrovata = false;
                        c = 0;
                        scuolaCerca = null;
                        //inizializzo la variabile con lo stesso valore dato in return dalla finestra della JOptionPane nel caso in cui l'utente digitasse si: in questo modo, se non si trova una scuola corrispondente al codice indicato, anche la variabile sottoscritta garantisce la richiesta di un altro codice
                        visualizzaScuole = 0;
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
                    }while((scuolaTrovata == false) || (visualizzaScuole == JOptionPane.YES_OPTION));
                    break;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "ERRORE! Opzione non valida", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        }while((opzione != 1) && (opzione != 2));
    }    
}