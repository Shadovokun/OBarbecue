package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonUserDto {
    final static Logger logger = LoggerFactory.getLogger(MonUserDto.class);
	private String nom;
    private String prenom;
    private String mail;
    private String role;
    private String mdp;
    private String adresse;
	private String numTel;
	private int nbrCmd;
	
	public MonUserDto(String nom, String prenom , String mail, String role){
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.role = role;
	}
	
	public MonUserDto(String nom, String prenom , String mail, String role, String mdp, String adresse, String numTelephone, int nbr){
		this(nom,prenom,mail,role);
		this.mdp = mdp;
		this.adresse = adresse;
		this.numTel = numTelephone;
		this.nbrCmd = nbr;
	}
	
	public MonUserDto(){}
	
	
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
}
