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
    //costruttore senza parametri
    public Scuola(){
        this.classi = new ArrayList <Classe> ();
        this.personaleATA = new ArrayList <PersonaleATA> ();
        this.codice = "-";
    }
    //costruttore con parametri
    public Scuola(Classe classe, PersonaleATA personaleATA, String codice){
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
    }
}