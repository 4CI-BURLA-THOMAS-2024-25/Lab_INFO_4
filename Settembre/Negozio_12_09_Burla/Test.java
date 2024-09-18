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
        //carrello per la spesa di casa
        Carrello casa = new Carrello(pollo);
        casa.setProdotto(uova);
        //cerco prodotto nel carrello e stampo le sue info
        System.out.println(casa.getProdottoStringa("pollo") + "\n");
        //prodotti nel carrello con la spesa della casa
        System.out.println(casa.toString() + "\n");
        //yogurt
        Prodotto yogurtPistacchio = new Prodotto(0.79, "Yogurt al pistacchio", 128856621);
        System.out.println(yogurtPistacchio.toString() + "\n");
        //carrello per la spesa della pizzeria
        Carrello pizzeria = new Carrello(yogurtPistacchio);
        //gelato alla nocciola
        Prodotto gelatoNocciola = new Prodotto(2.49, "Gelato alla nocciola", 792963699);
        System.out.println(gelatoNocciola.toString() + "\n");
        pizzeria.setProdotto(gelatoNocciola);
        //preparo lo scontrino (del mese di giugno, scelta arbitraria)
        Scontrino giugno = new Scontrino(casa);
        giugno.setCarrello(pizzeria);
        System.out.println(giugno.toString());
        System.out.println(giugno.getTotale() + "\n");
        //cliente Thomas
        Cliente thomas = new Cliente("Thomas", "Burla", "thomas@gmail.com", 1234567890, casa);
        thomas.setCarrello(pizzeria);
        System.out.println(thomas.toString() + "\n");
        //negozio Conad
        Negozio conad = new Negozio("Conad", "Verona", thomas);
        //limoncello
        Prodotto limoncello = new Prodotto(8.90, "Limoncello 1l", 646564621);
        System.out.println(limoncello.toString() + "\n");
        //limoni
        Prodotto limoni = new Prodotto(5.90, "Limoni italiani 800g", 9489178);
        System.out.println(limoni.toString() + "\n");
        //carrello per la spesa del bar
        Carrello bar = new Carrello(limoncello);
        bar.setProdotto(limoni);
        System.out.println(bar.toString() + "\n");
        //cliente Andrea
        Cliente andrea = new Cliente("Andrea", "Rossi", "andrearossi@outlook.it", 1069503680, bar);
        System.out.println(andrea.toString() + "\n");
        //aggiugno il cleinte al negozio
        conad.setCliente(andrea);
        //output dei clienti del negozio e delle loro spese
        System.out.println(conad.toString() + "\n");
    }
}