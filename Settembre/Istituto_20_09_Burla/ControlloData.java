/**
 * classe che controlla l'ammissibilità di una data
 * 
 * @author Thomas Burla 
 * @version 1.0
 */
public class ControlloData{
    private int giorno;
    private int mese;
    private int anno;
    //costruttore senza parametri
    public ControlloData(){
        this.giorno = 0;
        this.mese = 0;
        this.anno = 0;
    }
    //costruttore con parametri
    public ControlloData(int giorno, int mese, int anno){
        //controllo che il giorno sia maggiore di 0
        if(giorno > 0){
            this.giorno = giorno;
        }
        //controllo che il mese sia compreso tra 1 e 12
        if((mese > 0) || (mese <= 12)){
            this.mese = mese;
        }
        //controllo che l'anno non sia negativo
        if(anno >= 0){
            this.anno = anno;
        }
    }
    //set giorno
    public boolean setGiorno(int giorno){
        if(giorno > 0){
            this.giorno =giorno;
            return true;
        }
        return false;
    }
    //get giorno
    public int getGiorno(){
        return this.giorno;
    }
    //set mese
    public boolean setMese(int mese){
        if((mese > 0) || (mese <= 12)){
            this.mese = mese;
            return true;
        }
        return false;
    }
    //get mese
    public int getMese(){
        return this.mese;
    }
    //set anno
    public boolean setAnno(int anno){
        if(anno > 0){
            this.anno = anno;
            return true;
        }
        return false;
    }
    //get anno
    public int getAnno(){
        return this.anno;
    }
    //controllo data
    public boolean controllaData(){
        if((giorno > 0) || (mese > 0) || (mese <= 12) || (anno >= 0)){
            switch(mese){
              case 1:
                if(giorno <= 31){
                  return true;
                }
                break;
              case 2:
                if((anno % 4) == 0){
                  if(giorno <= 29){
                    return true;
                  }
                }else if(giorno <= 28){
                  return true;
                }
                break;
              case 3:
                if(giorno <= 31){
                  return true;
                }
                break;
              case 4:
                if(giorno <= 30){
                  return true;
                }
                break;
              case 5:
                if(giorno <= 31){
                  return true;
                }
                break;
              case 6:
                if(giorno <= 30){
                  return true;
                }
                break;
              case 7:
                if(giorno <= 31){
                  return true;
                }
                break;
              case 8:
                if(giorno <= 31){
                  return true;
                }
                break;
              case 9:
                if(giorno <= 30){
                  return true;
                }
                break;
              case 10:
                if(giorno <= 31){
                  return true;
                }
                break;
              case 11:
                if(giorno <= 30){
                  return true;
                }
                break;
              case 12:
                if(giorno <= 31){
                  return true;
                }
            }
            return false;
        }
        return false;
    }
}