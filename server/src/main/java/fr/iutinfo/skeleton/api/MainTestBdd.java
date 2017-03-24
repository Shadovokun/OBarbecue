package fr.iutinfo.skeleton.api;

import java.util.ArrayList;

import org.skife.jdbi.v2.DBI;

public class MainTestBdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DBI dbi = BDDFactory.getDbi();
		MonUserDao dao = dbi.open(MonUserDao.class);
		
		dao.dropUserTable();
		System.out.println("Table drop");
		dao.createUserTable();
		System.out.println("Table created");
		dao.insertUsers(new MonUser("toto","tata", "tutu","toto","toto","toto","toot",0));
		dao.insertUsers(new MonUser("toto2","tata2", "tutu2","toto2","toto2","toto2","toot2",0));
		
		
		ArrayList<MonUser> list = new ArrayList();
		
		list = (ArrayList<MonUser>) dao.all();
		
		for(MonUser u : list){
			System.out.println(u);
		}
	}

}
