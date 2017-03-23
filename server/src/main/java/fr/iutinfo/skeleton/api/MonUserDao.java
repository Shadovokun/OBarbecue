package fr.iutinfo.skeleton.api;

import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface MonUserDao {
	
	@SqlUpdate("Create table users(nom varchar(100), prenom varchar(100), mail varchar(1000) primary key, role varchar(100),"
	  	+ " mdp varchar(100) , adresse varchar(1000), num_tel varchar(10), nbr_cmd Integer)")
	void createUserTable();
	
    @SqlUpdate("Drop table if exists users")
    void dropUserTable();
	  
	@SqlUpdate("Insert into users(nom,prenom,mail,role,mdp,adresse,num_tel,nbr_cmd) values "
		+ "(:nom, :prenom , :mail , :role , :mdp , :adresse, :num_tel, :nbr_cmd)")
	void insertUser(@Bind("nom") String nom, @Bind("prenom") String prenom , @Bind("mail") String mail, @Bind("role") String role , @Bind("mdp") String mdp, @Bind("adresse") String adresse,@Bind("num_tel") String num_tel, @Bind("nbr_cmd") Integer nbr_cmd);
	
    @SqlUpdate("Delete from users where mail= :mail")
    void deleteUser(@Bind("mail") String mail);
	
	@SqlQuery("Select * from users ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<User> all(); 
	
	@SqlQuery("Select * from users where mail = :mail")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User findByMail(@Bind("mail") String mail);

    @SqlQuery("Select * from users order by nbr_cmd")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> orderByCmd();
	
	void close();
}
