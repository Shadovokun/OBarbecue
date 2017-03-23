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

import fr.iutinfo.skeleton.common.dto.CommentaireDTO;
import fr.iutinfo.skeleton.common.dto.ProduitDto;
import fr.iutinfo.skeleton.common.dto.UserDto;

@Path("/Commentaire")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentaireRessource {
    final static Logger logger = LoggerFactory.getLogger(CommentaireRessource.class);
    private static CommentaireDAO dao = getDbi().open(CommentaireDAO.class);

    public CommentaireRessource() throws SQLException {
        if (!tableExist("Commentaire")) {
            dao.createCommentaireTable();
            dao.insertCommentaire(new Commentaire(2,"miam miam","16/05/2017","tutu@hotmail.fr",3));
        }
    }
    
    @POST
    public CommentaireDTO createCommentaire(CommentaireDTO dto) {
    	Commentaire com = new Commentaire();
        int id = dao.insertCommentaire(com);
        return dto;
    }
    
    @GET
    @Path("/{name}")
    public CommentaireDTO getCommentaire(@PathParam("id") int id) {
    	Commentaire com = dao.findById(id);
        if (com == null) {
            throw new WebApplicationException(404);
        }
        return com.convertToDto();
    }
    
    @GET
    public List<CommentaireDTO> getAllCommentaire(@QueryParam("q") String query) {
        List<Commentaire> com;
        com = dao.all();
        return com.stream().map(Commentaire::convertToDto).collect(Collectors.toList());
    }
}