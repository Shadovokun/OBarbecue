package fr.iutinfo.skeleton.api;

public class Produit {
	
	private String nom;
	private String description;
	private String chemin_img;
	private double prix;
	
	public Produit(String nom, String description, String chemin_img, double prix){
		this.nom = nom;
		this.description = description;
		this.chemin_img = chemin_img;
		this.prix = prix;
	}
	
	public Produit(){}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChemin_img() {
		return chemin_img;
	}

	public void setChemin_img(String chemin_img) {
		this.chemin_img = chemin_img;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String toString(){
		return "nom : "+nom+" / prix : "+prix;
	}
	
	
	
	
	
	

}
