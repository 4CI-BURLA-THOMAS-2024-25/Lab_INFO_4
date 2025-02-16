package view;

/**
 * classe View, che gestisce la GUI del filemanager
 * @author Thomas Burla
 * @version 2.0
 */

//importo classi per la grafica
import java.awt.*;
import javax.swing.*;

public class FileManagerView extends JFrame{
    private JTextField path;
    private JList<JLabel> listaFiles;
    private JButton indietroIcona;
    private JPanel pannelloMain;
    private JPanel pannelloAlto;

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
        pannelloMain = new JPanel(new BorderLayout());

        //creo casella di testa contenente il path della directory di cui visualizzare i file; di default directory dell'utente
        path = new JTextField(System.getProperty("user.home"));
        //creo jlist, utilizzata poi per visualizzare in finestra l'elenco dei file della directory
        listaFiles = new JList<>();
        
        //imposto render personalizzato (Component che decide come visualizzare gli elementi della lista) per visualizzare il contenuto della JList correttamente; creo classe anonima
        listaFiles.setCellRenderer(new ListCellRenderer<JLabel>() {
            //metodo chiamato automaticamente da JList ogni volta che un elemento della lista deve essere disegnato; fornisco lista dell'elemento, elemento da disegnare, posizione nella lista, selezionato si/no, ha focus SI/NO (a noi non interessa)
            @Override
            public Component getListCellRendererComponent(JList<? extends JLabel> lista, JLabel nuovaEtichetta, int indiceLista, boolean selezionata, boolean haFocus) {
                //imposto sfondo opaco, così da poterlo visualizzare
                nuovaEtichetta.setOpaque(true);

                //se la cella è selezionata, sfondo grigio chiaro, altrimenti bianco
                if (selezionata) {
                    nuovaEtichetta.setBackground(Color.LIGHT_GRAY);
                } else {
                    nuovaEtichetta.setBackground(Color.WHITE);
                }

                //restituisco la nuova etichetta
                return nuovaEtichetta;
            }
        });
        //attivo la lista alla ricezione del focus (utilizzato per il corretto funzionamento del KeyAdapter del Control)
        listaFiles.setFocusable(true);
        
        //imposto icona indietro
        ImageIcon iconaOriginale = new ImageIcon("cartellaSuperiore.png");
        //creo immagine scalando l'immagine dell'icona
        Image immagineScalata = (iconaOriginale.getImage()).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        //creo icona con immagine scalata
        ImageIcon iconaScalata = new ImageIcon(immagineScalata);
        //creo etichetta che conterrà l'icona scalata che permette all'utente di andare nella directory di livello superiore a quella attuale
        indietroIcona = new JButton(iconaScalata);
        
        //creo pannello per gestire la parte alta della GUI, con BorderLayout
        pannelloAlto = new JPanel(new BorderLayout());
        //aggiungo casella path al pannello in alto
        pannelloAlto.add(this.path);
        //aggiungo tasto indietro al pannello in alto
        pannelloAlto.add(this.indietroIcona, BorderLayout.WEST);

        //aggiungo in alto nel pannello il sottopannello per gestire la parte alta della GUI
        pannelloMain.add(this.pannelloAlto, BorderLayout.NORTH);
        //aggiungo al centro del pannello la jlist per visualizzare il contenuto della directory, associandovi le barre di scorrimento
        pannelloMain.add(new JScrollPane(listaFiles), BorderLayout.CENTER);
        
        //pannello al contenitore
        contenitore.add(pannelloMain);
        
        //forzo aggiornamento layout
        this.revalidate();
        //ridimensiono finestra
        this.repaint();
        
    }

    //metodo per ottenere path nella casella di testo
    public JTextField getPath(){
        return path;
    }

    //metodo per ottenere jlist di stringhe con i nomi dei files
    public JList<JLabel> getListaFiles(){
        return listaFiles;
    }
    
    //metodo per ottenere l'etichetta che contiene il tasto indietro
    public JButton getIndietroIcona(){
        return indietroIcona;
    }

    //metodo per visualizzare un errore a schermo, passando il messaggio
    public void mostraErrore(String message) {
        JOptionPane.showMessageDialog(this, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    //metodo per aggiornare jlist con una nuova lista di files
    public void aggiornaListaFiles(JLabel[] files){
        //imposta nuova lista
        listaFiles.setListData(files);
        //imposta selezione singola degli elementi della lista visualizzata
        listaFiles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }

    //metodo per otrtnere la finestra
    public JFrame getFinestra(){
        return this;
    }
}
