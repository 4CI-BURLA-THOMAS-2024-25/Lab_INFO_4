/**
 * classe control
 * 
 * @author Thomas Burla 
 * @version 1.0
 */
import javax.swing.JOptionPane;
public class Test{
    public static void main(String args[]){
        //uova
        Prodotto uova = new Prodotto(1.99, "uova", 81546738);
        JOptionPane.showMessageDialog(null, uova.toString());
        //pollo
        Prodotto pollo = new Prodotto(11.99, "pollo", 45754939);
        JOptionPane.showMessageDialog(null, pollo.toString());
        //carrello di Thomas
        Carrello thomas = new Carrello(pollo);
        thomas.setProdotto(uova);
        //cerco prodotto nel carrello e stampo le sue info
        System.out.println(thomas.getProdotto("pollo"));
        //prodotti nel carrello di Thomas
        System.out.println("\n" + thomas.toString());
    }
}