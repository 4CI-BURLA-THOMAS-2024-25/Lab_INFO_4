/**
 * classe Cilindro, che eredita la classe astratta Solido
 * 
 * @author Thomas Burla
 * @version 1.0
 */
public class Cilindro extends Solido{
    //variabili d'istanza
    private double raggio;
    private double altezza;
    //costruttore senza parametri
    public Cilindro(){
        super();
        this.raggio = 0;
        this.altezza = 0;
    }
    //costruttore con parametri
    public Cilindro(double raggio, double altezza, double pesoSpecifico){
        //invoco costruttore classe padre
        super(pesoSpecifico);
        //raggio
        if(raggio > 0){
            this.raggio = raggio;
        }
        //altezza
        if(altezza > 0){
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
        if(altezza > 0){
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
        if(raggio > 0){
            return Math.PI * Math.pow(this.raggio, 2);
        }
        return -1;
    }
    //calcolo volume
    @Override
    public double volume(){
        if(raggio > 0){
            return Math.PI * Math.pow(this.raggio, 2) * this.altezza;
        }
        return -1;
    }
}
