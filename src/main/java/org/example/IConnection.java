package org.example;

import java.util.List;

public interface IConnection {
    public List<User> getUsers();
    public void addUser(String name, String username, String email, String password);
}
