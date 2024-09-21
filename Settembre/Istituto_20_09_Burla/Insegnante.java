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
}
