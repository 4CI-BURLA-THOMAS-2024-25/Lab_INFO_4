/**
 * Scontrino della spesa
     -carrelli
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
    //get carrello come puntatore, in base al suo numero nella coda, verificando il parametro inserito
    public Carrello getCarrello(int numeroCarrello){
        if((numeroCarrello <= carrelli.size()) || (numeroCarrello > 0)){
            return this.carrelli.get(numeroCarrello - 1);
        }
        return null;
    }
    //get carrello come stringa
    public String getCarrelloStringa(int numeroCarrello){
        if((numeroCarrello <= carrelli.size()) || (numeroCarrello > 0)){
            return (this.carrelli.get(numeroCarrello - 1)).toString();
        }
        return null;
    }
    //toString
    public String toString(){
        String out = "Nella spesa, vi sono i seguenti carrelli, ognuno dei quali contiene i prodotti elencati:";
        Carrello carrello = null;
        //ciclo che stampa, uno alla volta, tutti i carrelli della arraylist
        for(int i = 0; i < this.carrelli.size(); i++){
            carrello = this.carrelli.get(i);
            out += "\nCARRELLO " + (i + 1) + " --> " + carrello.toString();
        }
        return out;
    }
    //calcolo il totale da pagare
    public double getTotale(){
        double totale = 0.0;
        Carrello carrello = null;
        Prodotto prodotto = null;
        for(int i = 0; i < this.carrelli.size(); i++){
            carrello = this.carrelli.get(i);
            for(int j = 0; j < carrello.numeroProdotti(); j++){
                prodotto = (carrello.getProdotti()).get(j);
                totale += prodotto.getCosto();
            }
        }

        return totale;
    }
}