/**
 * classe "padre", che contiene variabili d'istanza comuni ad altre classi del progetto
 * 
 * @author Thomas Burla
 * @version 1.0
 */
public class Persona{
    //variabili d'istanza proected, così da essere reperibili alle altre classi del progetto che ereditano la classe padre
    protected String nome;
    protected String cognome;
    protected String email;
    protected String cod_fiscale;
    protected String n_cell;
    //costruttore senza parametri
    public Persona(){
        this.nome = "-";
        this.cognome = "-";
        this.email = "-";
        this.cod_fiscale = "-";
        this.n_cell = "-";
    }
    //costruttore con parametri
    public Persona(String nome, String cognome, String email, String cod_fiscale, String n_cell){
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
        //cod_fiscale
        if((cod_fiscale != null) && (!(cod_fiscale.equalsIgnoreCase(" ")))){
            this.cod_fiscale = cod_fiscale;
        }
        //n_cell
        if((n_cell != null) && (!(n_cell.equalsIgnoreCase(" ")))){
            this.n_cell = n_cell;
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
}