package com.mycompany.approfondimentotrimestre;

/**
 *
 * @author Thomas Burla
 * @version 1.0
 */
public class Retta {
    //attributi
    private double a = 0.0;
    private double b = 0.0;
    private double c = 0.0;
    private double m = 0.0;
    private double q = 0.0;
    
    //costruttori
    public Retta(){
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;
    }
    
    public Retta(double a, double b, double c){
        this();
        if(a != 0.0){
            this.a = a;
        }
        if(b != 0.0){
            this.b = b;
        }
    }
    
    public boolean calcolaEquazioneDatiDuePunti(Punto p1, Punto p2){
        if(p1 != null && p2 != null){
            //matrice che contiene i coefficienti di m e q del sistema, utilizzato per determinare l'equazione della retta
            double coefficienti[][] = new double[2][3];
            //determinanti per risolvere il sistema con il metodo di Cramer
            double determinanteSistema;
            double determinanteM;
            double determinanteQ;
            //imposto sistema risolutore, utilizzando l'equazione generale della retta
            coefficienti[0][0] = p1.getY();
            coefficienti[0][1] = p1.getX();
            coefficienti[0][2] = 1;
            coefficienti[1][0] = p2.getY();
            coefficienti[1][1] = p2.getX();
            coefficienti[1][2] = 1;
            //calcolo determinante generale del sistema
            determinanteSistema = coefficienti[0][1] * coefficienti[1][2] - (coefficienti[1][1] * coefficienti[0][2]);
            //calcolo determinante del coefficiente angolare m della retta
            determinanteM = coefficienti[0][0] * coefficienti[1][2] - (coefficienti[1][0] * coefficienti[0][2]);
            //calcolo determinante di q della retta
            determinanteQ = coefficienti[0][1] * coefficienti[0][0] - (coefficienti[1][1] * coefficienti[1][0]);
            //calcolo m e q
            this.m = determinanteM / determinanteSistema;
            this.q = determinanteQ / determinanteSistema;
            return true;
            
        }
        return false;
    }
    
    //metodo per trasformare l'equazione della retta in forma implicita
    public void trasformaInImplicita(){
        this.a = -(this.m);
        this.b = 1;
        this.c = -(this.q);
    }
    
    //metodo per calcolare la distanza di un punto da una retta
    public double distanzaPuntoRetta(Punto p){
        return (Math.abs((this.a * p.getX()) + (this.b * p.getY()) + this.c)) / (Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2)));
    }
    
}
