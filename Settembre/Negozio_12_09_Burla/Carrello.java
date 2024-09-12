/**
 * carrello che contiene i prodotti
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.*;
public class Carrello{
    //dichiarazione variabili d'istanza
    private ArrayList <Prodotto> prodotti;
    //costruttore senza parametri
    public Carrello(){
        this.prodotti = new ArrayList <Prodotto>();
    }
    //costruttore con parametri controllati
    public Carrello(Prodotto prodotto){
        this.prodotti = new ArrayList <Prodotto> ();
        if(prodotto != null){
            this.prodotti.add(prodotto);
        }
    }
    //set prodotto
    public void setProdotto(Prodotto prodotto){
        if(prodotto != null){
            this.prodotti.add(prodotto);
        }
    }
    //get prodotto come puntatore
    public Prodotto getProdotto(String nome){
        Prodotto prodotto = null;
        boolean trovato = false;
        int i = 0;
        while((trovato == false) && (i < (this.prodotti).size())){
            prodotto = (this.prodotti).get(i);
            if((prodotto.getNome()).equalsIgnoreCase(nome)){
                trovato = true;
            }
            i++;
        }
        if(trovato == true){
            return prodotto;
        }
        return null;
    }
    //get prodotto come stringa
    public String getProdottoStringa(String nome){
        Prodotto prodotto = null;
        boolean trovato = false;
        int i = 0;
        while((trovato == false) && (i < (this.prodotti).size())){
            prodotto = (this.prodotti).get(i);
            if((prodotto.getNome()).equalsIgnoreCase(nome)){
                trovato = true;
            }
            i++;
        }
        if(trovato == true){
            return prodotto.toString();
        }
        return "Nessun prodotto corrispondente";
    }
    //numero di prodotti
    public int numeroProdotti(){
        return this.prodotti.size();
    }
    //get arraylist di prodotti
    public ArrayList <Prodotto> getProdotti(){
        ArrayList <Prodotto> out = new ArrayList <Prodotto>();
        for(int i = 0; i < prodotti.size(); i++){
            out.add(prodotti.get(i));
        }
        return out;
    }
    //toString
    public String toString(){
        Prodotto prodotto = null;
        String out = "Nel carrello ci sono i seguenti prodotti:";
        for(int i = 0; i < this.prodotti.size(); i++){
            prodotto = this.prodotti.get(i);
            out += "\n" + (i + 1) + ". " + prodotto.toString();
        }
        return out;
    }
}