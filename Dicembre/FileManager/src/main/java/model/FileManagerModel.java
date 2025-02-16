package model;

/**
 * classe Model del filemanager
 * 
 * @author Thomas Burla
 * @version 4.0
 */
 
//importo libreria per usare i file
import java.io.*;
//importo liberia per usare desktop
import java.awt.Desktop;
//importo libreria grafica
import javax.swing.*;
//importo package per gestire le icone dei files
import javax.swing.filechooser.*;
//importo arraylist per memorizzare la cronologia dei percorsi visitati
import java.util.ArrayList;

public class FileManagerModel{
    private ArrayList<String> cronologia;
    
    //costruttore
    public FileManagerModel(){
        this.cronologia = new ArrayList<String>();
    }
    
    //get cronologia
    public ArrayList<String> getCronologia(){
        return this.cronologia;
    }
    
    //metodo per ottenere array di Label con i nomi dei files e le rispettive icone, in grado di lanciare eccezioni IOException
    public static JLabel[] ottieniFiles(String path) throws IOException {
        Icon iconaFile;
        //associo parametro path a una nuova directory
        File directory = new File(path);
        //controllo che la directory sia tale, altrimenti lancio eccezione
        if (!directory.isDirectory()) {
            throw new IOException("Il percorso non indica una directory valida.");
        }
        
        //creo array con i files della directory
        File[] files = directory.listFiles();
        //creo lista delle Label per l'output
        JLabel[] filesIcone = new JLabel[files.length];
        //se l'array ha puntatorer nullo (e quindi non è stato possibile crearlo), lancio eccezione
        if (files == null) {
            throw new IOException("Errore di accesso alla directory.");
        }
        
        //se l'array è vuoto, e cioè la directory non contiene elementi, restituisco array con messaggio
        if(files.length == 0){
            //
        }
        
        //per ogni file, creo una Label che contiene il suo nome e la sua icona
        for(int i = 0; i < filesIcone.length; i++){
            //metodo per ottenere l'oggetto Icon associato allo specifico file, applicato sull'istanza FileSystemView ottenuta dal metodo statico che permette di accedere alle informazioni sul file system
            iconaFile = FileSystemView.getFileSystemView().getSystemIcon(files[i]);
            //creo Label con nome del file e icona, allineati a sinistra
            filesIcone[i] = new JLabel(files[i].getName(), iconaFile, JLabel.LEFT);
        }
        return filesIcone;
    }
    
    //metodo per aprire i files, in grado di lanciare IOException
    public static void apriFile(String path) throws IOException {
        //creo oggetto file con il path ricevuto come parametro
        File file = new File(path);
        
        //controllo che il desktop sia supportato
        if (Desktop.isDesktopSupported()) {
            //apro file
            Desktop.getDesktop().open(file);
        //se non lo è, lancio eccezione
        } else {
            throw new IOException("Desktop non supportato o programma non disponibile.");
        }
    }
}