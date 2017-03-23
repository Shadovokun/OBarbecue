package fr.iutinfo.skeleton.api;

import java.sql.Date;

import fr.iutinfo.skeleton.common.dto.CommentaireDTO;
import fr.iutinfo.skeleton.common.dto.UserDto;

public class Commentaire {
	
	private int id;
	private String contenu;
	private String date;
	private String mail;
	private int note;

	public Commentaire(){}
	
	public Commentaire(int id, String contenue, String d, String mail, int note ){
		this.id=id;
		this.note = note;
		this.contenu = contenue;
		this.date=d;
		this.mail = mail;
	}
	
	public String getContenue() {
		return contenu;
	}


	public void setContenue(String contenue) {
		this.contenu = contenue;
	}


	public String getDat() {
		return date;
	}


	public void setDat(String dat) {
		this.date = dat;
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


	public int getId() {
		return id;
	}
	
	public void setId(int i){
		this.id = id;
	}


    public void initFromDto(CommentaireDTO dto) {
        this.setContenue(dto.getContenue());
        this.setMail(dto.getMail());
        this.setId(dto.getId());
        this.setNote(dto.getNote());
        this.setDat(dto.getDat());
    }

    public CommentaireDTO convertToDto() {
        CommentaireDTO dto = new CommentaireDTO();
       
        dto.setContenue(this.getContenue());
        dto.setMail(this.getMail());
        dto.setId(this.getId());
        dto.setNote(this.getNote());
        dto.setDat(this.getDat());
        return dto;
    }
}
