package com.thomasburla.filemanager;

/**
 * classe Controller che "collega" tra loro classe view e model
 * 
 * @author Thomas Burla
 */

//importo gestore eventi
import java.awt.event.*;
import java.io.*;

public class FileManager {
    //creo oggetto model
    private FileManagerModel model;
    //creo oggetto view
    private FileManagerView view;
    
    //costruttore che assegna classe model e classe view all'istanza di filemanager avviata
    public FileManager(FileManagerModel model, FileManagerView view){
        //assegno model
        this.model = model;
        //assegno parte grafica
        this.view = view;
        
        //evoco metodo per inizializzare l'oggetto
        this.inizializza();
    }

    //metodo che inizializza l'istanza di file manager
    private void inizializza() {
        //assegno ascoltatore al bottone per visualizzare il contenuto della directory di cui è indicato il path e chiamo metodo per caricare directory
        view.getCaricaDirectory().addActionListener(e -> caricaDirectory());

        //assegno alla lista dei files l'ascoltatore MouseAdapter, che non richiede l'implementazione di tutti i metodi di MuoseListener, 
        view.getListaFiles().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //controllo che il contatore dei click effettuati sia pari a 2
                if (e.getClickCount() == 2) {
                    //ottengo le coordinate del punto cliccato e le trasformo in un intero, corrispondente all'indice dell'elemento della lista selezionato
                    int indice = view.getListaFiles().locationToIndex(e.getPoint());
                    
                    //controllo che l'indice sia un numero accettabile, ovvero che il doppio click sia avvenuto su un elemento della lista
                    if (indice != -1) {
                        //prelevo l'elemento di indice indicato dal modello di dati della JList, che contiene tutti i dati di tale lista
                        String elementoSelezionato = ((view.getListaFiles()).getModel()).getElementAt(indice);
                        //chiamo metodo della classe controller che si occupa di gestire le operazioni da effettuare con il file selezionato
                        gestisciFileSelezionato(elementoSelezionato);
                    }
                }
            }
        });
        
        //assegno al campo di testo del path l'ascoltatore KeyAdapter per caricare il contenuto di una directory o visualizzare un file quando viene premuto il tasto INVIO sulla tastiera e il campo di testo è selezionato
        view.getPath().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                //controllo che sia stato premuto il tasto invio
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    //chiamo metodo per visualizzare la nuova directory/il nuovo file
                    caricaDirectory();
                }
            }
        });
        
        
    }

    
    private void caricaDirectory() {
        //prelevo path
        String path = view.getPath().getText();
        
        //gestisco errori di I/O
        try {
            //ottengo dalla classe model l'array che contiene i nomi dei files della directory da visualizzare
            String[] files = model.ottieniFiles(path);
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

    //metodo main, che crea model e view e le assegna al controller per la gestione
    public static void main(String[] args) {
        //creo oggetto di classe Model
        FileManagerModel model = new FileManagerModel();
        
        //creo oggetto di classe View
        FileManagerView view = new FileManagerView();
        
        //creo oggetto di classe Controller che unisce i primi due
        new FileManager(model, view);
    }
}