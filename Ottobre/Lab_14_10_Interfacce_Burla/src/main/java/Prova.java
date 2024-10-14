/**
 * Si realizzi un componente interfaccia Documenti che rappresenta la tipologia dei
    documenti. In tale interfaccia si definisce il metodo:
    public boolean uguale(Libro X) che restituisce un booleano.
    Si realizzi poi una classe Libro che implementa l'interfaccia precedente. Ciascun Libro ha
    un soggetto (stringa), e un costo (intero). Il metodo uguale restituisce vero se i due
    oggetti (X e quello su cui è invocato) hanno lo stesso soggetto, falso altrimenti.
    Si realizzi poi una funzione main in una classe Prova che:
    - dichiari un oggetto l1, istanza della classe Libro, con attributi "storia", costo 35, un
    oggetto l2, istanza della classe Libro, con attributi "letteratura", costo 17 e un oggetto l3,
    istanza della classe Libro, con attributi "storia", costo 10.
    - chiamando il metodo uguale verifichi se l1 e l2 sono uguali e se l1 e l3 sono uguali e
    scriva su un file binario (res.dat) i boolean ottenuti. Si rileggano poi i boolean da file e li si
    visualizzi a video.
    Per l'uguaglianza tra stringhe usare il metodo equals.
    Si realizzi l'esercizio in un UNICO FILE .java e, nella soluzione, si prediliga il maggior
    riutilizzo di codice e la maggiore protezione possibile. 

    link utili

    https://www.html.it/pag/15600/le-interfacce-1/

    https://www.di.univr.it/documenti/OccorrenzaIns/matdid/matdid588638.pdf
 *
 * @author Thomas Burla
 * @version 1.0
 */

//main
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Prova{
    public static void main(String args[]){
        //gestisco eventuale errore di scrittura
        try{
            //preparo file di scrittura
            File f = new File("res.dat");
            FileWriter fw = new FileWriter(f);
            PrintWriter scrivo = new PrintWriter(fw);
            //creo libri
            Libro l1 = new Libro("Storia", 35);
            Libro l2 = new Libro("Letteratura" , 17);
            Libro l3 = new Libro("Storia", 10);
            //confronto e scrivo esiti
            scrivo.println(l1.uguale(l2));
            scrivo.println(l1.uguale(l3));
            //chiudo scrittura
            scrivo.flush();
            scrivo.close();
            //preparo file di lettura
            FileReader fr = new FileReader(f);
            Scanner leggo = new Scanner(fr);
            //leggo da file
            while(leggo.hasNextBoolean()){
                System.out.println(leggo.nextBoolean());
            }
            leggo.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "ERRORE di I/O", "Errore" , JOptionPane.ERROR_MESSAGE);
        }
       
    }
}

//interfaccia Documenti
interface Documenti{
    //metodo di confronto tra oggetti
    public boolean uguale(Libro x);
}

//classe libro, che implementa l'interfaccia documenti
class Libro implements Documenti{
    //variabili d'istanza
    private String soggetto;
    private int costo;
    //costruttore senza parametri
    public Libro(){
    this.soggetto = "-";
    this.costo = 0;
    }
    //costruttore con parametri controllati
    public Libro(String soggetto, int costo){
        //controllo soggetto
        if((soggetto != null) && (!(soggetto.equalsIgnoreCase(" "))) && (!(soggetto.equalsIgnoreCase("")))){
            this.soggetto = soggetto;
        }
        //controllo costo
        if(costo > 0){
            this.costo = costo;
        }
    }
    //set soggetto
    public boolean setSoggetto(String soggetto){
        if((soggetto != null) && (!(soggetto.equalsIgnoreCase(" "))) && (!(soggetto.equalsIgnoreCase("")))){
            this.soggetto = soggetto;
            return true;
        }
        return false;
    }
    //get soggetto
    public String getSoggetto(){
        return this.soggetto;
    }
    //set costo
    public boolean setCosto(int costo){
        if(costo > 0){
            this.costo = costo;
            return true;
        }
        return false;
    }
    //get costo
    public int getCosto(){
        return this.costo;
    }
    //implemento metodo che confronta libri
    @Override
    public boolean uguale(Libro x){
        return (this.soggetto).equalsIgnoreCase(x.soggetto);
    }
}