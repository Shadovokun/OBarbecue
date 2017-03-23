package fr.iutinfo.skeleton.common.dto;

public class MonUserDto {
    private String nom;
    private String prenom;
    private String mail;



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

    public void setMail(String email) {
        this.mail = email;
    }

}
