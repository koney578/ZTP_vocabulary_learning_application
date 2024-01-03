package org.example;
public class User {
    private static int idGenerate = 0;
    int id;
    String name;
    String username;
    String email;
    String password;

    public User(String name,String username,String email,String password){
        idGenerate = idGenerate + 1;
        this.id = idGenerate;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
