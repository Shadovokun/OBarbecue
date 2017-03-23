package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.CommandeDto;
import fr.iutinfo.skeleton.common.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

@Path("/commande")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommandeRessource {
    final static Logger logger = LoggerFactory.getLogger(CommandeRessource.class);
    private static CommandeDao dao = getDbi().open(CommandeDao.class);

    public CommandeRessource() throws SQLException {
        if (!tableExist("commande")) {
            dao.createCommandeTable();
            dao.insertCommande(new Commande(0, "23/03/2017", "test@test.fr", "Menu1", 8.0));
        }
    }

    @POST
    public CommandeDto createCommande(CommandeDto dto) {
    	Commande commande = new Commande();
    	commande.initFromDto(dto);
        int id = dao.insertCommande(commande);
        return dto;
    }

    @GET
    @Path("/{name}")
    public CommandeDto getCommande(@PathParam("name") String name) {
    	Commande commande = dao.findByName(name);
        if (commande == null) {
            throw new WebApplicationException(404);
        }
        return commande.convertToDto();
    }

    @GET
    public List<CommandeDto> getAllCommandes(@QueryParam("q") String query) {
        List<Commande> commandes;
        commandes = dao.all();

        return commandes.stream().map(Commande::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public void deleteCommande(@PathParam("id") int id) {
        dao.deleteCommande(id);
    }

}
