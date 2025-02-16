package model;

/**
 * classe Model del filemanager
 * 
 * @author Thomas Burla
 * @version 3.0
 */
 
//importo libreria per usare i file
import java.io.*;
//importo liberia per usare desktop
import java.awt.Desktop;
//importo libreria per creare la lista delle icone dei files di una directory
import javax.swing.Icon;
//importo package per ottenere l'icona dell'app predefinita associata a ciascun file
import javax.swing.filechooser.*;

public class FileManagerModel{
    //metodo per ottenere l'array con i nomi dei files, in grado di lanciare eccezioni IOException
    public String[] ottieniFiles(String path) throws IOException {
        //associo parametro path a una nuova directory
        File directory = new File(path);
        //controllo che la directory sia tale, altrimenti lancio eccezione
        if (!directory.isDirectory()) {
            throw new IOException("Il percorso non indica una directory valida.");
        }
        
        //creo array di stringhe con i nomi dei files
        String[] files = directory.list();
        //se l'array ha puntatorer nullo (e quindi non è stato possibile crearlo), lancio eccezione
        if (files == null) {
            throw new IOException("Errore di accesso alla directory.");
        }
        
        //se l'array è vuoto, e cioè la directory non contiene elementi, restituisco array con messaggio
        if(files.length == 0){
            return new String[]{"Nessun file nella directory"};
        }
        return files;
    }
    
    //metodo per ottenere un array con le icone di tutti i files di una determinata directory
    public Icon[] ottieniIconeFiles(String path) throws IOException{
        //ottengo l'elenco di tutti i files di un path
        String[] listaFiles = ottieniFiles(path);
        //elenco delle icone dei files
        Icon[] listaIconeFiles = new Icon[listaFiles.length];
        //ciclo per ottenere l'icona di ogni file
        for(int i = 0; i < listaFiles.length; i++){
            //metodo per ottenere l'oggetto Icon associato allo specifico file, applicato sull'istanza FileSystemView ottenuta dal metodo statico che permette di accedere alle informazioni sul file system
            listaIconeFiles[i] = FileSystemView.getFileSystemView().getSystemIcon(new File(listaFiles[i]));
        }
        //restituisco array delle icone dei files
        return listaIconeFiles;
    }
    
    //metodo per aprire i files, in grado di lanciare IOException
    public void apriFile(String path) throws IOException {
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