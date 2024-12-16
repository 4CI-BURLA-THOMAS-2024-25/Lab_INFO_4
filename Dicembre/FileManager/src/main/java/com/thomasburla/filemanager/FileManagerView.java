/**
 * classe View, che gestisce la GUI del filemanager
 * @author 20164
 */

//importo classi per la grafica
import java.awt.*;
import javax.swing.*;

public class FileManagerView extends JFrame{
    private JTextField path;
    private JList<String> listaFiles;
    private JButton caricaDirectory;

    public FileManagerView(){
        //imposto titolo finestra
        this.setTitle("File Manager");
        //imposto dimensione finestra
        this.setSize(500, 800);
        //imposto uscita alla chiusura della finestra
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //imposto icona
        this.setIconImage(new ImageIcon("icona.png").getImage());
        //imposto visibilità della finestra
        this.setVisible(true);

        //creo contenitore e vi asssegno il contenuto della finestra principale
        Container contenitore = this.getContentPane();
        //creo pannello con borderlayout
        JPanel panel = new JPanel(new BorderLayout());

        //creo casella di testa contenente il path della directory di cui visualizzare i file; di default directory dell'utente
        path = new JTextField(System.getProperty("user.home"));
        //creo jlist, utilizzata poi per visualizzare in finestra l'elenco dei file della directory
        listaFiles = new JList<>();
        //creo bottone per caricare il contenuto
        caricaDirectory = new JButton("Vai");

        //aggiungo in alto nel pannello la casella del path
        panel.add(this.path, BorderLayout.NORTH);
        //aggiungo al centro del pannello la jlist per visualizzare il contenuto della directory, associandovi le barre di scorrimento
        panel.add(new JScrollPane(listaFiles), BorderLayout.CENTER);
        //aggiungo al pannello, in basso, il bottone per caricare il contenuto
        panel.add(caricaDirectory, BorderLayout.SOUTH);
        
        //pannello al contenitore
        contenitore.add(panel);
        
    }

    //metodo per ottenere path nella casella di testo
    public JTextField getPathField(){
        return path;
    }

    //metodo per ottenere jlist di stringhe con i nomi dei files
    public JList<String> getFileList(){
        return listaFiles;
    }

    //metodo per ottnere bottone per caricare contenuto
    public JButton getLoadButton(){
        return caricaDirectory;
    }

    //metodo per visualizzare un errore a schermo, passando il messaggio
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    //metodo per aggiornare jlist con una nuova lista di files
    public void updateFileList(String[] files){
        //imposta nuova lista
        listaFiles.setListData(files);
        //imposta selezione singola degli elementi della lista visualizzata
        listaFiles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    //metodo per otrtnere la finestra
    public JFrame getFrame(){
        return this;
    }
}
