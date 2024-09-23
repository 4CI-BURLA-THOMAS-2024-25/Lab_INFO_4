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
        int aggiungiMansione;
        //varibili utilizzate per passare parametri agli oggetti di tipo Persone (e classi che ereditano i suoi attributi)
        String nome, cognome, email, codFiscale, numCell;
        //variabile che contiene stipendio all'ora del lavoratore scolastico
        double stipendio;
        //variabile per verificare che l'aggiunta della mansione sia andata a buon fine
        boolean mansioneOK;
        //piano su cui lavora la persona del personale ata
        int piano;
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
            //ciclo per aggiungere classi
            do{


                aggiungiClassi = JOptionPane.showConfirmDialog(null, "Ci sono altre classi da aggiungere alla scuola?", "Aggiungi classi", JOptionPane.YES_NO_OPTION);
            }while(aggiungiClassi == JOptionPane.YES_OPTION);
            //ciclo per aggiungere personale ata
            do{
                //chiedo nome della persona
                nome = JOptionPane.showInputDialog(null, "Inserire il nome della persona facente parte del gruppo Personale ATA" , "Aggiungi nome", JOptionPane.QUESTION_MESSAGE);
                //chiedo cognome della persona
                cognome = JOptionPane.showInputDialog(null, "Inserire il cognome della persona" , "Aggiungi cognome", JOptionPane.QUESTION_MESSAGE);
                //chiedo email della persona
                email = JOptionPane.showInputDialog(null, "Inserire email della persona" , "Aggiungi email", JOptionPane.QUESTION_MESSAGE);
                //chiedo codice fiscale della persona
                codFiscale = JOptionPane.showInputDialog(null, "Inserire il codice fiscale della persona", "Aggiungi codice fiscale", JOptionPane.QUESTION_MESSAGE);
                //chiedo numero di cellulare della persona
                numCell = JOptionPane.showInputDialog(null, "Inserire il numero di telefono della persona", "Aggiungi numero di telefono", JOptionPane.QUESTION_MESSAGE);
                //chiedo stipendio della persona
                stipendio = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserire lo stipendio all'ora della persona" , "Aggiungi stipendio orario", JOptionPane.QUESTION_MESSAGE));
                //chiedo il piano in cui lavora la persona
                piano = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserire il piano dell'edificio in cui lavora la persona" , "Aggiungi piano", JOptionPane.QUESTION_MESSAGE));
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
                    aggiungiMansione = JOptionPane.showConfirmDialog(null, "Ci sono altre mansioni da aggiungere a " + personaleATA.getNome() + " " + personaleATA.getCognome() + "?", "Aggiungi mansioni", JOptionPane.YES_NO_OPTION);
                }while(aggiungiMansione == JOptionPane.YES_OPTION);
                aggiungiATA = JOptionPane.showConfirmDialog(null, "Ci sono altre persone che fanno parte del Personale ATA da aggiungere?", "Aggiungi Personale ATA", JOptionPane.YES_NO_OPTION);
            }while(aggiungiATA == JOptionPane.YES_OPTION);



            Scuola scuola = new Scuola(null, null, codiceMeccanografico, nomeScuola);
            //chiedo se l'utente vuole aggiungere altre scuole
            aggiungiScuole = JOptionPane.showConfirmDialog(null, "Vuoi aggiungere un'altra scuola?", "Aggiungi scuola", JOptionPane.YES_NO_OPTION);
        }while(aggiungiScuole == JOptionPane.YES_OPTION);
    }
}