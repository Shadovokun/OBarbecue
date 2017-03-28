package fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit;

/**
 * Created by behaguec on 22/03/17.
 */

public class Produit {
    public String nom,description;
    public double prix;
    public int quantite = 0;
    public Produit(){}

    public Produit(String n, String d, double p){
        nom=n;
        description=d;
        prix=p;
        quantite=1;
    }

    public void quantitePlus(){
        quantite++;
    }

    public void quantiteMoins(){
        quantite--;
    }
}
