package fr.iutinfo.skeleton.api;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface MonUserDao {
	
	@SqlUpdate("Create table users(nom varchar(100), prenom varchar(100), mail varchar(1000) primary key, role varchar(100),"
	  	+ " mdp varchar(100) , adresse varchar(1000), numTel varchar(10), nbrCmd Integer)")
	void createUserTable();
	
    @SqlUpdate("Drop table if exists users")
    void dropUserTable();
	  
	@SqlUpdate("Insert into users(nom,prenom,mail,role,mdp,adresse,numTel,nbrCmd) values "
		+ "(:nom, :prenom , :mail , :role , :mdp , :adresse, :numTel, :nbrCmd)")
    @GetGeneratedKeys
    int insertUsers(@BindBean() MonUser user);
	
    @SqlUpdate("Delete from users where mail= :mail")
    void deleteUser(@Bind("mail") String mail);
	
	@SqlQuery("Select * from users ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<MonUser> all(); 
	
	@SqlQuery("Select * from users where mail = :mail")
	@RegisterMapperFactory(BeanMapperFactory.class)
	MonUser findByMail(@Bind("mail") String mail);

    @SqlQuery("Select * from users order by nbrCmd")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<MonUser> orderByCmd();
    
	@SqlQuery("Select * from users where mail = :mail and mdp = :mdp")
	@RegisterMapperFactory(BeanMapperFactory.class)
	MonUser findByMailAndMdp(@Bind("mail") String mail, @Bind("mdp") String mdp);
	
	void close();
}
