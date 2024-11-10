/**
 * classe Calcolatrice
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
public class Calcolatrice extends JFrame{
    //variabili d'istanza
    private Container contenitore;
    private JButton bottone;
    private JTextField testo;
    private JPanel pannelloMain;
    private JPanel pannelloNumeri;
    private JPanel pannelloOperatori;
    //costruttore, con nome della finestra
    public Calcolatrice(String nome){
        //invoco costruttore della finestra
        super(nome);
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
            //aggiungo bottone al pannello
            pannelloNumeri.add(bottone, BorderLayout.CENTER);
        }
        //creo bottone per la somma e lo aggiungo al pannello
        bottone = new JButton("+");
        //aggiugno bottone al pannello
        pannelloOperatori.add(bottone, BorderLayout.CENTER);
        //creo bottone per la sottrazione e lo aggiungo al pannello
        bottone = new JButton("-");
        //aggiugno bottone al pannello
        pannelloOperatori.add(bottone, BorderLayout.CENTER);
        //creo bottone per la moltiplicazione e lo aggiungo al pannello
        bottone = new JButton("*");
        //aggiugno bottone al pannello
        pannelloOperatori.add(bottone, BorderLayout.CENTER);
        //creo bottone per la divisione e lo aggiungo al pannello
        bottone = new JButton("/");
        //aggiugno bottone al pannello
        pannelloOperatori.add(bottone, BorderLayout.CENTER);
        //creo bottone per la cancellare e lo aggiungo al pannello
        bottone = new JButton("CANC");
        //aggiugno bottone al pannello
        pannelloOperatori.add(bottone, BorderLayout.CENTER);
        //creo bottone punto e lo aggiungo al pannello
        bottone = new JButton(".");
        //aggiugno bottone al pannello
        pannelloOperatori.add(bottone, BorderLayout.CENTER);
        //creo bottone uguale e lo aggiungo al pannello
        bottone = new JButton("=");
        //aggiugno bottone al pannello
        pannelloOperatori.add(bottone, BorderLayout.CENTER);
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
}