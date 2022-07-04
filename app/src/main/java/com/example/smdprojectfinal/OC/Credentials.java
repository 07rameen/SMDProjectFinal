package com.example.smdprojectfinal.OC;

public class Credentials {
    String username,password;


    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Credentials() {
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
