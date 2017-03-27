package fr.iutinfo.skeleton.common.dto;

import java.security.Principal;

public class ProduitDto implements Principal{
	
	private String nom;
	private String description;
	private String cheminImg;
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private double prix;
	
	@Override
	public String getName() {
		return nom;
	}

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
	
	public String getCheminImg() {
		return cheminImg;
	}

	public void setCheminImg(String cheminImg) {
		this.cheminImg = cheminImg;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
