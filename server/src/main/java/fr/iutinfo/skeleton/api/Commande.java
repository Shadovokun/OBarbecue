package fr.iutinfo.skeleton.api;

import java.sql.Date;

public class Commande {
	
	private int id;
	private String date;
	private String mail_user;
	private String nom_produit;
	private double prix;
	
	public Commande(int id, String date ,String mail_user,String nom, double prix){
		this.id = id;
		this.date = date;
		this.mail_user = mail_user;
		this.nom_produit = nom_produit;
		this.prix = prix;
	}
	
	public Commande(){}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail_user() {
		return mail_user;
	}

	public void setMail_user(String mail_user) {
		this.mail_user = mail_user;
	}

	public String getNom_produit() {
		return nom_produit;
	}

	public void setNom_menu(String nom_produit) {
		this.nom_produit = nom_produit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String toString(){
		return "id : "+id+" / mail user : "+mail_user+" / produit : "+nom_produit +" / date : "+date +" / prix :"+prix ;
	}
	
}
