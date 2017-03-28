package fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import fr.univ_lille1.iut_info.behaguec.obarbecue.ProduitBDD;


/**
 * Created by behaguec on 22/03/17.
 */

public class ListeProduit {


    List<Produit> liste;

    public ListeProduit(){
        liste=new ArrayList<Produit>();
    }
     public ListeProduit(List<Produit> l){
        liste=l;
    }

    public void getProduitsFromDb(List<ProduitBDD> produitBDDList){
        ProduitBDD p;
        for(int i=0; i<produitBDDList.size(); i++) {
            p = produitBDDList.get(i);
            try {
                liste.add(new Produit(p.getNom(), p.getDescription(), Double.parseDouble(p.getPrix())));
            }catch (Exception e){

            }
        }

    }

    public static String get(String url) throws IOException {

        String source ="";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            source +=inputLine;
        in.close();
        return source;
    }



    public boolean addProduit(Produit m){
        return liste.add(m);
    }
    public Produit getProduit(int i){
        if(liste.size()==1){
            return liste.get(0);
        }
        return liste.get(i);
    }
    public int getCount(){
        return liste.size();
    }
    public void setListe(List<Produit> liste) {
        this.liste = liste;
    }
}
