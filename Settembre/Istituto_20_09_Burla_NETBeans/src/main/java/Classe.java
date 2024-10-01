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
    private String nome;
    //costruttore senza parametri
    public Classe(){
        this.studenti = new ArrayList <Studente> ();
        this.insegnanti = new ArrayList <Insegnante> ();
        this.nome = "-";
    }
    //costruttore con parametri
    public Classe(Studente studente, Insegnante insegnante, String nome){
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
        //nome
        if((nome != null) && (!(nome.equalsIgnoreCase(" ")))){
            this.nome = nome;
        }
    }
    //aggiungi studente, controllando che non sia già presente
    public boolean addStudente(Studente studente){
        boolean esiste = false;
        int i = 0;
        Studente studenteCerca = null;
        if(studente != null){
            while((esiste == false) && (i < this.studenti.size())){
                studenteCerca = this.studenti.get(i);
                if((studenteCerca.getNome() + studenteCerca.getCognome()).equalsIgnoreCase(studente.getNome() + studente.getCognome())){
                    esiste = true;
                    return false;
                }
                i++;
            }
            this.studenti.add(studente);
            return true;
        }
        return false;
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
    //aggiungi insegnante, controllando che non sia già presente
    public boolean addInsegnante(Insegnante insegnante){
        boolean esiste = false;
        int j = 0;
        Insegnante insegnanteCerca = null;
        if(insegnante != null){
            while((esiste == false) && (j < this.insegnanti.size())){
                insegnanteCerca = this.insegnanti.get(j);
                if((insegnanteCerca.getNome() + insegnanteCerca.getCognome()).equalsIgnoreCase(insegnante.getNome() + insegnante.getCognome())){
                    esiste = true;
                    return false;
                }
                j++;
            }
            this.insegnanti.add(insegnante);
            return true;
        }
        return false;
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
    //toString
    public String toString(){
        Studente studente = null;
        Insegnante insegnante = null;
        String out = "Nella classe " + this.nome + " ci sono i seguenti studenti:";
        for(int i = 0; i < this.studenti.size(); i++){
            studente = this.studenti.get(i);
            out += "\n" + (i + 1) + ". " + studente.toString();
        }
        out += "\nNella classe vi sono inoltre i seguenti insegnanti:";
        for(int j = 0; j < this.insegnanti.size(); j++){
            insegnante = this.insegnanti.get(j);
            out += "\n" + (j + 1) + ". " + insegnante.toString();
        }
        out += "\nIn tutto, vi sono quindi " + this.studenti.size() + " studenti e " + this.insegnanti.size() + " insegnanti.";
        return out;
    }
}