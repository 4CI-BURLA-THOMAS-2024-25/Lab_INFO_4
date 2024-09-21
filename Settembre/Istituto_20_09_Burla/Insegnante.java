/**
 * classe Insegnante, che eredita variabili dalla classe Persona:
    -variabili di Persona
    -corso
    -Classi[]
    -stipendio
 * 
 */
import java.util.ArrayList;
public class Insegnante extends Persona{
    //variabili d'istanza
    private String corso;
    private double stipendio;
    private ArrayList <Classe> classi;
    //costruttore senza parametri
    public Insegnante(){
        super();
        this.corso = "-";
        this.stipendio = 0.0;
        this.classi = new ArrayList <Classe> ();
    }
    //costruttore con parametri
    public Insegnante(String nome, String cognome, String email, String codFiscale, String numCell, String corso, double stipendio, Classe classe){
        //variabili classe Persona
        super(nome, cognome, email, codFiscale, numCell);
        //corso
        if((corso != null) && (!(corso.equalsIgnoreCase(" ")))){
            this.corso = corso;
        }
        //stipendio
        if(stipendio > 0.0){
            this.stipendio = stipendio;
        }
        //classe
        this.classi = new ArrayList <Classe> ();
        if(classe != null){
            this.classi.add(classe);
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
    //set corso
    public void setCorso(String corso){
        if((corso != null) && (!(corso.equalsIgnoreCase(" ")))){
            this.corso = corso;
        }
    }
    //get corso
    public String getCorso(){
        return this.corso;
    }
    //set stipendio
    public void setStipendio(double stipendio){
        if(stipendio > 0.0){
            this.stipendio = stipendio;
        }
    }
    public double getStipendio(){
        return this.stipendio;
    }
    //assegna nuova classe
    public void addClasse(Classe classe){
        if(classe != null){
            this.classi.add(classe);
        }
    }

    
    /*
        //cerca classe tra quelle assegnate e ottieni info toString
        public String getClasseStringa(String nome){

        }
        public Classe getClasse(String nome){

        }
        public boolean rimuoviClasse(String nome){
            
        }
    */

    //toString
    public String toString(){
        String out = "La persona si chiama " + this.nome + " " +  this.cognome;
        out += ", la sua email è: |" + this.email;
        out += "|, il suo numero di cellulare è: |" + this.numCell;
        out += "|, il suo codice fiscale è: |" + this.codFiscale;
        out += "|, insegna la disciplina " + this.corso;
        out += ", il suo stipendio all'ora è di " + this.stipendio + "euro";
        out += "e insegna nelle seguenti classi:";
        return out;
    }   
}