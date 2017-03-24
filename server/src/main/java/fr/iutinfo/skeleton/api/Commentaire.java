package fr.iutinfo.skeleton.api;

import java.sql.Date;

import fr.iutinfo.skeleton.common.dto.CommentaireDTO;
import fr.iutinfo.skeleton.common.dto.UserDto;

public class Commentaire {
	
	private int id;
	private String contenu;
	private String dat;
	private String mail;
	private int note;

	public Commentaire(){}
	
	public Commentaire(int id, String contenu, String d, String mail, int note ){
		this.id=id;
		this.note = note;
		this.contenu = contenu;
		this.dat=d;
		this.mail = mail;
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


	public int getId() {
		return id;
	}
	
	public void setId(int i){
		this.id = id;
	}

	public String toString(){
		return "id : "+id+" / contenu : "+contenu+" / date : "+dat;
	}

    public void initFromDto(CommentaireDTO dto) {
        this.setContenu(dto.getContenu());
        this.setMail(dto.getMail());
        this.setId(dto.getId());
        this.setNote(dto.getNote());
        this.setDat(dto.getDat());
    }

    public CommentaireDTO convertToDto() {
        CommentaireDTO dto = new CommentaireDTO();
       
        dto.setContenu(this.getContenu());
        dto.setMail(this.getMail());
        dto.setId(this.getId());
        dto.setNote(this.getNote());
        dto.setDat(this.getDat());
        return dto;
    }
}
