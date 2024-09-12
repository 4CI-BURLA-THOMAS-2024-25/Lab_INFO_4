/**
 * Prodotti del negozio:
     -costo
     -nome
     -prezzo
 * 
 * @author Thomas Burla 
 * @version 1.0
 */
public class Prodotto{
    //varuabili d'istanza
    private double costo;
    private String nome;
    private long barcode;
    //costruttore senza parametri
    public Prodotto(){
        this.costo = 0.0;
        this.nome = "-";
        this.barcode = 0;
    }
    //costruttore con parametri controllati
    public Prodotto(double costo, String nome, long barcode){
        //costo
        if(costo > 0.0){
            this.costo = costo;
        }else{
            this.costo = 0.0; 
        }
        //nome
        if((nome != null) && (nome != " ")){
            this.nome = nome;
        }else{
            this.nome = "-";
        }
        //barcode
        if(barcode > 0){
            this.barcode = barcode;
        }else{
            this.barcode = 0;
        }
    }
    //set costo
    public void setCosto(double costo){
        if(costo > 0.0){
            this.costo = costo;
        }
    }
    //get costo
    public double getCosto(){
        return this.costo;
    }
    //set nome
    public void setNome(String nome){
        if((nome != null) && (nome != " ")){
            this.nome =nome;
        }
    }
    //get nome
    public String getNome(){
        return this.nome;
    }
    //set barcode
    public void setBarcode(long barcode){
        if(barcode > 0){
            this.barcode = barcode;
        }
    }
    //get barcode
    public long getBarcode(){
        return this.barcode;
    }
    //toString
    public String toString(){
        String out = "Il prodotto " + (this.nome).toUpperCase() + " costa " + this.costo + " euro e ha il seguete codice a barre: " + this.barcode;
        return out;
    }
}