package fr.iutinfo.skeleton.api;

import java.sql.Date;

public class Commande {
	
	private int id;
	private String dat;
	private String mail;
	private String nom;
	private double prix;
	
	public Commande(int id, String date ,String mail_user,String nom, double prix){
		this.id = id;
		this.dat = date;
		this.mail = mail_user;
		this.nom = nom;
		this.prix = prix;
	}
	
	public Commande(){}
	
	public String getDate() {
		return dat;
	}

	public void setDate(String date) {
		this.dat = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail_user() {
		return mail;
	}

	public void setMail_user(String mail_user) {
		this.mail = mail_user;
	}

	public String getNom_produit() {
		return nom;
	}

	public void setNom_menu(String nom_produit) {
		this.nom = nom_produit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String toString(){
		return "id : "+id+" / mail user : "+mail+" / produit : "+nom +" / date : "+dat +" / prix :"+prix ;
	}
	
}
