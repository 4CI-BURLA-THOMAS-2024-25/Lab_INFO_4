package com.mycompany.approfondimentotrimestre;

/**
 *
 * classe Punto
 * @author Thomas Burla
 * @version 1.0
 */
public class Punto {
    //attributi
    private double x;
    private double y;
    //costruttori
    public Punto(){
        this.x = 0.0;
        this.y = 0.0;
    }
    
    public Punto(double x, double y){
        //inizializzo
        this();
        //imposto
        this.x = x;
        this.y = y;
    }
    
    //set e get
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public double getX(){
        return this.x;
    }
    
    
    public double getY(){
        return this.y;
    }
    //toString
    public String toString(){
        return "P(" + this.x + "; " + this.y + ")";
    }
}
