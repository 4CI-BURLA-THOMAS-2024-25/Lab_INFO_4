/**
 * classe Insegnante, che eredita variabili dalla classe Persona:
    -variabili di Persona
    -corso
    -Classi[]
    -stipendio
 * 
 * @author Thomas Burla
 * @version 2.0
 */
import java.util.ArrayList;
public class Insegnante extends Persona{
    //variabili d'istanza
    private String corso;
    private double stipendio;
    private ArrayList <String> classi;
    //costruttore senza parametri
    public Insegnante(){
        super();
        this.corso = "-";
        this.stipendio = 0.0;
        this.classi = new ArrayList <String> ();
    }
    //costruttore con parametri
    public Insegnante(String nome, String cognome, String email, String codFiscale, String numCell, String corso, double stipendio, String classe){
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
        this.classi = new ArrayList <String> ();
        if((classe != null) && (!(classe.equalsIgnoreCase(" "))) && (!(classe.equalsIgnoreCase("")))){
            this.classi.add(classe.toUpperCase());
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
    //set corso
    public boolean setCorso(String corso){
        if((corso != null) && (!(corso.equalsIgnoreCase(" ")))){
            this.corso = corso;
            return true;
        }
        return false;
    }
    //get corso
    public String getCorso(){
        return this.corso;
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
    //assegna nuova classe
    public boolean addClasse(String classe){
        if((classe != null) && (!(classe.equalsIgnoreCase(" "))) && (!(classe.equalsIgnoreCase("")))){
            this.classi.add(classe.toUpperCase());
            return true;
        }
        return false;
    }
    //get classi
    public String getClassi(){
        String out = "";
        for(int i  = 0; i < this.classi.size(); i++){
            out += this.classi.get(i);
            if(i < (this.classi.size() - 1)){
                out += "; ";
            }
        }
        return out;
    }
    //rimuovi classe
    public boolean rimuoviClasse(String nome){
        boolean trovato = false;
        String classe = null;
        int i = 0;
        while((trovato == false) && (i < this.classi.size())){
            classe = this.classi.get(i);
            if(classe.equalsIgnoreCase(nome)){
                trovato = true;
                this.classi.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
    //toString
    public String toString(){
        String out = "La persona si chiama " + this.nome + " " +  this.cognome;
        out += ", la sua email è: |" + this.email;
        out += "|, il suo numero di cellulare è: |" + this.numCell;
        out += "|, il suo codice fiscale è: |" + this.codFiscale;
        out += "|, insegna la disciplina " + this.corso;
        out += ", il suo stipendio all'ora è di " + this.stipendio + " euro";
        out += " e insegna nelle seguenti classi:";
        for(int i = 0; i < this.classi.size(); i++){
            out += this.classi.get(i);
            if(i < (this.classi.size() - 1)){
                out += "; ";
            }
        } 
        return out;  
    }
}