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
            //if((p1.getX() != p2.getX()) && (p1.getY() != p2.getY())){
                //p2 e p3 non coincidono
                //if((p3.getX() != p2.getX()) && (p3.getY() != p2.getY())){
                    //p1 e p3 non coincidono
                    //if((p1.getX() != p3.getX()) && (p1.getY() != p3.getY())){
                        //punti non coincidenti
                        vertici.add(p1);
                        vertici.add(p2);
                        vertici.add(p3);
                        return true;
                    //}
                //}
            //}
        }
        return false;
    }
    
    public void rimuoviVertici(){
        vertici.clear();
    }
    
    //metodo che verifica se un punto dato è interno al triangolo
    public boolean puntoInterno(Punto p){
        if(p != null){
            double area = this.calcolaArea();
            //creo 3 sottotriangoli formati dalla congiunzione tra il punto dato e i 3 vertici del triangolo e calcolo i loro lati
            Triangolo triangolo1 = new Triangolo(this.vertici.get(1), this.vertici.get(2), p);
            Triangolo triangolo2 = new Triangolo(this.vertici.get(2), this.vertici.get(0), p);
            Triangolo triangolo3 = new Triangolo(this.vertici.get(0), this.vertici.get(1), p);
            //calcolo le aree e verifico se la somma di esse è uguale o no all'area del triangolo di partenza
            double area1 = triangolo1.calcolaArea();
            double area2 = triangolo2.calcolaArea();
            double area3 = triangolo3.calcolaArea();
            double areaTotale = area1 + area2 + area3;
            //verifico se l'area totale è diversa dall'area del triangolo di partenza
            if(Math.round(areaTotale) == Math.round(area)){
                return true;
            }
        }
        return false;
    }
    
    //metodo per calcolare la lunghezza dei lati
    public void calcolaLati(){
        lati[0] = Punto.distanzaTraPunti(vertici.get(0), vertici.get(1));
        lati[1] = Punto.distanzaTraPunti(vertici.get(1), vertici.get(2));
        lati[2] = Punto.distanzaTraPunti(vertici.get(2), vertici.get(0));
    }
         
    //metodo per calcolare l'area del triangolo
    public double calcolaArea(){
        //calcolo le distanze tra i vertici per ottenere i lati
        this.calcolaLati();
        //considero come base il lato che congiunge p1 e p2, e per calcolare l'altezza utilizzo la distanza punto-retta tra la base e p3
        double base = lati[0];
        double altezza;
        Retta rettaBase = new Retta();
        //calcolo equazione della retta che contiene la base
        rettaBase.calcolaEquazioneDatiDuePunti(vertici.get(0), vertici.get(1));
        //trasformo l'equazione in implicita
        rettaBase.trasformaInImplicita();
        //calcolo altezza mediante la formula della distanza punto-retta, usando p3
        altezza = rettaBase.distanzaPuntoRetta(vertici.get(2));
        return (base * altezza) / 2.0;
    }
}
    
    