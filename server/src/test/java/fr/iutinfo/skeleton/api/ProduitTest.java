package fr.iutinfo.skeleton.api;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iutinfo.skeleton.common.dto.CommentaireDTO;
import fr.iutinfo.skeleton.common.dto.ProduitDto;

public class ProduitTest {

	@Test
	public void commentaireTest(){
		
		Produit c = new Produit("tim","des","img",20,"typ");
		
		assertEquals(c.getDescription(),"des");
		assertEquals(c.getCheminImg(),"img");
		assertEquals(c.getType(),"typ");
		assertEquals(c.getNom(),"tim");
		
	}
	
	@Test
	public void convertToDTO(){
		Produit c = new Produit("tim","des","img",20,"typ");
		ProduitDto dto = c.convertToDto();
		
		assertEquals(dto.getNom(),c.getNom());
		assertEquals(dto.getDescription(),c.getDescription());
		assertEquals(dto.getCheminImg(),c.getCheminImg());
		assertEquals(dto.getType(),c.getType());

	}
}
