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
    
    //distanza tra 2 punti
    public static double distanzaTraPunti(Punto p1, Punto p2){
        double lunghezza, diffX, diffY;
        if((p1 != null) && (p2 != null)){
            //differenza x dei punti
            diffX = p1.getX() - p2.getX();
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
    //toString
    public String toString(){
        return "P(" + this.x + "; " + this.y + ")";
    }
}