package com.thomasburla.filemanager;

/**
 * classe FileManager, con interfaccia grafica, per operare con i file
 * 
 * @author Thomas Burla
 * @version 1.0
 */

//importo librerie grafiche
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//importo librerie di I/O
import java.io.*;

public class FileManager{
    public static void main(String args[]){
        
        //creo finestra
        JFrame finestra = new JFrame("File Manager");
        //imposto dimensione finestra
        finestra.setSize(900, 1200);
        //imposto uscita alla chiusura
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //imposto visibilità della finestra
        finestra.setVisible(true);
        
        //creo pannello
        JPanel pannello = new JPanel(new BorderLayout());
        //creo oggetto jlist per la visualizzazione grafica di un array, non modificabile
        JList<String> listaFiles = new JList <> ();
        //creo campo di testo in cui l'utente può inserire il percorso da visualizzare; di base, è impostata la home dell'utente
        JTextField path = new JTextField(System.getProperty("user.home"));
        //creo bottone che, quando cliccato permette di visualizzare il contenuto della directory di cui è dato il path nel campo di testo
        JButton caricaDirectory = new JButton("Vai");
       
        //aggiungo ascoltatore al bottone
        caricaDirectory.addActionListener(e -> {
            //controllo che il path non sia vuoto
            if(!(path.getText()).isBlank()){
                //creo oggetto directory, di cui è fornito il path
                File directory = new File(path.getText());
                
                //controllo che il path fornito indichi effettivamente una directory
                if(directory.isDirectory()){
                    //array che conterrà i files della directory da visualizzare
                    String[] files = directory.list();
                    
                    //controllo che non vi siano stati errori di I/O (altrimenti l'array avrebbe riferimento null)
                    if(files != null){
                        
                        //gestisco caso di directory vuota
                        if(files.length != 0){
                            //assegno array dei files a jlist per la visualizzazione grafica del contenuto della directory
                            listaFiles.setListData(files);
                        }else{
                            String[] vuota = {"Nessun file nella directory"};
                            listaFiles.setListData(vuota);
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(finestra, "ERRORE! Directory vuota o non accessibile", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                    
                //il path non indica una directory    
                }else{
                    JOptionPane.showMessageDialog(finestra, "ERRORE! Directory NON valida", "Errore", JOptionPane.ERROR_MESSAGE);
                }
                
            //nessun path fornito
            }else{
                JOptionPane.showMessageDialog(finestra, "ERRORE! Percorso vuoto", "Errore" , JOptionPane.ERROR_MESSAGE);
            }
        });
        
        //aggiungo campo path al pannello, in alto
        pannello.add(path, BorderLayout.NORTH);
        //aggiungo jlist della lista files al pannello, aggiungendo le barre di scorrimento laterale e posizionandola al centro
        pannello.add(new JScrollPane(listaFiles), BorderLayout.CENTER);
        //aggiungo bottone, in basso
        pannello.add(caricaDirectory, BorderLayout.SOUTH);
        
        //aggiungo pannello alla finestra
        finestra.add(pannello);
        
        //carico icona finestra e la imposto
        ImageIcon immagine = new ImageIcon("icona.png");
        Image icona = immagine.getImage();
        finestra.setIconImage(icona);
        
    }
    
}