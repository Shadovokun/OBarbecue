package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.ProduitDto;

public class Produit {
	
	private String nom;
	private String description;
	private String cheminImg;
	private String type;
	private double prix;
	
	public Produit(String nom, String description, String cheminImg, double prix, String type){
		this.nom = nom;
		this.description = description;
		this.cheminImg = cheminImg;
		this.prix = prix;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
	public String toString(){
		return "nom : "+nom+" / prix : "+prix;
	}
	
    public void initFromDto(ProduitDto dto) {
    	this.nom = dto.getNom();
    	this.description = dto.getDescription();
    	this.prix = dto.getPrix();
    	this.cheminImg = dto.getCheminImg();
    	this.type = dto.getType();
    }
	
    public ProduitDto convertToDto() {
    	ProduitDto dto = new ProduitDto();
    	dto.setNom(this.nom);
    	dto.setDescription(this.description);
    	dto.setCheminImg(this.cheminImg);
    	dto.setPrix(this.prix);
    	dto.setType(this.type);
        return dto;
    }
	
	

}
