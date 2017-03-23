package fr.iutinfo.skeleton.common.remote;

import fr.iutinfo.skeleton.api.Api;
import fr.iutinfo.skeleton.api.BDDFactory;
import fr.iutinfo.skeleton.api.MonUser;
import fr.iutinfo.skeleton.api.MonUserDao;
import fr.iutinfo.skeleton.common.dto.MonUserDto;
import fr.iutinfo.skeleton.common.dto.UserDto;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UsersProviderIntegrationTest extends JerseyTest {

    private MonUserDao userDao = BDDFactory.getDbi().open(MonUserDao.class);
    private UsersProvider usersProvider = new UsersProvider(getBaseUri().toString());

    @Override
    protected Application configure() {
        return new Api();
    }

   /* @Test
    public void should_read_remote_user() {
        initDatabase();
        createUser("Thomas");

        MonUserDto user = usersProvider.readUser("Thomas");
        Assert.assertEquals("Thomas", user.getNom());
    }

    @Test
    public void should_read_all_remote_user() {
        initDatabase();
        createUser("Thomas");
        createUser("Olivier");

        List<MonUserDto> users = usersProvider.readAllUsers();
        Assert.assertEquals(2, users.size());
    }

    @Test
    public void should_add_remote_user() {
        initDatabase();
        MonUserDto olivier = new MonUserDto();
        olivier.setNom("Olivier");

        MonUserDto remoteUser = usersProvider.addUser(olivier);
        MonUser bddUser = userDao.findByMail(remoteUser.getMail());

        Assert.assertEquals("Olivier", bddUser.getName());
    }*/


    private void createUser(String name) {
        MonUser thomas = new MonUser();
        thomas.setNom(name);
        userDao.insertUsers(thomas);
    }

    private void initDatabase() {
        userDao.dropUserTable();
        userDao.createUserTable();
    }
}
