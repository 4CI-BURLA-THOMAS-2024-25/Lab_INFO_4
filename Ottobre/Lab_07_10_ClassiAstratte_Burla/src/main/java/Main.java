/**
 * classe che contiene il main da eseguire
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Main {
    public static void main(String args[]){
        //variabile utilizzata per far scegliere all'utente cosa fare dal menu
        int opzione;
        //variabile per tornare al menu
        int menu;
        //istruzione che indica al compilatore di ignorare il fatto che la arraylist solidi possa contenere qualsiasi oggetto
        @SuppressWarnings("rawtypes")
        //arraylist di solidi
        ArrayList solidi = new ArrayList<>(); 
        //variabile impostata a true nel caso in cui si inserisca un tipo di dato non atteso
        boolean incompatibile;
        //raggio, chiesto solo se necessario per i calcoli sul solido scelto
        double raggio = 0;
        //altezza, chiesta solo se necessaria per i calcoli sul solido scelto
        double altezza = 0;
        //peso specifico, chiesto in tutti i solidi
        double pesoSpecifico = 0.0;
        //ciclo per aggiungere solidi finchè l'utente lo desidera
        do{
            //chiedo all'utente cosa fuore fare dal menu
            opzione = Integer.parseInt(JOptionPane.showInputDialog(null, "BENVENUTO! Questo programma ti permette di effettuare dei calcoli su dei solidi geometrici. Scegli con quale solido vuoi operare, digitando un numero del seguente menu:\n1.cilindro;\n2.cono;\n3.Cubo;\n4.Sfera." , "Scegli solido", JOptionPane.PLAIN_MESSAGE));
            //esecuzione diversificata in base all'opzione scelta
            switch(opzione){
                case 1:{
                    //leggo e controllo peso specifico
                    do{
                        //variabile impostata a true nel caso in cui si inserisca un tipo di dato non atteso, di base impostata a false
                        incompatibile = false;
                        //verifico che l'utente inserisca un double
                        try{
                            //leggo pesoSpecifico
                            pesoSpecifico = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserire il peso specifico del solido", "Inserisci peso specifico", JOptionPane.QUESTION_MESSAGE));
                            //messaggio di errore in caso di valore non valido
                            if(pesoSpecifico <= 0.0){
                                JOptionPane.showMessageDialog(null, "ERRORE! Valore non valido" , "Errore" , JOptionPane.ERROR_MESSAGE);
                            }
                        //caso in cui l'utente non digiti un double
                        }catch(NumberFormatException e){
                            incompatibile = true;
                            JOptionPane.showMessageDialog(null, "ERRORE! Tipo di dato incompatibile", "Dato non compatibile", JOptionPane.ERROR_MESSAGE);
                        }
                    }while((pesoSpecifico <= 0.0) || (incompatibile = true));
                    //leggo e controllo raggio
                    do{
                        //variabile impostata a true nel caso in cui si inserisca un tipo di dato non atteso, di base impostata a false
                        incompatibile = false;
                        //verifico che l'utente inserisca un double
                        try{
                            //leggo raggio
                            raggio = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserire il raggio della base del solido", "Inserisci raggio", JOptionPane.QUESTION_MESSAGE));
                            //messaggio di errore in caso di valore non valido
                            if(raggio <= 0.0){
                                JOptionPane.showMessageDialog(null, "ERRORE! Valore non valido" , "Errore" , JOptionPane.ERROR_MESSAGE);
                            }
                        //caso in cui l'utente non digiti un double
                        }catch(NumberFormatException e){
                            incompatibile = true; 
                            JOptionPane.showMessageDialog(null, "ERRORE! Tipo di dato incompatibile", "Dato non compatibile", JOptionPane.ERROR_MESSAGE);
                        }
                    }while((raggio <= 0.0) || (incompatibile = true));
                    //leggo e controllo altezza
                    do{
                        //variabile impostata a true nel caso in cui si inserisca un tipo di dato non atteso, di base impostata a false
                        incompatibile = false;
                        //verifico che l'utente inserisca un double
                        try{
                            //leggo altezza
                            altezza = Double.parseDouble(JOptionPane.showInputDialog(null, "Inserire l'altezza del solido", "Inserisci altezza", JOptionPane.QUESTION_MESSAGE));
                            //messaggio di errore in caso di valore non valido
                            if(altezza <= 0.0){
                                JOptionPane.showMessageDialog(null, "ERRORE! Valore non valido" , "Errore" , JOptionPane.ERROR_MESSAGE);
                            }
                        //caso in cui l'utente non digiti un double
                        }catch(NumberFormatException e){
                            incompatibile = true; 
                            JOptionPane.showMessageDialog(null, "ERRORE! Tipo di dato incompatibile", "Dato non compatibile", JOptionPane.ERROR_MESSAGE);
                        }
                    }while((altezza <= 0.0) || (incompatibile = true));
                    //creo oggetto Cilindro
                    Cilindro cilindro = new Cilindro(raggio, altezza, pesoSpecifico);
                    solidi.add(cilindro);
                    break;
                }
                case 2:{

                }
                default:{
                    JOptionPane.showMessageDialog(null, "ERRORE! Opzione inesistente", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
            menu = JOptionPane.showConfirmDialog(null, "Tornare al menu?", "Torna al menu", JOptionPane.YES_NO_OPTION);
        }while(menu == JOptionPane.YES_OPTION);
    }
}
