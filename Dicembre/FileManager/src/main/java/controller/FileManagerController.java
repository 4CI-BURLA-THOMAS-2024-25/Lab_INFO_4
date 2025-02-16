package controller;

/**
 * classe Controller che "collega" tra loro classe view e model
 * 
 * @author Thomas Burla
 * @version 2.0
 */

//importo gestore eventi
import model.FileManagerModel;
import view.FileManagerView;
import java.awt.event.*;
import java.awt.Point;
import java.io.*;

//importo etichette per gestire i files di una directory
import javax.swing.JLabel;

public class FileManagerController {
    //creo oggetto model
    private final FileManagerModel model;
    //creo oggetto view
    private final FileManagerView view;
    //opggetto utilizzato per passare la posizione del mouse registrata da MouseAdapter al KyeAdapter, nel caso di un singolo click
    Point posizioneMouse  = new Point();
    
    //costruttore che assegna classe model e classe view all'istanza di filemanager avviata
    public FileManagerController(FileManagerModel model, FileManagerView view){
        //assegno model
        this.model = model;
        //assegno parte grafica
        this.view = view;
        
        //evoco metodo per inizializzare l'oggetto
        this.inizializza();
    }

    //metodo che inizializza l'istanza di file manager
    private void inizializza() {

        //assegno alla lista dei files l'ascoltatore MouseAdapter, che non richiede l'implementazione di tutti i metodi di MuoseListener, 
        view.getListaFiles().addMouseListener(new MouseApriFile());
        
        //assegno al campo di testo del path l'ascoltatore KeyAdapter per caricare il contenuto di una directory o visualizzare un file quando viene premuto il tasto INVIO sulla tastiera e il campo di testo è selezionato
        view.getPath().addKeyListener(new TastieraCaricaPath());
        
        //assegno alla lista dei files l'ascoltatore KeyAdapter per aprire il file/la directory selezionato alla pressione del tasto INVIO sulla tastiera
        view.getListaFiles().addKeyListener(new TastieraApriFile());
        
        //assegno all'etichetta che contiene il tasto indietro il suo ascoltatore
        view.getIndietroIcona().addActionListener(new CaricaDirectorySuperiore());
    }

    private void caricaDirectory() {
        //prelevo path
        String path = view.getPath().getText();
        
        //gestisco errori di I/O
        try {
            //ottengo dalla classe model l'array che contiene i nomi dei files della directory da visualizzare e le rispettive icone
            JLabel[] files = model.ottieniFiles(path);
            //chiamo metodo della classe grafica per aggiornare la lista dei files visualizzati
            view.aggiornaListaFiles(files);
        //in caso di errori di I/O, "passo" il testo dell'errore al metodo della classe grafica che si occuperà di visualizzarlo
        } catch (IOException ex) {
            view.mostraErrore(ex.getMessage());
        }
        
    }

    //metodo per gestire la selezione di un file, dato l'elemento selezionato
    private void gestisciFileSelezionato(String elementoSelezionato){
        //prelevo path
        String path = view.getPath().getText();
        //creo oggetto a cui assegno il file selezionato, il cui nome è ottenuto combinando il path della directory attuale e quello del file selezionato nella lista
        File fileSelezionato = new File(path, elementoSelezionato);

        //verifico se il file selezionato è una directory
        if(fileSelezionato.isDirectory()) {
            //aggiorno path con il percorso assoluto della directory aperta
            view.getPath().setText(fileSelezionato.getAbsolutePath());
            //chiamo metodo per visualizzare il contenuto della nuova cartella
            this.caricaDirectory();
        //se invece si è selezionato un file...
        }else{
            
            //gestisco errori di I/O
            try {
                //chiamo metodo del model per aprire il file
                model.apriFile(fileSelezionato.getAbsolutePath());
            //in caso di errore di I/O, "passo" il testo dell'errore al metodo della classe grafica che si occuperà di visualizzarlo
            } catch (IOException ex) {
                view.mostraErrore("Impossibile aprire il file: " + ex.getMessage());
            }
            
        }
        
    }

    //ascoltatore della tastiera per aprire un file selezionato con INVIO
    private class TastieraApriFile extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            //verifiuco che la stastiera abbia il focus per poter reagire alla pressione dei tasti
            if(view.getListaFiles().hasFocus()){

                //controllo che sia stato premuto il tasto invio
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    //ottengo le coordinate del punto cliccato e le trasformo in un intero, corrispondente all'indice dell'elemento della lista selezionato
                    int indice = view.getListaFiles().locationToIndex(posizioneMouse);

                    //controllo che l'indice sia un numero accettabile, ovvero che il doppio click sia avvenuto su un elemento della lista
                    if (indice != -1) {
                        //prelevo l'elemento di indice indicato dal modello di dati della JList, che contiene tutti i dati di tale lista; prelevo testo della Label
                        String elementoSelezionato = (((view.getListaFiles()).getModel()).getElementAt(indice)).getText();
                        //chiamo metodo della classe controller che si occupa di gestire le operazioni da effettuare con il file selezionato
                        gestisciFileSelezionato(elementoSelezionato);
                    }

                }
            }
        }
    }
    
    //ascoltatore del mouse per aprire un file con il doppio click o selezionarlo con il singolo click
    private class MouseApriFile extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent clickMouse) {
            //controllo che il contatore dei click effettuati sia pari a 2
            if (clickMouse.getClickCount() == 2) {
                //ottengo le coordinate del punto cliccato e le trasformo in un intero, corrispondente all'indice dell'elemento della lista selezionato
                int indice = view.getListaFiles().locationToIndex(clickMouse.getPoint());

                //controllo che l'indice sia un numero accettabile, ovvero che il doppio click sia avvenuto su un elemento della lista
                if (indice != -1) {
                    //prelevo l'elemento di indice indicato dal modello di dati della JList, che contiene tutti i dati di tale lista; prelevo testo della Label
                        String elementoSelezionato = (((view.getListaFiles()).getModel()).getElementAt(indice)).getText();
                    //chiamo metodo della classe controller che si occupa di gestire le operazioni da effettuare con il file selezionato
                    gestisciFileSelezionato(elementoSelezionato);
                }
            //quando viene effettuato un click singolo su un elemento, assegno il focus della alla lista così da poter aprire il file/directory selezionato con il tasto INVIO
            }else if (clickMouse.getClickCount() == 1){
                //richiedo che venga passato il focus alla lista dei files
                view.getListaFiles().requestFocus();
                //salvo posizione del mouse, utilizzata poi per ottenere l'indice della lista
                posizioneMouse.setLocation(clickMouse.getX(), clickMouse.getY());
            }
        }
    }
    
    //ascoltatore per caricare il contenuto di una directory quando si digita il path nel campo e si preme invio
    private class TastieraCaricaPath extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            //controllo che sia stato premuto il tasto invio
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                //chiamo metodo per visualizzare la nuova directory/il nuovo file
                caricaDirectory();
            }
        }
    }
    
    //ascoltatore per andare alla directory superiore 
    private class CaricaDirectorySuperiore implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //creo oggetto File che rtappresenta la directory attuale
            File directoryAttuale = new File(view.getPath().getText());
            //aggiorno path della GUI con quello della directory superiore
            view.getPath().setText(directoryAttuale.getParent());
            //chaimo metodo per visualizzare la directory superiore
            caricaDirectory();
        }
    }
}