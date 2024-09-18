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
    //set nome
    public void setNome(String nome){
        if((nome != null) && (!(nome.equals(" ")))){
            this.nome = nome;
        }
    }
    //get nome
    public String getNome(){
        return this.nome;
    }
    //set city
    public void setCity(String city){
        if((city != null) && (!(city.equals(" ")))){
            this.city = city;
        }
    }
    //get city
    public String getCity(){
        return this.city;
    }
    //set cliente
    public void setCliente(Cliente cliente){
        if(cliente != null){
            this.clienti.add(cliente);
        }
    }
    //get cliente come puntatore, in base al nome
    public Cliente getCliente(String nome){
        Cliente cliente = null;
        boolean trovato = false;
        int i = 0;
        while((trovato == false) && (i < this.clienti.size())){
            cliente = this.clienti.get(i);
            if((cliente.getNome()).equalsIgnoreCase(nome)){
                trovato = true;
            }
            i++;
        }
        if(trovato == true){
            return cliente;
        }
        return null;
    }
    //get cliente come puntatore, in base al nome
    public String getClienteStringa(String nome){
        Cliente cliente = null;
        boolean trovato = false;
        int i = 0;
        while((trovato == false) && (i < this.clienti.size())){
            cliente = this.clienti.get(i);
            if((cliente.getNome()).equalsIgnoreCase(nome)){
                trovato = true;
            }
            i++;
        }
        if(trovato == true){
            return cliente.toString();
        }
        return "Nessun cliente corrispondente al nome indicato";
    }
    //toString
    public String toString(){
        Cliente cliente = null;
        String out = "Il negozio " + this.nome;
        out += " si trova nella città di " + this.city;
        out += " e ha i seguenti clienti: ";
        for(int i = 0; i < this.clienti.size(); i++){
            cliente = this.clienti.get(i);
            out += "\n------------------------------------------------------------------------------\n";
            out += cliente.toString();
        }
        return out;
    }
}