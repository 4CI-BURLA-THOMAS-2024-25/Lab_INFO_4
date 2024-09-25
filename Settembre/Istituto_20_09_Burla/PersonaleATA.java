/**
 * classe PersonaleATA, che eredita variabili dalla classe Persona:
    -variabili di classe Persona
    -piano
    -stipendio
    -(String)mansioni[]
 *
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.ArrayList;
public class PersonaleATA extends Persona{
    //variabili d'istanza
    private int piano;
    private double stipendio;
    private ArrayList <String> mansioni;
    //costruttore senza parametri
    public PersonaleATA(){
        super();
        this.piano = 0;
        this.stipendio = 0.0;
        this.mansioni = new ArrayList <String> ();
    }
    //costruttore con parametri
    public PersonaleATA(String nome, String cognome, String email, String codFiscale, String numCell, int piano, double stipendio, String mansione){
        //variabili classe Persona
        super(nome, cognome, email, codFiscale, numCell);
        //piano
        if(piano > 0){
            this.piano = piano;
        }
        //stipendio
        if(stipendio > 0.0){
            this.stipendio = stipendio;
        }
        //mansione
        this.mansioni = new ArrayList <String> ();
        if((mansione != null) && (!(mansione.equalsIgnoreCase(" ")))){
            this.mansioni.add(mansione);
        }
    }
    //set nome
    public boolean setNome(String nome){
        if((nome != null) && (!(nome.equalsIgnoreCase(" ")))){
            this.nome = nome;
            return true;
        }
        return false;
    }
    //get nome
    public String getNome(){
        return this.nome;
    }
    //set cognome
    public boolean setCognome(String cognome){
        if((cognome != null) && (!(cognome.equalsIgnoreCase(" ")))){
            this.cognome = cognome;
            return true;
        }
        return false;
    }
    //get cognome
    public String getCognome(){
        return this.cognome;
    }
    //set email
    public boolean setEmail(String email){
        if((email != null) && (!(email.equalsIgnoreCase(" ")))){
            this.email = email;
            return true;
        }
        return false;
    }
    //get email
    public String getEmail(){
        return this.email;
    }
    //set codice fiscale
    public boolean setcodFiscale(String codFiscale){
        if((codFiscale != null) && (!(codFiscale.equalsIgnoreCase(" ")))){
            this.codFiscale = codFiscale;
            return true;
        }    
        return false;
    }
    //get codice fiscale
    public String getcodFiscale(){
        return this.codFiscale;
    }
    //set numero di cellullare
    public boolean setNumCell(String numCell){
        if((numCell != null) && (!(numCell.equalsIgnoreCase(" ")))){
            this.numCell = numCell;
            return true;
        }
        return false;
    }
    //get numero di cellulare
    public String getNumCell(){
        return this.numCell;
    }
    //set piano
    public boolean setPiano(int piano){
        if(piano > 0){
            this.piano = piano;
            return true;
        }
        return false;
    }
    //get piano
    public int getPiano(){
        return this.piano;
    }
    //set stipendio
    public boolean setStipendio(double stipendio){
        if(stipendio > 0.0){
            this.stipendio = stipendio;
            return true;
        }
        return false;
    }
    //get stipendio
    public double getStipendio(){
        return this.stipendio;
    }
    //aggiungi mansione
    public boolean addMansione(String mansione){
        boolean esiste = false;
        int i = 0;
        String mansioneCerca = null;
        if((mansione != null) && (!(mansione.equalsIgnoreCase(" ")))){
            while((esiste == false) && (i < this.mansioni.size())){
                mansioneCerca = this.mansioni.get(i);
                if(mansioneCerca.equalsIgnoreCase(mansione)){
                    esiste = true;
                    return false;
                }
                i++;
            }
            this.mansioni.add(mansione);
            return true;
        }
        return false;
    }
    //elenco delle mansioni come stringa
    public String getMansioniStringa(){
        String out = "Mansioni svolte:";
        for(int i = 0; i < this.mansioni.size(); i++){
            out += " " + this.mansioni.get(i) + ",";
        }
        return out;
    }
    //rimuovi mansione
    public boolean rimuoviMansione(String mansioneCercata){
        boolean trovato = false;
        int i = 0;
        String mansione;
        while((trovato == false) && (i < this.mansioni.size())){
            mansione = this.mansioni.get(i);
            if(mansione.equalsIgnoreCase(mansioneCercata)){
                this.mansioni.remove(i);
                return true;
            }
        }
        return false;
    }
    //toString
    public String toString(){
        String out = "La persona si chiama " + this.nome + " " +  this.cognome;
        out += ", la sua email è: |" + this.email;
        out += "|, il suo numero di cellulare è: |" + this.numCell;
        out += "|, il suo codice fiscale è: |" + this.codFiscale;
        out += "|, il suo stipendio all'ora è di " + this.stipendio + " euro";
        out += ", le è stato assegnato il piano numero " + this.piano;
        out += " e svolge le seguenti mansioni:";
        for(int i = 0; i < this.mansioni.size(); i++){
            out += " " + this.mansioni.get(i);
            if(i < (this.mansioni.size() - 1)){
                out += ",";
            }else{
                out += ".";
            }
        }
        return out;
    }
}