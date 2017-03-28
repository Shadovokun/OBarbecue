package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.ProduitDto;

@Path("/produit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProduitsRessource {
    final static Logger logger = LoggerFactory.getLogger(ProduitsRessource.class);
    private static ProduitDao dao = getDbi().open(ProduitDao.class);
    
    public ProduitsRessource() throws SQLException {
        if (!tableExist("produits")) {
            dao.createProduitsTable();
            
            
            // assiette
            dao.insertProduit(new Produit( "Assiette1" ,"1/2 Poulet + accompagnement + boisson 33 cl","",10.5,"assiette"));
            dao.insertProduit(new Produit( "Assiette2" ,"Ribs + accompagnement + boisson 33 cl","",10.5,"assiette"));
            dao.insertProduit(new Produit( "Assiette3" ,"Assiette végétarienne + steak végétariens + accompagnement + boisson 33 cl","",10.5,"assiette"));
            // a emporter
            dao.insertProduit(new Produit("Poulet1","1/2 Poulet","",6.5,"aEmporter"));
            dao.insertProduit(new Produit("Poulet2","Poulet entier","",12.5,"aEmporter"));
            dao.insertProduit(new Produit("Poulet3","Pilons","",8,"aEmporter"));
            dao.insertProduit(new Produit("Poulet4","Cuisses","",8,"aEmporter"));
            dao.insertProduit(new Produit("Poulet5","Blanc","",8,"aEmporter"));
            dao.insertProduit(new Produit("Poulet6","Ailes","",8,"aEmporter"));
            // sandwich
            dao.insertProduit(new Produit("Sandwich1","Sandwich froid au poulet + boisson 33cl","",5,"sandwich"));
            dao.insertProduit(new Produit("Sandwich2","Sandwich chaud poulet ou saucisse + boisson 33cl","",5.5,"sandwich"));
            dao.insertProduit(new Produit("Sandwich3","Pyramides Sucrées/Salées","",2.5,"sandwich"));
            // accompagnements
            dao.insertProduit(new Produit("Accompagnement1","Riz","",2.5,"accompagnement"));
            dao.insertProduit(new Produit("Accompagnemen2","Pâtes","",2.5,"accompagnement"));
            dao.insertProduit(new Produit("Accompagnement3","Frites","",2.5,"accompagnement"));
            dao.insertProduit(new Produit("Accompagnement4","Pomme de Terre","",2.5,"accompagnement"));
            // boisson
            dao.insertProduit(new Produit("Boisson1","Soda 33cl","",1.5,"boisson"));
            dao.insertProduit(new Produit("Boisson2","Eau Plates 33cl","",1.0,"boisson"));
            dao.insertProduit(new Produit("Boisson3","Eau Gazeuses 33cl","",1.5,"boisson"));
            dao.insertProduit(new Produit("Boisson4","Grande Bouteilles","",2.5,"boisson"));
            dao.insertProduit(new Produit("Boisson5","Café","",1.3,"boisson"));
            dao.insertProduit(new Produit("Boisson6","Cappucino","",2,"boisson"));
            dao.insertProduit(new Produit("Boisson7","Thé","",1.3,"boisson"));
            // salade 
            dao.insertProduit(new Produit("Salade1","Assiette salade saison poulet","",6.5,"salade"));
            dao.insertProduit(new Produit("Salade2","Assiette salade saison végétarienne","",7.5,"salade"));
            // dessert 
            dao.insertProduit(new Produit("Dessert1","Tiramissu","",2.5,"dessert"));
            dao.insertProduit(new Produit("Dessert2","Crêpes","",2.5,"dessert"));
        }
    }
    
    @POST
    public ProduitDto createProduit(ProduitDto dto) {
        Produit prod = new Produit();
        prod.initFromDto(dto);
        int id = dao.insertProduit(prod);
        return dto;
    }
    
    @GET
    @Path("/{name}")
    public ProduitDto getProduit(@PathParam("name") String name) {
    	Produit prod = dao.findByNom(name);
        if (prod == null) {
            throw new WebApplicationException(404);
        }
        return prod.convertToDto();
    }
    
    @GET
    public List<ProduitDto> getAllProduit(@QueryParam("q") String query) {
        List<Produit> prod;
        prod = dao.all();
        return prod.stream().map(Produit::convertToDto).collect(Collectors.toList());
    }
    
    @DELETE
    @Path("/{nom}")
    public void deleteProduit(@PathParam("nom") String nom) {
		logger.debug("delete produit: " + nom);
	    dao.deleteProduits(nom);
		logger.debug("Rechercher : "  + dao.search("%"+nom+"%").size());
    }

}
