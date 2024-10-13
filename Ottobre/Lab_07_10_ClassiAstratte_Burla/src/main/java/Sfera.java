/**
 * classe Sfera, che eredita la classe astratta Solido
 * 
 * @author Thomas Burla
 * @version 1.0
 */
public class Sfera extends Solido{
    //variabili d'istanza
    private double raggio;
    //costruttore senza parametri
    public Sfera(){
        super();
        this.raggio = 0.0;
    }
    //costruttore con parametri
    public Sfera(double pesoSpecifico, double raggio){
        //invoco costruttore della classe padre
        super(pesoSpecifico);
        //raggio
        if(raggio > 0.0){
            this.raggio = raggio;
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
    //volume
    @Override
    public double volume(){
        if(this.raggio > 0.0){
            return (4 * Math.PI * Math.pow(this.raggio, 3)) / 3.0;
        }
        return -1;
    }
    //superficie
    @Override
    public double superficie(){
        if(this.raggio > 0.0){
            return 4 * Math.PI * Math.pow(this.raggio, 2);
        }
        return -1;
    }
    //toString
    @Override
    public String toString(){
        if(this.raggio > 0.0){
            double volume = (4 * Math.PI * Math.pow(this.raggio, 3)) / 3.0;
            double superficie = 4 * Math.PI * Math.pow(this.raggio, 2);
            String out = "Il raggio della sfera è: " + this.raggio;
            out += "m;\nla superficie del solido misura: " + superficie;
            out += "m^2;\nil volume del solido è: " + volume + "m^3";
            return out;
        }
        return "Dati NON validi";
    }
}
