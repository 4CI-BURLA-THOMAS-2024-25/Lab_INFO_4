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
    public double getStipendio(){
        return this.stipendio;
    }
    //assegna nuova classe
    public boolean addClasse(Classe classe){
        if(classe != null){
            this.classi.add(classe);
            return true;
        }
        return false;
    }
    //cerca classe tra quelle assegnate e ottieni info toString
    public String getClasseStringa(String nome){
        boolean trovato = false;
        Classe classe = null;
        int i = 0;
        while((trovato == false) && (i < this.classi.size())){
            classe = this.classi.get(i);
            if((classe.getNome()).equalsIgnoreCase(nome)){
                trovato = true;
                return classe.toString();
            }
            i++;
        }
        return "Nessuna classe trovata";
    }
    //cerca classe e ottienila come oggetto
    public Classe getClasse(String nome){
        boolean trovato = false;
        Classe classe = null;
        int i = 0;
        while((trovato == false) && (i < this.classi.size())){
            classe = this.classi.get(i);
            if((classe.getNome()).equalsIgnoreCase(nome)){
                trovato = true;
                return classe;
            }
            i++;
        }
        return null;
    }
    //rimuovi classe
    public boolean rimuoviClasse(String nome){
        boolean trovato = false;
        Classe classe = null;
        int i = 0;
        while((trovato == false) && (i < this.classi.size())){
            classe = this.classi.get(i);
            if((classe.getNome()).equalsIgnoreCase(nome)){
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
        Classe classe = null;
        String out = "La persona si chiama " + this.nome + " " +  this.cognome;
        out += ", la sua email è: |" + this.email;
        out += "|, il suo numero di cellulare è: |" + this.numCell;
        out += "|, il suo codice fiscale è: |" + this.codFiscale;
        out += "|, insegna la disciplina " + this.corso;
        out += ", il suo stipendio all'ora è di " + this.stipendio + "euro";
        out += "e insegna nelle seguenti classi:";
        for(int i = 0; i < this.classi.size(); i++){
            classe = this.classi.get(i);
            out += "\n--------------------------------------------------------------------------------";
            out += "\n" + classe.toString();
        }
        return out;
    }   
}