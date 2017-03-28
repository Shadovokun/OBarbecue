package fr.univ_lille1.iut_info.behaguec.obarbecue;

import fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit.Produit;

/**
 * Created by behaguec on 24/03/17.
 */

public class ProduitBDD {
    public String description;
    public String nom;
    public String prix;

    public ProduitBDD() {

    }

    public ProduitBDD(String description, String nom, String prix) {
        this.description = description;
        this.nom = nom;
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
