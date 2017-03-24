package fr.iutinfo.skeleton.api;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iutinfo.skeleton.common.dto.MonUserDto;

public class MonUserTest {

	@Test
	public void createUserCourtTest(){
		MonUser user = new MonUser("nom", "prenom", "mail", "role");
		assertEquals("nom", user.getNom());
		assertEquals("prenom", user.getPrenom());
		assertEquals("mail", user.getMail());
		assertEquals("role", user.getRole());
	}

	@Test
	public void createUserCompletTest(){
		MonUser user = new MonUser("nom", "prenom", "mail", "role", "mdp", "adresse", "numero", 0);		
		assertEquals("nom", user.getNom());
		assertEquals("prenom", user.getPrenom());
		assertEquals("mail", user.getMail());
		assertEquals("role", user.getRole());
		assertEquals("mdp", user.getMdp());
		assertEquals("adresse", user.getAdresse());
		assertEquals("numero", user.getNumTel());
		assertEquals(0, user.getNbrCmd());
	}
	
	@Test
	public void createAndSetTest(){
		MonUser user = new MonUser();
		
		user.setAdresse("adresse");
		user.setMail("mail");
		user.setMdp("mdp");
		user.setNbrCmd(0);
		user.setNom("nom");
		user.setNumTel("numero");
		user.setPrenom("prenom");
		user.setRole("role");
		
		
		assertEquals("nom", user.getNom());
		assertEquals("prenom", user.getPrenom());
		assertEquals("mail", user.getMail());
		assertEquals("role", user.getRole());
		assertEquals("mdp", user.getMdp());
		assertEquals("adresse", user.getAdresse());
		assertEquals("numero", user.getNumTel());
		assertEquals(0, user.getNbrCmd());
	}
	
	
	@Test 
	public void fromDtoTest(){
		MonUser user = new MonUser();
		MonUserDto dto = new MonUserDto("nom", "prenom", "mail", "role", "mdp", "adresse", "numero", 0);
		user.initFromDto(dto);
		
		assertEquals("nom", user.getNom());
		assertEquals("prenom", user.getPrenom());
		assertEquals("mail", user.getMail());
		assertEquals("role", user.getRole());
		assertEquals("mdp", user.getMdp());
		assertEquals("adresse", user.getAdresse());
		assertEquals("numero", user.getNumTel());
		assertEquals(0, user.getNbrCmd());
	}
	
	@Test
	public void toDtoTest(){
		MonUser user = new MonUser("nom", "prenom", "mail", "role", "mdp", "adresse", "numero", 0);
		MonUserDto dto = user.convertToDto();
		
		assertEquals("nom", user.getNom());
		assertEquals("prenom", user.getPrenom());
		assertEquals("mail", user.getMail());
		assertEquals("role", user.getRole());
		assertEquals("mdp", user.getMdp());
		assertEquals("adresse", user.getAdresse());
		assertEquals("numero", user.getNumTel());
		assertEquals(0, user.getNbrCmd());
		
	}

}
