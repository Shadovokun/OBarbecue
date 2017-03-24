package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.MonUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MonUserResource {
    final static Logger logger = LoggerFactory.getLogger(MonUserResource.class);
    private static MonUserDao dao = getDbi().open(MonUserDao.class);

    public MonUserResource() throws SQLException {
        if (!tableExist("users")) {
            dao.createUserTable();
            dao.insertUsers(new MonUser("toto","toto","toto@hotmail.fr","admin","bonjour", "42 rue de la soif","0606060606", 5));
        }
    }

    @POST
    public MonUserDto createUser(MonUserDto dto) {
        MonUser user = new MonUser();
        user.initFromDto(dto);
        int id = dao.insertUsers(user);
        return dto;
    }

    @GET
    @Path("/{name}")
    public MonUserDto getUser(@PathParam("mail") String mail) {
        MonUser user = dao.findByMail(mail);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user.convertToDto();
    }

    @GET
    public List<MonUserDto> getAllUsers(@QueryParam("q") String query) {
        List<MonUser> users;
        users = dao.all();
        return users.stream().map(MonUser::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("mail") String mail) {
        dao.deleteUser(mail);
    }
    
    //Vérifie si l'utilisateur existe.
    @GET
    public String connexion(@PathParam("mail") String mail, @PathParam("mdp") String mdp) {
    	MonUser user = dao.findByMailAndMdp(mail, mdp);
    	if(user != null){
    		return user.getRole();
    	} else {
    		return null;
    	}
    }
    

}
