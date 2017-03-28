package fr.univ_lille1.iut_info.behaguec.obarbecue;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;


import fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit.Produit;

/**
 * Created by behaguec on 23/03/17.
 */

public class Save extends Application{

    private static Save INSTANCE = new Save();

    public ArrayList<Produit> panier=new ArrayList<Produit>();

    public List<ProduitBDD> listProduitBDD;

    private Save(){}

    public static Save getInstance()
    {	return INSTANCE;
    }

    private int getIndex(Produit p){
        for(int i=0; i<panier.size(); i++){
            if(panier.get(i).nom.equals(p.nom)){
                return i;
            }
        }
        return -1;
    }

    public void addProduit(Produit p){
        int gi=getIndex(p);
        if(gi!=-1){
            panier.get(gi).quantitePlus();
        }else{
            panier.add(p);
        }
    }

    public void removeProduit(Produit p){
        int gi=getIndex(p);
        if(gi!=-1) {
            if(panier.get(gi).quantite<2) {
                panier.remove(p);
            }else {
                panier.get(gi).quantiteMoins();
            }
        }
    }

    public void deleteProduit(Produit p){
        int gi=getIndex(p);
        if(gi!=-1) {
            panier.remove(gi);
        }
    }

    public double getPrix(){
        double r=0.0;

        for(int i=0; i<panier.size(); i++){
            r+=panier.get(i).prix;
        }

        return r;
    }
}
