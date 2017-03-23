package fr.iutinfo.skeleton.web;

import fr.iutinfo.skeleton.api.MonUser;

import java.util.List;

public class SecureDto {
    private List<MonUser> users;
    private MonUser currentUser;

    public void setUsers(List<MonUser> users) {
        this.users = users;
    }

    public List<MonUser> getUsers() {
        return users;
    }

    public void setCurrentUser(MonUser currentUser) {
        this.currentUser = currentUser;
    }

    public MonUser getCurrentUser() {
        return currentUser;
    }

}
