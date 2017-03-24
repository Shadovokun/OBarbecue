package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.CommandeDto;

public class Commande {
	
	private int id;
	private String date;
	private String mailUser;
	private String nomProduit;
	private double prix;
	
	public Commande(int id, String date ,String mailUser,String nom, double prix){
		this.id = id;
		this.date = date;
		this.mailUser = mailUser;
		this.nomProduit = nomProduit;
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

	public String getMailUser() {
		return mailUser;
	}

	public void setMailUser(String mail_user) {
		this.mailUser = mail_user;
	}

	public String getNomProduit() {
		return nomProduit;
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
	
    public void initFromDto(CommandeDto dto) {
        this.setId(dto.getId());
        this.setDate(dto.getDate());
        this.setMail_user(dto.getMail_user());
        this.setNom_menu(dto.getNom_produit());
        this.setPrix(dto.getPrix());
    }

    public CommandeDto convertToDto() {
        CommandeDto dto = new CommandeDto();
        dto.setId(this.getId());
        dto.setDate(this.getDate());
        dto.setMail_user(this.getMail_user());
        dto.setNom_menu(this.getNom_produit());
        dto.setPrix(this.getPrix());
        return dto;
    }
}