/**
 * classe "padre", che contiene variabili d'istanza comuni ad altre classi del progetto:
    -nome
    -cognome
    -email
    -codFiscale
    -numCell
 * 
 * @author Thomas Burla
 * @version 1.0
 */
public class Persona{
    //variabili d'istanza proected, così da essere reperibili alle altre classi del progetto che ereditano la classe padre
    protected String nome;
    protected String cognome;
    protected String email;
    protected String codFiscale;
    protected String numCell;
    //costruttore senza parametri
    public Persona(){
        this.nome = "-";
        this.cognome = "-";
        this.email = "-";
        this.codFiscale = "-";
        this.numCell = "-";
    }
    //costruttore con parametri
    public Persona(String nome, String cognome, String email, String codFiscale, String numCell){
        //nome
        if((nome != null) && (!(nome.equalsIgnoreCase(" ")))){
            this.nome = nome;
        }
        //ccognome
        if((cognome != null) && (!(cognome.equalsIgnoreCase(" ")))){
            this.cognome = cognome;
        }
        //email
        if((email != null) && (!(email.equalsIgnoreCase(" ")))){
            this.email = email;
        }
        //codice fiscale
        if((codFiscale != null) && (!(codFiscale.equalsIgnoreCase(" ")))){
            this.codFiscale = codFiscale;
        }
        //numero di cellulare
        if((numCell != null) && (!(numCell.equalsIgnoreCase(" ")))){
            this.numCell = numCell;
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
    //toString
    public String toString(){
        String out = "La persona si chiama " + this.nome + " " +  this.cognome;
        out += ", la sua email è: |" + this.email;
        out += "|, il suo numero di cellulare è: |" + this.numCell;
        out += "| e il suo codice fiscale è: |" + this.codFiscale + "|.";
        return out;
    }
}