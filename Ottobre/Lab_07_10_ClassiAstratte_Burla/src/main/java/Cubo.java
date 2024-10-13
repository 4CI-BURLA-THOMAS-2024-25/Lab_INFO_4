/**
 * classe Cubo, che eredita la classe astratta Solido
 * 
 * @author Thomas Burla
 * @version 1.0
 */
public class Cubo extends Solido{
    //variabili d'istanza
    private double lato;
    //costruttore senza parametri
    public Cubo(){
        super();
        this.lato = 0.0;
    }
    //costruttore con parametri
    public Cubo(double pesoSpecifico, double lato){
        //invoco coatruttore classe padre
        super(pesoSpecifico);
        //lato
        if(lato > 0.0){
            this.lato = lato;
        }
    }
    //set lato
    public boolean setLato(double lato){
        if(lato > 0.0){
            this.lato = lato;
            return true;
        }
        return false;
    }
    //get lato
    public double getLato(){
        return this.lato;
    }
    //volume
    @Override
    public double volume(){
        if(this.lato > 0.0){
            return Math.pow(this.lato, 3);
        }
        return -1;
    }
    //superificie
    @Override
    public double superficie(){
        if(this.lato > 0.0){
            return 6 * (Math.pow(this.lato, 2));
        }
        return -1;
    }
    //toString
    @Override
    public String toString(){
        if(this.lato > 0.0){
            String out = "Il lato del cubo misura: " + this.lato;
            out += "m;\nla superificie del solido è: " + 6 * (Math.pow(this.lato, 2));
            out += "m^2;\nil volume del solido è: " + Math.pow(this.lato, 3) + "m^3";
            return out;
        }
        return "Dati NON validi";
    }
}
