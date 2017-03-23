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
            logger.debug("Create table users");
            dao.createUserTable();
            dao.insertUser(new MonUser("Thatcher", "Margaret","margaret@thatcher.uk", "user", "margarine", "azerty", "0606060606", 0));
        }
    }

    @POST
    public MonUserDto createUser(MonUserDto dto) {
        MonUser user = new MonUser();
        user.initFromDto(dto);
        user.resetPasswordHash();
        int id = dao.insertUser(user);
        dto.setId(id);
        return dto;
    }

    @GET
    @Path("/{name}")
    public MonUserDto getUser(@PathParam("name") String name) {
        MonUser user = dao.findByName(name);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user.convertToDto();
    }

    @GET
    public List<MonUserDto> getAllUsers(@QueryParam("q") String query) {
        List<MonUser> users;
        if (query == null) {
            users = dao.all();
        } else {
            logger.debug("Search users with query: " + query);
            users = dao.search("%" + query + "%");
        }
        return users.stream().map(MonUser::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
        dao.delete(id);
    }

}
