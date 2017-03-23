package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface ProduitDao {
	
    @SqlUpdate("Create table produits(nom varchar(100)  primary key, description varchar(10000), chemin_img varchar(100), prix double )")
    void createProduitsTable();
    
    @SqlUpdate("Drop table if exists produits")
    void dropProduitsTable();
    
    
    @SqlUpdate("insert into produits(nom,description,chemin_img,prix) values (:nom, :description, :chemin, :prix)")
    void insertProduits(@Bind("nom") String nom, @Bind("description") String description, @Bind("chemin") String chemin, @Bind("prix") double prix);

    @SqlUpdate("Delete from produits where nom= :nom")
    void deleteProduits(@Bind("nom") String nom);
    
	@SqlQuery("Select * from produits ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Produit> all();
	
	@SqlQuery("Select * from produits where nom = :nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Produit> findByNom(@Bind("nom") String nom);
    
    @SqlQuery("Select * from produits order by nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Produit> orderByNom();
    
    void close();
}
