package fr.iutinfo.skeleton.api;

import java.util.ArrayList;

import org.skife.jdbi.v2.DBI;

public class MainTestBdd {
	
	
	public static void main(String [] args){
		DBI dbi = BDDFactory.getDbi();
		UserDao daoUser = dbi.open(UserDao.class);
		ProduitDao daoProduit = dbi.open(ProduitDao.class);
		
		daoProduit.createProduitsTable();
		daoProduit.insertProduits("coca","boisson fraiche","/img/coca",2.5);

		
		
		
		/*
		daoUser.createUserTable();
		daoUser.insertUser("tutu","tutu","tutu@hotmail.fr","admin","tutu","bonjour","0605040302",0);
		daoUser.insertUser("toto","toto","toto@hotmail.fr","client","toto","bonjour","0605040302",3);
		*/
		/*
		ArrayList<User> list= new ArrayList<>();
		list = (ArrayList<User>) daoUser.all();
		for(User u : list){
			System.out.println(u);
		}
		*/
		ArrayList<Produit> list = new ArrayList<>();
		list = (ArrayList<Produit>) daoProduit.all();
		for(Produit p : list){
			System.out.println(p);
		}
		
		
		
	}

}
