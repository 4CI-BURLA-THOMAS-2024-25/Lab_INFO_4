/**
 * classe Studente, che eredita variabili dalla classe Persona:
    -variabili di classe Persona
    -matricola
 *
 * @author Thomas Burla
 * @version 1.0
 */
public class Studente extends Persona{
    private int matricola;
    //costruttore senza parametri
    public Studente(){
        super();
        this.matricola = 0;
    }
    //costruttore con parametri
    public Studente(String nome, String cognome, String email, String codFiscale, String numCell, int matricola){
        super(nome, cognome, email, codFiscale, numCell);
        if(matricola > 0){
            this.matricola = matricola;
        }
    }
}
