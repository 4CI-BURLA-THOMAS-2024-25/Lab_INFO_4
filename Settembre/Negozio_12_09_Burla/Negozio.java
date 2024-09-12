/**
 * classe Negozio:
    -nome
    -city
    -Clienti[]
 * 
 * @author Thomas Burla
 * @version 1.0
 */
import java.util.*;
public class Negozio {
    //variabili d'istanza
    private String nome;
    private String city;
    private ArrayList <Cliente> clienti;
    //costruttore senza parametri
    public Negozio(){
        this.nome = "-";
        this.city = "-";
        this.clienti = new ArrayList <Cliente> ();
    }
    //costruttore con parametri
    public Negozio(String nome, String city, Cliente cliente){
        //nome
        if(nome != null && (!(nome.equals(" ")))){
            this.nome = nome;
        }
        //city
        if(city != null && (!(city.equals(" ")))){
            this.city = city;
        }
        //clienti
        this.clienti = new ArrayList <Cliente> ();
        if(cliente != null){
            this.clienti.add(cliente);
        }
    }
}