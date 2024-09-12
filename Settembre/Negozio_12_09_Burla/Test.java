/**
 * classe control
 * 
 * @author Thomas Burla 
 * @version 1.0
 */
public class Test{
    public static void main(String args[]){
        //uova
        Prodotto uova = new Prodotto(1.99, "uova", 81546738);
        System.out.println(uova.toString() + "\n");
        //pollo
        Prodotto pollo = new Prodotto(9.43, "pollo", 45754939);
        System.out.println(pollo.toString() + "\n");
        //carrello di Thomas
        Carrello casa = new Carrello(pollo);
        casa.setProdotto(uova);
        //cerco prodotto nel carrello e stampo le sue info
        System.out.println(casa.getProdottoStringa("pollo") + "\n");
        //prodotti nel carrello di Thomas
        System.out.println(casa.toString() + "\n");
        //yogurt
        Prodotto yogurtPistacchio = new Prodotto(0.79, "Yogurt al pistacchio", 128856621);
        System.out.println(yogurtPistacchio.toString() + "\n");
        Carrello pizzeria = new Carrello(yogurtPistacchio);
        //gelato alla nocciola
        Prodotto gelatoNocciola = new Prodotto(2.49, "Gelato alla nocciola", 792963699);
        System.out.println(gelatoNocciola.toString() + "\n");
        pizzeria.setProdotto(gelatoNocciola);
        //preparo lo scontrino (del mese di giugno, scelta arbitraria)
        Scontrino giugno = new Scontrino(casa);
        giugno.setCarrello(pizzeria);
        System.out.println(giugno.toString());
        System.out.println(giugno.getTotale());
    }
}