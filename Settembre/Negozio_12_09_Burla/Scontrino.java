/**
 * Scontrino della spesa
     -prodotti
     +totale
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.*;
public class Scontrino{
    //variabili d'istanza
    public ArrayList <Carrello> carrelli;
    //costruttore senza parametri
    public Scontrino(){
        this.carrelli = new ArrayList <Carrello>();
    }
    //costruttore con parametri
    public Scontrino(Carrello carrello){
        this.carrelli = new ArrayList <Carrello>();
        if(carrello != null){
            this.carrelli.add(carrello);
        }
    }
    //set carrello
    public void setCarrello(Carrello carrello){
        if(carrello != null){
            this.carrelli.add(carrello);
        }
    }
    //get carrello, in base al suo numero nella coda
    public Carrello getCarrello(int numeroCarrello){
        int i = numeroCarrello - 1;
        if((numeroCarrello > carrelli.size()) || (i < 1)){
            
        }
    }
}