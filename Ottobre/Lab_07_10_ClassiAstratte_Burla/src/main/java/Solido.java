/**
 * classe astratta Solido
 * 
 * @author Thomas Burla
 * @version 1.0
 */
public abstract class Solido {
    //variabili d'istanza
    protected double pesoSpecifico;
    //costruttore senza parametri
    public Solido(){
        pesoSpecifico = 0.0;
    }
    //costruttore con parametri
    public Solido(double pesoSpecifico){
        if(pesoSpecifico > 0.0){
            this.pesoSpecifico = pesoSpecifico;
        }
    }
    //set pesoSpecifico
    public boolean setPesoSpecifico(double pesoSpecifico){
        if(pesoSpecifico > 0.0){
            this.pesoSpecifico = pesoSpecifico;
            return true;
        }
        return false;
    }
    //get pesoSpecifico
    public double getPesoSpecifico(){
        return this.pesoSpecifico;
    }
    //calcolo peso
    public double calcoloPeso(){
        return volume() * pesoSpecifico;
    }
    //calcolo perimetro
    public abstract double volume();
    //calcolo area
    public abstract double superficie();
}