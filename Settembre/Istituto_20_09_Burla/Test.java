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
        String codiceMeccanografico;
        String nomeScuola;
        //arraylist che contiene tutte le scuole da gestire
        ArrayList <Scuola> scuole = new ArrayList <Scuola> ();
        //messaggio di benvenuto
        JOptionPane.showMessageDialog(null, "BENVENUTO! Con questo programma potrai creare e gestire un elenco di scuole. Premi OK per continuare", "Benvenuto", JOptionPane.WARNING_MESSAGE);
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
                    Studente studente = new Studente(nomeScuola, cognome, email, codFiscale, numCell, matricola);
                    //chiedo se ci sono altri studenti da aggiungere alla classe
                    aggiungiStudenti = JOptionPane.showConfirmDialog(null, "Ci sono altri studenti da aggiungere alla classe?", "Aggiungi studente", JOptionPane.YES_NO_OPTION);
                }while(aggiungiStudenti == JOptionPane.YES_OPTION);



                //agiungo classe alla scuola
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
    }
}