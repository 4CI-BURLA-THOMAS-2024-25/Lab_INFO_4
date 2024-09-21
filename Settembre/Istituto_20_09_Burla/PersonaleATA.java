/**
 * classe PersonaleATA, che eredita variabili dalla classe Persona:
    -variabili di classe Persona
    -piano
    -(String)mansioni[]
 *
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.ArrayList;
public class PersonaleATA extends Persona{
    private int piano;
    private ArrayList <String> mansioni;
    //costruttore senza parametri
    public PersonaleATA(){
        super();
        this.piano = 0;
        this.mansioni = new ArrayList <String> ();
    }
    //costruttore con parametri
    public PersonaleATA(String nome, String cognome, String email, String codFiscale, String numCell, int piano, String mansione){
        //variabili classe Persona
        super(nome, cognome, email, codFiscale, numCell);
        //piano
        if(piano > 0){
            this.piano = piano;
        }
        //mansione
        if((mansione != null) && (!(mansione.equalsIgnoreCase(" ")))){
            this.mansioni = new ArrayList <String> ();
            this.mansioni.add(mansione);
        }
    }
    //set nome
    public void setNome(String nome){
        if((nome != null) && (!(nome.equalsIgnoreCase(" ")))){
            this.nome = nome;
        }
    }
    //get nome
    public String getNome(){
        return this.nome;
    }
    //set cognome
    public void setCognome(String cognome){
        if((cognome != null) && (!(cognome.equalsIgnoreCase(" ")))){
            this.cognome = cognome;
        }
    }
    //get cognome
    public String getCognome(){
        return this.cognome;
    }
    //set email
    public void setEmail(String email){
        if((email != null) && (!(email.equalsIgnoreCase(" ")))){
            this.email = email;
        }
    }
    //get email
    public String getEmail(){
        return this.email;
    }
    //set codice fiscale
    public void setcodFiscale(String codFiscale){
        if((codFiscale != null) && (!(codFiscale.equalsIgnoreCase(" ")))){
            this.codFiscale = codFiscale;
        }    
    }
    //get codice fiscale
    public String getcodFiscale(){
        return this.codFiscale;
    }
    //set numero di cellullare
    public void setNumCell(String numCell){
        if((numCell != null) && (!(numCell.equalsIgnoreCase(" ")))){
            this.numCell = numCell;
        }
    }
    //get numero di cellulare
    public String getNumCell(){
        return this.numCell;
    }
    //set piano
    public void setPiano(int piano){
        if(piano > 0){
            this.piano = piano;
        }
    }
    //get piano
    public int getPiano(){
        return this.piano;
    }
    //aggiungi mansione
    public void addMansione(String mansione){
        if((mansione != null) && (!(mansione.equalsIgnoreCase(" ")))){
            this.mansioni.add(mansione);
        }
    }
    //toString
    public String toString(){
        String out = "La persona si chiama " + this.nome + " " +  this.cognome;
        out += ", la sua email è: |" + this.email;
        out += "|, il suo numero di cellulare è: |" + this.numCell;
        out += "|, il suo codice fiscale è: |" + this.codFiscale;
        out += "|, le è stato assegnato il piano numero " + this.piano;
        out += " e svolge le seguenti mansioni:";
        for(int i = 0; i < this.mansioni.size(); i++){
            out += " " + this.mansioni.get(i) + ",";
        }
        return out;
    }
}