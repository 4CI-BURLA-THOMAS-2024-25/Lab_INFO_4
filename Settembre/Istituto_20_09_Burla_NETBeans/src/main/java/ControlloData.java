/**
 * classe che controlla l'ammissibilita di una data
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
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }
    //set giorno
    public void setGiorno(int giorno){
      this.giorno = giorno;
    }
    //get giorno
    public int getGiorno(){
        return this.giorno;
    }
    //set mese
    public void setMese(int mese){
      this.mese = mese;
    }
    //get mese
    public int getMese(){
        return this.mese;
    }
    //set anno
    public void setAnno(int anno){
      this.anno = anno;
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