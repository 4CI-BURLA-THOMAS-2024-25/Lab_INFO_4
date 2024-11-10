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
    private JPanel pannello;
    //costruttore, con nome della finestra
    public Calcolatrice(String nome){
        //invoco costruttore della finestra
        super(nome);
        //assegno al contenitore il contenitore della finestra JFrame
        contenitore = this.getContentPane();
        //creo pannello
        pannello = new JPanel();
        //imposto layout
        pannello.setLayout(new BorderLayout());
        //ciclo per creare i bottoni con i numeri e aggiungerli al pannello
        for(int i = 0; i <= 9; i++){
            //creo bottone con il numero
            bottone = new JButton(Integer.toString(i));
            //aggiungo bottone al pannello
            pannello.add(bottone, BorderLayout.CENTER);
        }
        //creo bottone per la somma e lo aggiungo al pannello
        bottone = new JButton("+");
        //aggiugno bottone al pannello
        pannello.add(bottone, BorderLayout.CENTER);
        //creo bottone per la sottrazione e lo aggiungo al pannello
        bottone = new JButton("-");
        //aggiugno bottone al pannello
        pannello.add(bottone, BorderLayout.CENTER);
        //creo bottone per la moltiplicazione e lo aggiungo al pannello
        bottone = new JButton("*");
        //aggiugno bottone al pannello
        pannello.add(bottone, BorderLayout.CENTER);
        //creo bottone per la divisione e lo aggiungo al pannello
        bottone = new JButton("/");
        //aggiugno bottone al pannello
        pannello.add(bottone, BorderLayout.CENTER);
        //creo bottone per la cancellare e lo aggiungo al pannello
        bottone = new JButton("CANC");
        //aggiugno bottone al pannello
        pannello.add(bottone, BorderLayout.CENTER);
        //creo bottone punto e lo aggiungo al pannello
        bottone = new JButton(".");
        //aggiugno bottone al pannello
        pannello.add(bottone, BorderLayout.CENTER);
        //creo bottone uguale e lo aggiungo al pannello
        bottone = new JButton("=");
        //aggiugno bottone al pannello
        pannello.add(bottone, BorderLayout.CENTER);
        //creo casella di testo per mostrare quello digitato
        testo = new JTextField(50);
        //aggiungo casella di testo al pannello
        pannello.add(testo, BorderLayout.NORTH);
        //aggiungo pannello al contenitore
        contenitore.add(pannello);
        //imposto dimensione finestra
        this.setSize(500, 1000);
        //imposto finestra visibile
        this.setVisible(true);
        //imposto chiusura finestra
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}