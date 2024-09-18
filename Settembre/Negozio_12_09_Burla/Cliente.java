/**
 * classe Cliente:
    -nome
    -cognome
    -email
    -num_cell
    -Carrelli[]
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.*;
public class Cliente {
    //variabili d'istanza
    private String nome;
    private String cognome;
    private String email;
    private long num_cell;
    private ArrayList <Carrello> carrelli;
    //costruttore senza parametri
    public Cliente(){
        this.nome = "-";
        this.cognome = "-";
        this.email = "-";
        this.num_cell = 0000000000;
        this.carrelli = new ArrayList <Carrello> ();
    }
    //costruttore con parametri controllati
    public Cliente(String nome, String cognome, String email, long num_cell, Carrello carrello){
        //nome
        if(nome != null && (!(nome.equals(" ")))){
            this.nome = nome;
        }else{
            this.nome = "-";
        }
        //cognome
        if(cognome != null && (!(cognome.equals(" ")))){
            this.cognome = cognome;
        }else{
            this.cognome = "-";
        }
        //email
        if(email != null && (!(email.equals(" ")))){
            this.email = email;
        }else{
            this.email = "-";
        }
        //num_cell
        if(num_cell > 0){
            this.num_cell = num_cell;
        }else{
            this.num_cell = 0;
        }
        //Carrelli[]
        this.carrelli = new ArrayList <Carrello> ();
        if(carrello != null){
            this.carrelli.add(carrello);
        }
    }
    //set nome
    public void setNome(String nome){
        if(nome != null && (!(nome.equals(" ")))){
            this.nome = nome;
        }
    }
    //get nome
    public String getNome(){
        return this.nome;
    }
    //set cognome
    public void setCognome(String cognome){
        if((cognome != null) && (!(cognome.equals(" ")))){
            this.cognome = cognome;
        }
    }
    //get cognome
    public String getCognome(){
        return this.cognome;
    }
    //set email
    public void setEmail(String email){
        if((email != null) && (!(email.equals(" ")))){
            this.email = email;
        }
    }
    //get cognome
    public String getEmail(){
        return this.email;
    }
    //set num_cell
    public void setNum_cell(long num_cell){
        if(num_cell > 0){
            this.num_cell = num_cell;
        }
    }
    //get num_cell
    public long getNum_cell(){
        return this.num_cell;
    }
    //set carrello
    public void setCarrello(Carrello carrello){
        if(carrello != null){
            this.carrelli.add(carrello);
        }
    }
    //get carrello, come puntatore, in base al suo numero nella fila
    public Carrello getCarrello(int posizione){
        if(posizione <= this.carrelli.size()){
            return this.carrelli.get(posizione - 1);
        }
        return null;
    }
    //get carrello, come stringa, in base al suo numero nella fila
    public String getCarrelloStringa(int posizione){
        if(posizione <= this.carrelli.size()){
            return (this.carrelli.get(posizione - 1)).toString();
        }
        return null;
    }
    //toString
    public String toString(){
        Carrello carrello = null;
        String out = "Il cliente si chiama " + this.nome + " " + this.cognome;
        out += ", la sua email è: " +  this.email;
        out += " , il suo numero di cellulare è: " + this.num_cell;
        out += " e i seguenti sono i suoi carrelli: ";
        for(int i = 0; i < this.carrelli.size(); i++){
            carrello = this.carrelli.get(i);
            out += "\nCARRELLO " + (i + 1) + " --> " + carrello.toString();
        }
        return out;
    }
}