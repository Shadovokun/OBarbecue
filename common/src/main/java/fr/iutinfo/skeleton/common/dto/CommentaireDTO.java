package fr.iutinfo.skeleton.common.dto;

import java.sql.Date;

public class CommentaireDTO {
	private int id;
	private String contenu;
	private String date;
	private String mail;
	private int note;

	
	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
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

}