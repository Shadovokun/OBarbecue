package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.ProduitDto;

public class Produit {
	
	private String nom;
	private String description;
	private String cheminImg;
	private double prix;
	
	public Produit(String nom, String description, String cheminImg, double prix){
		this.nom = nom;
		this.description = description;
		this.cheminImg = cheminImg;
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
    }
	
    public ProduitDto convertToDto() {
    	ProduitDto dto = new ProduitDto();
    	dto.setNom(this.nom);
    	dto.setDescription(this.description);
    	dto.setPrix(this.prix);
        return dto;
    }
	
	

}
