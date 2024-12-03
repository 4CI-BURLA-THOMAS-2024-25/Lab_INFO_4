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
        caricaDirectory.addActionListener(e -> {
            if(!(path.getText()).isBlank()){
                File directory = new File(path.getText());
            }else{
                JOptionPane.showMessageDialog(null, "ERRORE! Percorso vuoto", "Errore" , JOptionPane.ERROR_MESSAGE);
            }
        });
        
        //carico icona finestra e la imposto
        ImageIcon immagine = new ImageIcon("icona.png");
        Image icona = immagine.getImage();
        finestra.setIconImage(icona);
        
    }
    
}