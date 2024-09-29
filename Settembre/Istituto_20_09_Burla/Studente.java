/**
 * classe Studente, che eredita variabili dalla classe Persona:
    -variabili di classe Persona
    -matricola
 *
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.ArrayList;
public class Studente extends Persona{
    //variabili d'istanza
    private int matricola;
    private ArrayList <Voto> voti;
    //costruttore senza parametri
    public Studente(){
        super();
        this.matricola = 0;
        this.voti = new ArrayList <Voto> ();
    }
    //costruttore con parametri
    public Studente(String nome, String cognome, String email, String codFiscale, String numCell, int matricola, Voto voto){
        //variabili classe persona
        super(nome, cognome, email, codFiscale, numCell);
        //matricola
        if(matricola > 0){
            this.matricola = matricola;
        }
        //voto
        this.voti = new ArrayList <Voto> ();
        if((voto != null) && (voto.getValore() >= 1) && (voto.getValore() <= 10)){
            this.voti.add(voto);
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
    //add voto
    public boolean addVoto(Voto voto){
        Voto votoCerca =null;
        boolean esiste =  false;
        int v = 0;
        if((voto != null)  && (voto.getValore() >= 1) && (voto.getValore() <= 10)){
            while((esiste == false) && (v < this.voti.size())){
                votoCerca = this.voti.get(v);
                if(((votoCerca.getMateria()).equalsIgnoreCase(voto.getMateria())) && (votoCerca.getValore() == voto.getValore()) && (votoCerca.getData()[0] == voto.getData()[0]) && (votoCerca.getData()[1] == voto.getData()[1]) && (votoCerca.getData()[2] == voto.getData()[2])){
                    esiste = true;
                    return false;
                }
                v++;
            }
            this.voti.add(voto);
            return true;
        }
        return false;
    }
    //get voto come oggetto Voto
    public Voto getVoto(String materia, double valore, int giorno, int mese, int anno){
        boolean trovato = true;
        int v = 0;
        Voto voto = null;
        while((trovato == false) && (v < this.voti.size())){
            voto = this.voti.get(v);
            if((voto.getMateria()).equalsIgnoreCase(materia) && (voto.getValore() == valore) && (voto.getData()[0] == giorno) && (voto.getData()[1] == mese) && (voto.getData()[2] == anno)){
                trovato = true;
                return voto;
            }
        }
        return null;
    }
    //get voto come stringa
    public String getVotoStringa(String materia, double valore, int giorno, int mese, int anno){
        boolean trovato = true;
        int v = 0;
        Voto voto = null;
        while((trovato == false) && (v < this.voti.size())){
            voto = this.voti.get(v);
            if((voto.getMateria()).equalsIgnoreCase(materia) && (voto.getValore() == valore) && (voto.getData()[0] == giorno) && (voto.getData()[1] == mese) && (voto.getData()[2] == anno)){
                trovato = true;
                return voto.toString();
            }
        }
        return "Nessun voto corrispondente alle informazioni fornite";
    }
    //toString
    public String toString(){
        String out = "Lo/a studente/ssa si chiama " + this.nome + " " +  this.cognome;
        out += ", la sua email è: |" + this.email;
        out += "|, il suo numero di cellulare è: |" + this.numCell;
        out += "|, il suo codice fiscale è: |" + this.codFiscale;
        out += "| e la sua matricola è: |" + this.matricola + "|.";
        return out;
    }
}