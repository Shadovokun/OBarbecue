package fr.iutinfo.skeleton.api;

import java.util.ArrayList;

import org.skife.jdbi.v2.DBI;

import fr.iutinfo.skeleton.common.dto.CommentaireDTO;

public class MainTestBdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DBI dbi = BDDFactory.getDbi();
		MonUserDao daoUser = dbi.open(MonUserDao.class);
		
		daoUser.dropUserTable();
		daoUser.createUserTable();
		System.out.println("USERS :");
		daoUser.insertUsers(new MonUser("toto","tata", "tutu","toto","toto","toto","toot",0));
		daoUser.insertUsers(new MonUser("toto2","tata2", "tutu2","toto2","toto2","toto2","toot2",0));
		
		
		ArrayList<MonUser> list = new ArrayList();
		
		list = (ArrayList<MonUser>) daoUser.all();
		
		for(MonUser u : list){
			System.out.println(u);
		}
		
		ProduitDao daoProduit = dbi.open(ProduitDao.class);
		
		daoProduit.dropProduitsTable();
		daoProduit.createProduitsTable();
		System.out.println("PRODUITS :");
		daoProduit.insertProduit(new Produit("Poulet braisé", "Huuuuum le bon poulet !", "/img/pouletBraise.jpg", 8.50, "lol" ));
		daoProduit.insertProduit(new Produit("Poulet à la mexicaine", "DAT CHICKEN !!", "/img/pouletMexicaine.jpg", 8.50, "lil" ));
	
		ArrayList<Produit> list2 = new ArrayList();
		
		list2 = (ArrayList<Produit>) daoProduit.all();
		
		for(Produit u : list2){
			System.out.println(u);
		}
		
		CommandeDao daoCommande = dbi.open(CommandeDao.class);
		
		daoCommande.dropCommandeTable();
		daoCommande.createCommandeTable();
		System.out.println("COMMANDE :");
		daoCommande.insertCommande(new Commande(1, "24/03/2017", "tutu", "Menu1", 8.50));
		daoCommande.insertCommande(new Commande(2, "24/03/2017", "tutu2", "Menu2", 5.50));
	
		ArrayList<Commande> list3 = new ArrayList();
		
		list3 = (ArrayList<Commande>) daoCommande.all();
		
		for(Commande u : list3){
			System.out.println(u);
		}
		
		System.out.println("COMMENTAIRE :");
		
		CommentaireDAO daoCommentaire = dbi.open(CommentaireDAO.class);
		
		daoCommentaire.dropCommentaireTable();
		daoCommentaire.createCommentaireTable();
		
		daoCommentaire.insertCommentaire(new Commentaire(1, "tut", "tt", "tto", 5, 0));
		
		ArrayList<Commentaire> list4 = new ArrayList();
		
		list4 = (ArrayList<Commentaire>) daoCommentaire.all();
		
		for(Commentaire u : list4){
			System.out.println(u);
		}
		
		
	}

}
