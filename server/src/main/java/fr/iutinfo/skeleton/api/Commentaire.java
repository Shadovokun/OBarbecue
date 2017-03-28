package fr.iutinfo.skeleton.api;

import java.sql.Date;

import fr.iutinfo.skeleton.common.dto.CommentaireDTO;
import fr.iutinfo.skeleton.common.dto.UserDto;

public class Commentaire {
	
	private String contenu;
	private String dat;
	private String mail;
	private int note;
	private int valide;

	public int getValide() {
		return valide;
	}

	public void setValide(int valide) {
		this.valide = valide;
	}

	public Commentaire(){}
	
	public Commentaire(String contenu, String d, String mail, int note ,int valide){
		this.note = note;
		this.contenu = contenu;
		this.dat=d;
		this.mail = mail;
		this.valide = valide;
	}
	
	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public String getDat() {
		return dat;
	}


	public void setDat(String dat) {
		this.dat = dat;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getNote() {
		return note;
	}


	public void setNote(int note) {
		this.note = note;
	}




	public String toString(){
		return "contenu : "+contenu+" / date : "+dat +" mail : "+mail;
	}

    public void initFromDto(CommentaireDTO dto) {
        this.setContenu(dto.getContenu());
		this.setDat(dto.getDat());
        this.setMail(dto.getMail());
		this.setValide(dto.getValide());
        this.setNote(dto.getNote());
    }

    public CommentaireDTO convertToDto() {
        CommentaireDTO dto = new CommentaireDTO();
       
        dto.setContenu(this.getContenu());
		dto.setDat(this.getDat());
        dto.setMail(this.getMail());
		dto.setValide(this.valide);
        dto.setNote(this.getNote());
        
        return dto;
    }
}
