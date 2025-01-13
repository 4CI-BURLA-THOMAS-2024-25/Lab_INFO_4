package com.mycompany.approfondimentotrimestre;

/**
 * classe Triangolo con una lista di Punto, ovvero i suoi vertici
 * 
 * @author 20164
 */

import java.util.ArrayList; 

public class Triangolo {
    //attributi
    private ArrayList <Punto> vertici;
    private double[] lati;
    
    //costruttori
    public Triangolo(){
        vertici = new ArrayList();
        lati = new double[3];
    }
    
    public Triangolo(Punto p1, Punto p2, Punto p3){
        this();
        this.aggiungiVertici(p1, p2, p3);
    }
    
    public boolean aggiungiVertici(Punto p1, Punto p2, Punto p3){
        if((p1 != null) && (p2 != null) && (p3 != null)){
            //controllo che i punti non coincidano
            //p1 e p2 non coincidono
            if((p1.getX() != p2.getX()) && (p1.getY() != p2.getY())){
                //p2 e p3 non coincidono
                if((p3.getX() != p2.getX()) && (p3.getY() != p2.getY())){
                    //p1 e p3 non coincidono
                    if((p1.getX() != p3.getX()) && (p1.getY() != p3.getY())){
                        //punti non coincidenti
                        vertici.add(p1);
                        vertici.add(p2);
                        vertici.add(p3);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void rimuoviVertici(){
        vertici.clear();
    }
    
    //metodo che verifica se un punto dato è interno al triangolo
    public boolean puntoInterno(Punto p){
        if(p != null){
            //creo 3 sottotriangoli formati dalla congiunzione tra il punto dato e in 3 vertici del triangolo e calcolo i loro lati
            Triangolo triangolo1 = new Triangolo(vertici.get(1), vertici.get(2), p);
            triangolo1.calcolaLati();
            Triangolo triangolo2 = new Triangolo(vertici.get(2), vertici.get(0), p);
            triangolo2.calcolaLati();
            Triangolo triangolo3 = new Triangolo(vertici.get(1), vertici.get(0), p);
            triangolo3.calcolaLati();
            
            
        }
        return false;
    }
    
    public void calcolaLati(){
        lati[0] = Segmento.lunghezzaSegmento(vertici.get(0), vertici.get(1));
        lati[1] = Segmento.lunghezzaSegmento(vertici.get(1), vertici.get(2));
        lati[2] = Segmento.lunghezzaSegmento(vertici.get(2), vertici.get(0));
    }
    
    public double calcolaArea(){
        
    }
}
    
    
