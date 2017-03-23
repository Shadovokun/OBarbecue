package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.UserDto;

public class User {

	private String nom;
	private String prenom;
	private String mail;
	private String role;
	private String mdp;
	private String adresse;
	private String numTelephone;
	private int nbrCmd;
	
	
	public User(String nom, String prenom , String mail, String role){
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.role = role;
	}
	
	public User(String nom, String prenom , String mail, String role, String mdp, String adresse, String numTelephone, int nbr){
		this(nom,prenom,mail,role);
		this.mdp = mdp;
		this.adresse = adresse;
		this.numTelephone = numTelephone;
		this.nbrCmd = nbr;
	}

	public User(){}
    
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

	public String getNum_telephone() {
		return num_telephone;
	}

	public void setNum_telephone(String num_telephone) {
		this.num_telephone = num_telephone;
	}

	public int getNbr_cmd() {
		return nbr_cmd;
	}

	public void setNbr_cmd(int nbr_cmd) {
		this.nbr_cmd = nbr_cmd;
	}
	
	public String toString(){
		return "nom : "+nom+" / prenom : "+prenom+" / role : "+role;
	}
	
	
}
