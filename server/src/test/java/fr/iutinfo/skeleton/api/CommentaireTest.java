package fr.iutinfo.skeleton.api;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iutinfo.skeleton.common.dto.CommandeDto;
import fr.iutinfo.skeleton.common.dto.CommentaireDTO;

public class CommentaireTest {


	@Test
	public void commentaireTest(){
		Commentaire c = new Commentaire("coucou","1977","mail@mail.fr",20,1);
		assertEquals(c.getContenu(),"coucou");
		assertEquals(c.getMail(),"mail@mail.fr");
		assertEquals(c.getDat(),"1977");
		assertEquals(c.getValide(),1);	
		
	}
	
	@Test
	public void convertToDTO(){
		Commentaire c = new Commentaire("coucou","1977","mail@mail.fr",20,1);
		CommentaireDTO dto = c.convertToDto();
		
		
		assertEquals(dto.getDate(),c.getDat());
		assertEquals(dto.getMail(),c.getMail());
		assertEquals(dto.getContenu(),c.getContenu());
		assertEquals(dto.getDat(),c.getDat());
		assertEquals(dto.getNote(),c.getNote());
		assertEquals(dto.getValide(),c.getValide());
	}	
}
