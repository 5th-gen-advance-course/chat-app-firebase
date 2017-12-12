package com.example.ratha.chatapp.enity;

/**
 * Created by ratha on 12/12/2017.
 */

public class User {
    private int id;
    private String name;
    private String neckName;
    private String email;

    public User() {}
    public User(int id, String name, String neckName, String email) {
        this.id = id;
        this.name = name;
        this.neckName = neckName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeckName() {
        return neckName;
    }

    public void setNeckName(String neckName) {
        this.neckName = neckName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", neckName='" + neckName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
