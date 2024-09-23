/**
 * classe Scuola:
    -Classi[]
    -codice meccanografico
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.ArrayList;
public class Scuola {
    private ArrayList <Classe> classi;
    private ArrayList <PersonaleATA> personaleATA;
    private String codice;
    private String nome;
    //costruttore senza parametri
    public Scuola(){
        this.classi = new ArrayList <Classe> ();
        this.personaleATA = new ArrayList <PersonaleATA> ();
        this.codice = "-";
        this.nome = "-";
    }
    //costruttore con parametri
    public Scuola(Classe classe, PersonaleATA personaleATA, String codice, String nome){
        //creo liste
        this.classi = new ArrayList <Classe> ();
        this.personaleATA = new ArrayList <PersonaleATA> ();
        //classi
        if(classe != null){
            this.classi.add(classe);
        }
        //personale ata
        if(personaleATA != null){
            this.personaleATA.add(personaleATA);
        }
        //codice meccanografico
        if((codice != null) && (!(codice.equalsIgnoreCase(" ")))){
            this.codice = codice;
        }
        //nome
        if((nome != null) && (!(nome.equalsIgnoreCase(" ")))){
            this.nome = nome;
        }
    }
    //aggiungi classe
    public boolean addClasse(Classe classe){
        if(classe != null){
            this.classi.add(classe);
            return true;
        }
        return false;
    }
    //cerca classe per nome e ottieni info come stringa
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
        }
        return "Non c'è alcuna classe corrispondente";
    }
    //cerca classe per nome e restituiscila come oggetto
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
        }
        return false;
    }
    //aggiungi personale ata
    public boolean addPersonaleATA(PersonaleATA personaleATA){
        if(personaleATA != null){
            this.personaleATA.add(personaleATA);
            return true;
        }
        return false;
    }
    //cerca personale ata per nome e ottieni info come stringa
    public String getPersonaleATAStringa(String nome){
        boolean trovato = false;
        PersonaleATA personaleATA2 = null;
        int i = 0;
        while((trovato == false) && (i < this.personaleATA.size())){
            personaleATA2 = this.personaleATA.get(i);
            if((personaleATA2.getNome() + " " + personaleATA2.getCognome()).equalsIgnoreCase(nome)){
                trovato = true;
                return personaleATA2.toString();
            }
        }
        return "Non c'è alcuna persona corrispondente";
    }
    //cerca personale ata per nome e restituisci come oggetto
    public PersonaleATA getPersonaleATA(String nome){
        boolean trovato = false;
        PersonaleATA personaleATA2 = null;
        int i = 0;
        while((trovato == false) && (i < this.personaleATA.size())){
            personaleATA2 = this.personaleATA.get(i);
            if((personaleATA2.getNome() + " " + personaleATA2.getCognome()).equalsIgnoreCase(nome)){
                trovato = true;
                return personaleATA2;
            }
        }
        return null;
    }
    //rimuovi personale ata
    public boolean rimuoviPersonaleATA(String nome){
        boolean trovato = false;
        PersonaleATA personaleATA2 = null;
        int i = 0;
        while((trovato == false) && (i < this.personaleATA.size())){
            personaleATA2 = this.personaleATA.get(i);
            if((personaleATA2.getNome() + " " + personaleATA2.getCognome()).equalsIgnoreCase(nome)){
                trovato = true;
                this.personaleATA.remove(i);
                return true;
            }
        }
        return false;
    }
    //set codice meccanografico
    public boolean setCodice(String codice){
        if((codice != null) && (!(codice.equalsIgnoreCase(" ")))){
            this.codice = codice;
            return true;
        }
        return false;
    }
    //get codice meccanografico
    public String getCodice(){
        return this.codice;
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
    //toString
    public String toString(){
        Classe classe = null;
        PersonaleATA personaleATA2 = null;
        String out = "Nella scuola " + this.nome + " ci sono le seguenti classi con i relativi studenti e insegnanti:";
        for(int i = 0; i < this.classi.size(); i++){
            classe = this.classi.get(i);
            out += "\n" + classe.toString();
        }
        out += "\nInoltre, vi sono le seguenti persone che fanno parte del Personale ATA:";
        for(int t = 0; t < this.personaleATA.size(); t++){
            personaleATA2 = this.personaleATA.get(t);
            out += "\n" + personaleATA2.toString();
        }
        return out;
    }
}