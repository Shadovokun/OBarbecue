package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface ProduitDao {
	
    @SqlUpdate("Create table produits(nom varchar(100)  primary key, description varchar(1000), cheminImg varchar(100), prix double )")
    void createProduitsTable();
    
    @SqlUpdate("Drop table if exists produits")
    void dropProduitsTable(); 
    
    @SqlUpdate("Insert into produits(nom,description,cheminImg,prix) values (:nom, :description, :cheminImg, :prix)")
    @GetGeneratedKeys
    int insertProduit(@BindBean() Produit prod);
    
    @SqlUpdate("Delete from produits where nom= :nom")
    void deleteProduits(@Bind("nom") String nom);
    
	@SqlQuery("Select * from produits ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Produit> all();
	
	@SqlQuery("Select * from produits where nom = :nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Produit findByNom(@Bind("nom") String nom);
    
    @SqlQuery("Select * from produits order by nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Produit> orderByNom();
    
    @SqlQuery("select * from produit where search like :name")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Produit> search(@Bind("name") String name);
    
    void close();

	
}
