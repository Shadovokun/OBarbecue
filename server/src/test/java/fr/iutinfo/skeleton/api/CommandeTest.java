package fr.iutinfo.skeleton.api;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iutinfo.skeleton.common.dto.CommandeDto;

public class CommandeTest {


	@Test
	public void commandeTest(){
		Commande c = new Commande(1,"20/02/2017","mail@mail.fr","nom",20.0,5);
		assertEquals(c.getId(),1);
		assertEquals(c.getMail(),"mail@mail.fr");
		assertEquals(c.getDat(),"20/02/2017");
		assertEquals(c.getNbr(),5);	
		
	}
	
	@Test
	public void convertToDTO(){
		Commande c = new Commande(1,"20/02/2017","mail@mail.fr","nom",20,5);
		CommandeDto dto = c.convertToDto();
		
		assertEquals(dto.getId(),c.getId());
		assertEquals(dto.getDate(),c.getDat());
		assertEquals(dto.getMail(),c.getMail());		
	}
	
	
}
