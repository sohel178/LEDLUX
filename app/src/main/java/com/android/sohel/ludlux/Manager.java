package com.android.sohel.ludlux;

/**
 * Created by user on 13/03/2018.
 */

public class Manager {
    private int id;
    private String name;
    private String username;
    private String password;
    private String surname;

    public Manager() {
    }

    public Manager(int id, String name, String username, String password, String surname) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
