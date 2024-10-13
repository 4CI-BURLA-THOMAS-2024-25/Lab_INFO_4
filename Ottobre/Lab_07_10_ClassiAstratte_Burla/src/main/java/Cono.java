/**
 * classe Cono, che eredita la classe astratta Solido
 * 
 * @author Thomas Burla
 * @version 1.0
 */
public class Cono extends Solido{
    //variabili d'istanza
    private double raggio;
    private double altezza;
    //costruttore senza paraemtri
    public Cono(){
        super();
        this.raggio = 0.0;
        this.altezza = 0.0;
    }
    //costruttore con parametri
    public Cono(double pesoSpecifico, double raggio, double altezza){
        //invoco costruttore classe padre
        super(pesoSpecifico);
        //raggio
        if(raggio > 0.0){
            this.raggio = raggio;
        }
        //altezza
        if(altezza > 0.0){
            this.altezza = altezza;
        }
    }
    //set raggio
    public boolean setRaggio(double raggio){
        if(raggio > 0.0){
            this.raggio = raggio;
            return true;
        }
        return false;
    }
    //get raggio
    public double getRaggio(){
        return this.raggio;
    }
    //set altezza
    public boolean setAltezza(double altezza){
        if(altezza > 0.0){
            this.altezza = altezza;
            return true;
        }
        return false;
    }
    //get altezza
    public double getAltezza(){
        return this.altezza;
    }
    //calcolo superficie
    @Override
    public double superficie(){
        if((this.raggio > 0.0) && (this.altezza > 0.0)){
            //calcolo apotema con teorema di Pitagora
            double apotema = Math.sqrt(Math.pow(this.raggio, 2) + Math.pow(this.altezza, 2));
            //calcolo superficie laterale
            double superficieLaterale = Math.PI * this.raggio * apotema;
            //calcolo superificie della base
            double superficieBase = Math.PI * Math.pow(this.raggio, 2);
            return superficieLaterale + superficieBase;
        }
        return -1;
    }
    //calcolo volume
    @Override
    public double volume(){
        if((this.raggio > 0.0) && (this.altezza > 0.0)){
            //calcolo superificie della base
            double superficieBase = Math.PI * Math.pow(this.raggio, 2);
            return (superficieBase * this.altezza) / 3.0;
        }
        return -1;
    }
    //toString
    @Override
    public String toString(){
        if((this.raggio > 0.0) && (this.altezza > 0.0)){
            //calcolo apotema con teorema di Pitagora
            double apotema = Math.sqrt(Math.pow(this.raggio, 2) + Math.pow(this.altezza, 2));
            //calcolo superficie laterale
            double superficieLaterale = Math.PI * this.raggio * apotema;
            //calcolo superificie della base
            double superficieBase = Math.PI * Math.pow(this.raggio, 2);
            String out = "Il raggio della base del cono è: " + this.raggio;
            out += "m;\nl'altezza del cono è: " + this.altezza;
            out += "m;\nil solido ha superficie: " + superficieLaterale + superficieBase;
            out += "m^2;\nil volume del solido è: " + (superficieBase * this.altezza) / 3.0 + "m^3";
            return out; 
        }
        return "Dati NON validi";
    }
}
