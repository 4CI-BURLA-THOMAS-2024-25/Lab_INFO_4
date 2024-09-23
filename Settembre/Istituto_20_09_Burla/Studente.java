/**
 * classe Studente, che eredita variabili dalla classe Persona:
    -variabili di classe Persona
    -matricola
 *
 * @author Thomas Burla
 * @version 1.0
 */
public class Studente extends Persona{
    //variabili d'istanza
    private int matricola;
    //costruttore senza parametri
    public Studente(){
        super();
        this.matricola = 0;
    }
    //costruttore con parametri
    public Studente(String nome, String cognome, String email, String codFiscale, String numCell, int matricola){
        //variabili classe persona
        super(nome, cognome, email, codFiscale, numCell);
        //matricola
        if(matricola > 0){
            this.matricola = matricola;
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
    //set matricola
    public boolean setMatricola(int matricola){
        if(matricola > 0){
            this.matricola = matricola;
            return true;
        }
        return false;
    }
    //get matricola
    public int getMatricola(){
        return this.matricola;
    }
    //toString
    public String toString(){
        String out = "Lo/a studente/ssa si chiama " + this.nome + " " +  this.cognome;
        out += ", la sua email è: |" + this.email;
        out += "|, il suo numero di cellulare è: |" + this.numCell;
        out += "|, il suo codice fiscale è: |" + this.codFiscale;
        out += "|, la sua matricola è: |" + this.matricola + "|.";
        return out;
    }
}