package fr.iutinfo.skeleton.api;

import java.sql.Date;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface CommandeDao {
	
    @SqlUpdate("Create table commande(id serial  primary key, dat date ,mail varchar(100),nom varchar(100), prix double ,constraint fk_mail foreign key(mail) references user(mail),constraint fk_produit foreign key(nom) references produit(nom)")
    void createCommandeTable();
    
    @SqlUpdate("Drop table if exists commande")
    void dropCommandeTable();
    
    @SqlUpdate("insert into commande(dat,mail_user,nom_,prix) values (:dat, :mail, :nom_produit, :prix)")
    void insertCommande(@Bind("dat") Date dat , @Bind("mail") String mail_user,@Bind("nom") String nom_produit,@Bind("prix") double prix);

    @SqlUpdate("Delete from commande where id= :id")
    void deleteCommande(@Bind("idl") int id);
    
	@SqlQuery("Select * from commande ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Commande> all();
	
	@SqlQuery("Select * from commande where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Commande> findById(@Bind("id") int id);
	
    @SqlQuery("Select * from commande order by dat")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Commande> orderByDate();
    
    void close();
}
