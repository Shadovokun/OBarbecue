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
            dao.insertProduit(new Produit("coca","boisson fraiche","img/coca", 2));
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
    @Path("/{id}")
    public void deleteProduit(@PathParam("nom") String nom) {
        dao.deleteProduits(nom);
    }

}
