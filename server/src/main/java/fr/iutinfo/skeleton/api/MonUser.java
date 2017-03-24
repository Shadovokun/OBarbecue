package fr.iutinfo.skeleton.api;

import java.security.Principal;

import fr.iutinfo.skeleton.common.dto.MonUserDto;

public class MonUser implements Principal{

	private String nom;
	private String prenom;
	private String mail;
	private String role;
	private String mdp;
	private String adresse;
	private String numTel;
	private int nbrCmd;
	
	
	public MonUser(String nom, String prenom , String mail, String role){
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.role = role;
	}
	
	public MonUser(String nom, String prenom , String mail, String role, String mdp, String adresse, String numTelephone, int nbr){
		this(nom,prenom,mail,role);
		this.mdp = mdp;
		this.adresse = adresse;
		this.numTel = numTelephone;
		this.nbrCmd = nbr;
	}

	public MonUser(){}
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public int getNbrCmd() {
		return nbrCmd;
	}

	public void setNbrCmd(int nbrCmd) {
		this.nbrCmd = nbrCmd;
	}
	
	public String toString(){
		return "nom : "+nom+" / prenom : "+prenom+" / role : "+role;
	}
	
    public void initFromDto(MonUserDto dto) {
    	this.setNom(dto.getNom());
    	this.setPrenom(dto.getPrenom());
    	this.setMail(dto.getMail());
    	
    	this.setAdresse(dto.getAdresse());
    	this.setMdp(dto.getMdp());
    	this.setRole(dto.getRole());
    	this.setNumTel(dto.getNumTel());
    	this.setNbrCmd(dto.getNbrCmd());
    }
   

    public MonUserDto convertToDto() {
        MonUserDto dto = new MonUserDto();
        dto.setNom(this.nom);
        dto.setPrenom(this.prenom);
        dto.setMail(this.mail);
        dto.setNumTel(this.numTel);
        
        dto.setAdresse(this.adresse);
        dto.setMdp(this.mdp);
        dto.setRole(this.role);
        dto.setMail(this.mail);
        dto.setNbrCmd(this.nbrCmd);
        
        return dto;
    }

	@Override
	public String getName() {
		return nom;
	}
	
}
