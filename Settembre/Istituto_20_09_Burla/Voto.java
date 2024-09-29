/**
 * classe Voto:
    -voto
    -materia
 * 
 * @author Thomas Burla 
 * @version 1.0
 */
public class Voto{
    private String materia;
    private double valore;
    private int giorno;
    private int mese;
    private int anno;
    //costruttore senza parametri
    public Voto(){
        this.materia = "-";
        this.valore = 0.0;
        this.giorno = 0;
        this.mese = 0;
        this.anno = 0;
    }
    //costruttore con parametri
    public Voto(String materia, double valore, int giorno, int mese, int anno){
        //materia
        if((materia != null) && (!(materia.equalsIgnoreCase(""))) && (!(materia.equalsIgnoreCase(" ")))){
            this.materia = materia;
        }
        //valore
        if((valore >= 1) && (valore <= 10)){
            this.valore = valore;
        }
        //controllo data
        ControlloData controlloData = new ControlloData(giorno, mese, anno);
        if(controlloData.controllaData() == true){
            this.giorno = giorno;
            this.mese = mese;
            this.anno = anno;
        }
    }
    //set materia
    public boolean setMateria(String materia){
        if((materia != null) && (!(materia.equalsIgnoreCase(""))) && (!(materia.equalsIgnoreCase(" ")))){
            this.materia = materia;
            return true;
        }
        return false;
    }
    //get materia
    public String getMateria(){
        return this.materia;
    }
    //set valore del voto
    public boolean setValore(double valore){
        if((valore >= 1) && (valore <= 10)){
            this.valore = valore;
            return true;
        }
        return false;
    }
    //get valore del voto
    public double getValore(){
        return this.valore;
    }
    //set data
    public boolean setData(int giorno, int mese, int anno){
        ControlloData controlloData = new ControlloData(giorno, mese, anno);
        if(controlloData.controllaData() == true){
            this.giorno = giorno;
            this.mese = mese;
            this.anno = anno;
            return true;
        }
        return false;
    }
    //getData
    public int[] getData(){
        int data[] = new int[3];
        data[0] = this.giorno;
        data[1] = this.mese;
        data[2] = this.anno;
        return data;
    }
    //toString
    public String toString(){
        String out = "Il voto relativo alla disciplina " + this.materia;
        out += ", risalente alla data " + this.giorno + "/" + this.mese + "/" + this.anno;
        out += "è: " + this.valore;
        return out;
    }
}