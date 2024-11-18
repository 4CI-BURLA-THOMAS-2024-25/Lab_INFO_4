/**
 * 
 * @author Thomas Burla
 */
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
public class GraficaAscoltatori extends JFrame implements ActionListener{
    private JButton bottone;
    private JLabel etichetta;
    private JPanel pannello;
    private Container contenitore;
    private String stringa = "";
    public GraficaAscoltatori(String nome){
        super(nome);
        pannello = new JPanel(new BorderLayout());
        bottone = new JButton("clicca");
        etichetta = new JLabel("etichetta");
        bottone.addActionListener(this);
        pannello.add(bottone, BorderLayout.CENTER);
        pannello.add(etichetta, BorderLayout.NORTH);
        contenitore = this.getContentPane();
        contenitore.add(pannello);
        this.setSize(200, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //
    public void actionPerformed(ActionEvent e){
        stringa += "1";
        etichetta.setText(stringa);
    }
}

