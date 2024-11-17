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
    private String display = "";
    private ArrayList <JButton> bottoni;
    private double numero1;
    private double numero2;
    private String operatore;
    private double risultato;
    //costruttore, con nome della finestra
    public Calcolatrice(String nome){
        //invoco costruttore della finestra
        super(nome);
        //alloco arraylist
        bottoni = new ArrayList <JButton> ();
        //assegno al contenitore il contenitore della finestra JFrame
        contenitore = this.getContentPane();
        //creo pannello principale con BorderLayout
        pannelloMain = new JPanel(new BorderLayout(5, 5));
        //creo pannello secondario dei numeri con GridLayout
        pannelloNumeri = new JPanel(new GridLayout(0, 2, 5 , 5));
        //creo pannello secondario degli operatori con GridLayout
        pannelloOperatori = new JPanel(new GridLayout(0, 1, 5, 5));
        //ciclo per creare i bottoni con i numeri e aggiungerli al pannello
        for(int i = 0; i <= 9; i++){
            //creo bottone con il numero
            bottone = new JButton(Integer.toString(i));
            //associo nuovo ascoltatore al bottone
            bottone.addActionListener(new AscoltatoreNumeri());
            //aggiungo bottone al pannello
            pannelloNumeri.add(bottone);
            //aaggiungo bottone alla lista dei bottoni
            bottoni.add(bottone);
        }
        //creo array di stringhe per gli operatori
        String operatori[] = {"+", "-", "*", "/", "CANC", ".", "="};
        //creo bottoni con gli operatori e li aggiungo al loro pannello
        for(int i = 0; i < operatori.length; i++){
            //creo bottone
            bottone = new JButton(operatori[i]);
            //associo nuovo ascoltatore al bottone
            bottone.addActionListener(new AscoltatoreOperatori());
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
        pannelloMain.add(testo, BorderLayout.NORTH);
        //aggiungo il pannello dei numeri con GridLayout al pannello principale, al centro
        pannelloMain.add(pannelloNumeri, BorderLayout.CENTER);
        //aggiungo il pannello degli operatori con GridLayout al pannello principale, a destra
        pannelloMain.add(pannelloOperatori, BorderLayout.EAST);
        //aggiungo pannello al contenitore
        contenitore.add(pannelloMain);
        //imposto dimensione finestra
        this.setSize(500, 600);
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
        //implemento metodo
        public void actionPerformed(ActionEvent e){
            //ottengo testo del bottone così da sapere quale numero è stato cliccato
            String comando = e.getActionCommand();
            if((comando.equals("+")) || (comando.equals("-")) || (comando.equals("*")) || (comando.equals("/"))){
                //assegno al primo numero il valolre visualizzato sul display
                numero1 = Double.parseDouble(display);
                operatore = comando;
                //aggiorno testo associato al display
                display += comando;
                //aggiorno testo visualizzato sul display
                testo.setText(display);
            }
            else if((comando.equals("=")) && (numero2 != 0)){
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
                        risultato = numero1 / numero2;
                        break;
                    }
                }
                //aggiorno testo associato al display
                display = Double.toString(risultato);
                //aggiorno testo visualizzato sul display
                testo.setText(display);
                
            }
        }
    }
}