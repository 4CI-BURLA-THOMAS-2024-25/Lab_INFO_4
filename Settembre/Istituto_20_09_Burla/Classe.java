/**
 * classe Classe:
    -Studenti[]
    -Insegnanti[]
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.ArrayList;
public class Classe{
    //variabili d'istanza
    private ArrayList <Studente> studenti;
    private ArrayList <Insegnante> insegnanti;
    //costruttore senza parametri
    public Classe(){
        this.studenti = new ArrayList <Studente> ();
        this.insegnanti = new ArrayList <Insegnante> ();
    }
    //costruttore con parametri
    public Classe(Studente studente, Insegnante insegnante){
        //alloco liste
        this.studenti = new ArrayList <Studente> ();
        this.insegnanti = new ArrayList <Insegnante> ();
        //studente
        if(studente != null){
            this.studenti.add(studente);
        }
        //insegnante
        if(insegnante != null){
            this.insegnanti.add(insegnante);
        }
    }
    //aggiungi studente
    public void addStudente(Studente studente){
        if(studente != null){
            this.studenti.add(studente);
        }
    }
    //get studente come oggetto, dati nome e cognome
    public Studente getStudente(String nome){
        boolean trovato = false;
        Studente studente = null;
        int i = 0;
        while((trovato == false) && (i < this.studenti.size())){
            studente = this.studenti.get(i);
            if((studente.getNome() + " " + studente.getCognome()).equalsIgnoreCase(nome)){
                trovato = true;
                return studente;
            }
        }
        return null;
    }
    //get studente come stringa, dati nome e cognome
    public String getStudenteStringa(String nome){
        boolean trovato = false;
        Studente studente = null;
        int i = 0;
        while((trovato == false) && (i < this.studenti.size())){
            studente = this.studenti.get(i);
            if((studente.getNome() + " " + studente.getCognome()).equalsIgnoreCase(nome)){
                trovato = true;
                return studente.toString();
            }
        }
        return "Nessuno studente trovato";
    }
    //rimuovi studente, dati nome e cognome
    public boolean rimuoviStudente(String nome){
        boolean trovato = false;
        Studente studente = null;
        int i = 0;
        while((trovato == false) && (i < this.studenti.size())){
            studente = this.studenti.get(i);
            if((studente.getNome() + " " + studente.getCognome()).equalsIgnoreCase(nome)){
                trovato = true;
                this.studenti.remove(i);
                return true;
            }
        }
        return false;
    }
    //get numero degli studenti
    public int getNumeroStudenti(){
        return this.studenti.size();
    }
    //aggiungi insegnante
    public void addInsegnante(Insegnante insegnante){
        if(insegnante != null){
            this.insegnanti.add(insegnante);
        }
    }
    //get insegnante come oggetto, dati nome e cognome
    public Insegnante getInsegnate(String nome){
        boolean trovato = false;
        Insegnante insegnante = null;
        int i = 0;
        while((trovato == false) && (i < this.insegnanti.size())){
            insegnante = this.insegnanti.get(i);
            if((insegnante.getNome() + " " + insegnante.getCognome()).equalsIgnoreCase(nome)){
                trovato = true;
                return insegnante;
            }
        }
        return null;
    }
    //get insegnante come stringa, dati nome e cognome
    public String getInsegnanteStringa(String nome){
        boolean trovato = false;
        Insegnante insegnante = null;
        int i = 0;
        while((trovato == false) && (i < this.insegnanti.size())){
            insegnante = this.insegnanti.get(i);
            if((insegnante.getNome() + " " + insegnante .getCognome()).equalsIgnoreCase(nome)){
                trovato = true;
                return insegnante.toString();
            }
        }
        return "Nessuno studente trovato";
    }
    //rimuovi insegnante, dati nome e cognome
    public boolean rimuoviInsegnante(String nome){
        boolean trovato = false;
        Insegnante insegnante = null;
        int i = 0;
        while((trovato == false) && (i < this.insegnanti.size())){
            insegnante = this.insegnanti.get(i);
            if((insegnante.getNome() + " " + insegnante.getCognome()).equalsIgnoreCase(nome)){
                trovato = true;
                this.insegnanti.remove(i);
                return true;
            }
        }
        return false;
    }
    //get numero degli insegnanti
    public int getNumeroInsegnanti(){
        return this.insegnanti.size();
    }
    //toString
    public String toString(){
        Studente studente = null;
        Insegnante insegnante = null;
        String out = "Nella classe ci sono i seguenti studenti:";
        for(int i = 0; i < this.studenti.size(); i++){
            studente = this.studenti.get(i);
            out += "\n" + (i + 1) + ". " + studente.toString();
        }
        out += "\nNella classe vi sono inoltre i seguenti insegnanti:";
        for(int j = 0; j < this.studenti.size(); j++){
            insegnante = this.insegnanti.get(j);
            out += "\n" + (j + 1) + ". " + insegnante.toString();
        }
        out += "\nIn tutto, vi sono quindi " + this.studenti.size() + " studenti e " + this.insegnanti.size() + " insegnanti.";
        return out;
    }
}