/**
 * classe Calcolatrice
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class Calcolatrice extends JFrame{
    //variabili d'istanza
    private Container contenitore;
    private JButton bottone;
    private JTextField testo;
    private JPanel pannelloMain;
    private JPanel pannelloNumeri;
    private JPanel pannelloOperatori;
    private JPanel pannelloIntestazione;
    private String display = "";
    private ArrayList <JButton> bottoni;
    private double numero1;
    private double numero2;
    private String operatore;
    private double risultato;
    private JComboBox <String> angoli;
    //costruttore, con nome della finestra
    public Calcolatrice(String nome){
        //invoco costruttore della finestra
        super(nome);
        //azzero le variabili destinate a mostrare il risultato del calcolo
        operatore = "";
        numero1 = 0;
        numero2 = 0;
        risultato = 0;

        //alloco arraylist
        bottoni = new ArrayList <JButton> ();

        //assegno al contenitore il contenitore della finestra JFrame
        contenitore = this.getContentPane();
        //creo pannello principale con BorderLayout
        pannelloMain = new JPanel(new BorderLayout(5, 5));
        //creo pannello intestazione con GridLayout
        pannelloIntestazione = new JPanel(new GridLayout(0, 2, 5, 5));
        //creo pannello secondario dei numeri con GridLayout
        pannelloNumeri = new JPanel(new GridLayout(0, 2, 5 , 5));
        //creo pannello secondario degli operatori con GridLayout
        pannelloOperatori = new JPanel(new GridLayout(0, 2, 5, 5));

        //ciclo per creare i bottoni con i numeri e aggiungerli al pannello
        for(int i = 0; i <= 9; i++){
            //creo bottone con il numero
            bottone = new JButton(Integer.toString(i));
            //associo nuovo ascoltatore al bottone
            bottone.addActionListener(new AscoltatoreNumeri());
            //aggiungo bottone al pannello
            pannelloNumeri.add(bottone);
            //aggiungo bottone alla lista dei bottoni
            bottoni.add(bottone);
        }

        //creo array di stringhe per gli operatori
        String operatori[] = {"+", "-", "*", "/", "^", "root", "sin", "cos", "tan", "arcsin", "arccos", "arctan", "CANC", ".", "="};
        //creo bottoni con gli operatori e li aggiungo al loro pannello
        for(int i = 0; i < operatori.length; i++){
            //creo bottone
            bottone = new JButton(operatori[i]);
            //al bottone del punto associo l'ascoltatore dei numeri, in quanto non attiva alcuna operazione
            if(operatori[i].equals(".")){
                bottone.addActionListener(new AscoltatoreNumeri());
            }else{
                //associo nuovo ascoltatore al bottone
                bottone.addActionListener(new AscoltatoreOperatori());
            }
            //aggiungo bottone al pannello degli operatori
            pannelloOperatori.add(bottone);
            //aggiungo bottone alla lista dei bottoni
            bottoni.add(bottone);
        }

        //creo casella di testo per mostrare quello digitato
        testo = new JTextField(50);
        //rendo la casella di testo non modificabile dall'utente essendo che deve servire solo a mostrare i pulsanti cliccati
        testo.setEditable(false);
        //aggiungo casella di testo al pannello
        pannelloIntestazione.add(testo, BorderLayout.NORTH);

        //creo combobox per far scegliere all'utente l'unità di misura degli angoli
        String unitaMisura[] = {"gradi", "radianti"};
        angoli = new JComboBox <String> (unitaMisura);
        //aggiungo combobox al pannello principale
        pannelloIntestazione.add(angoli, BorderLayout.NORTH);

        //aggiungo il pannello dei numeri con GridLayout al pannello principale, al centro
        pannelloMain.add(pannelloNumeri, BorderLayout.CENTER);
        //aggiungo il pannello degli operatori con GridLayout al pannello principale, a destra
        pannelloMain.add(pannelloOperatori, BorderLayout.EAST);
        //aggiungo il pannello intestazione con GridLayout al pannello principale, in alto
        pannelloMain.add(pannelloIntestazione, BorderLayout.NORTH);
        //aggiungo pannello al contenitore
        contenitore.add(pannelloMain);

        //imposto dimensione finestra
        this.setSize(500, 600);
        //carico icona finestra
        ImageIcon icon = new ImageIcon("icon.png");
        Image image = icon.getImage();
        //imposto icona
        this.setIconImage(image);
        //imposto finestra visibile
        this.setVisible(true);
        //imposto chiusura finestra
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public class AscoltatoreNumeri implements ActionListener{
        //implemento metodo
        public void actionPerformed(ActionEvent e){
            //ottengo testo del bottone così da sapere quale numero è stato cliccato
            String comando = e.getActionCommand();
            //aggiorno testo associato al display
            display += comando;
            //aggiorno testo visualizzato sul display
            testo.setText(display);
        }
    }
    public class AscoltatoreOperatori implements ActionListener{
        //creo variabile statica (identica per tutte le istanze) in cui salvo l'indice di inizio del numero2
        private static int inizioNumero2;
        //implemento metodo
        public void actionPerformed(ActionEvent e){
            //ottengo testo del bottone così da sapere quale numero è stato cliccato
            String comando = e.getActionCommand();
            //se viene cliccato il tasto di una delle 4 operazioni, significa che è stato digitato il primo numero per intero
            if((comando.equals("+")) || (comando.equals("-")) || (comando.equals("*")) || (comando.equals("/")) || (comando.equals("^")) || (comando.equals("root"))){
                //assegno al primo numero il valore visualizzato sul display, se è stato inserito un valore; altriemnti assegno 0
                if(display.length() > 0){
                    numero1 = Double.parseDouble(display);
                }else{
                    numero1 = 0.0;
                }
        
                //salvo operatore
                operatore = comando;
                //aggiorno testo associato al display
                display += comando;
                //salvo la lunghezza complessiva del numero1 concatenato all'operatore, che costituira l'inizio del numero2
                inizioNumero2 = display.length();
                //aggiorno testo visualizzato sul display
                testo.setText(display);

            //caso in cui si vuole cancellare l'ultimo carattere
            }else if(comando.equals("CANC")){
                //creo nuova stringa, senza l'ultimo carattere del display, che viene cancellato
                String stringaAggiornata = display.substring(0, (display.length() - 1));
                //aggiorno testo associato al display
                display = stringaAggiornata;
                //aggiorno testo visualizzato sul display
                testo.setText(display);

            //caso in cui si clicca uguale per ottenere il risultato
            }else if((comando.equals("="))){
                //variabile locale per gestire il caso in cui si divida per 0 o si indichi 0 come indice della radice
                boolean errore = false;
                //se clicco uguale, significa che il secondo numero è stato interamente digitato, e sul display si trova a seguito dell'operatore
                //creo variabile locale in cui salvo il numero2 estratto dal display, che poi sarà convertito in double
                String estraggoNumero2 = "";
                //ciclo per estrarre dal display il numero2
                for(int i = 0; i < (display.length() - inizioNumero2); i++){
                    estraggoNumero2 += display.charAt(inizioNumero2 + i);
                }
                //converto il numero2 estratto dal diplay in double, se è stato effettivamente inserito
                if(!(estraggoNumero2.isEmpty())){
                    numero2 = Double.parseDouble(estraggoNumero2);
                }

                //calcolo risultato
                switch(operatore){
                    case "+":{
                        risultato = numero1 + numero2;
                        break;
                    }
                    case "-":{
                        risultato = numero1 - numero2;
                        break;
                    }
                    case "*":{
                        risultato = numero1 * numero2;
                        break;
                    }
                    case "/":{
                        //gestisco caso di divisione per 0
                        if(numero2 == 0){
                            errore = true;
                        }else{
                            risultato = numero1 / numero2;
                        }
                        break;
                    }
                    case "^":{
                        risultato = Math.pow(numero1, numero2);
                        break;
                    }
                    case "root":{
                        //gestisco caso di radice con indice 0
                        if(numero2 == 0){
                            errore = true;
                        }else{
                            risultato = Math.pow(numero1, 1.0 / numero2);
                        }
                        break;
                    }
                }
                
                //aggiorno testo associato al display, gestendo il caso di errore
                if(errore == false){
                    display = Double.toString(risultato);
                }else{
                    display = "ERRORE matematico! Controlla di aver inserito i valori e gli operatori correttamente";
                }
                
                //aggiorno testo visualizzato sul display
                testo.setText(display);
            }
        }
    }
}