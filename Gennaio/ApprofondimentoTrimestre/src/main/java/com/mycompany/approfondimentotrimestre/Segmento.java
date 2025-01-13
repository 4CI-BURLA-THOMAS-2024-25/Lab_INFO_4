package com.mycompany.approfondimentotrimestre;

/**
 *
 * @author Thomas Burla
 * @version 1.0
 */
public class Segmento {
    
    //lunghezza
    public static double lunghezzaSegmento(Punto p1, Punto p2){
        double lunghezza, diffX, diffY;
        if((p1 != null) && (p2 != null)){
            //differenza x dei punti
            diffX = p1.getX() - p2.getY();
            //quadrato differenza X
            diffX = Math.pow(diffX, 2);
            //differenza y dei punti
            diffY = p1.getY() - p2.getY();
            //quadrato differenza Y
            diffY = Math.pow(diffY, 2);
            //calcolo lunghezza mediante la radice quadrata
            lunghezza = Math.sqrt(diffX + diffY);
            return lunghezza;
        }
        return -1;
    }
}
