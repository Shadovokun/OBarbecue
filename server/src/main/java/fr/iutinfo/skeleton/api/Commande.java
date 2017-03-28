package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.CommandeDto;

public class Commande {
	
	private int id;
	private String dat;
	private String mail;
	private String nom;
	private double prix;
	private int nbr;
	
	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public Commande(int id, String date ,String mailUser,String nom, double prix, int nbr){
		this.id = id;
		this.dat = date;
		this.mail = mailUser;
		this.nom = nom;
		this.prix = prix;
		this.nbr = nbr;
	}
	
	public Commande(){}
	
	public String getDat() {
		return dat;
	}

	public void setDat(String dat) {
		this.dat = dat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
	
    public void initFromDto(CommandeDto dto) {
        this.setId(dto.getId());
        this.setDat(dto.getDate());
        this.setMail(dto.getMail());
        this.setNom(dto.getNom());
        this.setPrix(dto.getPrix());
    }

    public CommandeDto convertToDto() {
        CommandeDto dto = new CommandeDto();
        dto.setId(this.getId());
        dto.setDate(this.getDat());
        dto.setMail(this.getMail());
        dto.setNom(this.getNom());
        dto.setPrix(this.getPrix());
        return dto;
    }
}