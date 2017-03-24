package fr.iutinfo.skeleton.common.dto;

public class MonUserDto {
	
	private String nom;
    private String prenom;
    private String mail;
    private String role;
    private String mdp;
    private String adresse;
	private String numTel;
	private int nbrCmd;
	
	
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
