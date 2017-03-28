package fr.iutinfo.skeleton.common.dto;

import java.sql.Date;

public class CommentaireDTO {
	private String contenu;
	private String date;
	private String mail;
	private int note;
	private int valide;

	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getValide() {
		return valide;
	}


	public void setValide(int valide) {
		this.valide = valide;
	}


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

}