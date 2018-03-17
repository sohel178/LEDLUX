package com.android.sohel.ludlux;

import android.widget.ImageView;

/**
 * Created by user on 13/03/2018.
 */

public class Worker {
    private int id;
    private String name;
    private int daysOn;
    private int daysOff;
    private String username;
    private String password;

    public Worker(int id, String name, int daysOn, int daysOff, String username, String password) {
        this.id = id;
        this.name = name;
        this.daysOn = daysOn;
        this.daysOff = daysOff;
        this.username = username;
        this.password = password;
    }

    public Worker() {
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

    public int getDaysOn() {
        return daysOn;
    }

    public void setDaysOn(int daysOn) {
        this.daysOn = daysOn;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
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

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", daysOn=" + daysOn +
                ", daysOff=" + daysOff +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
/**
     * Created by user on 13/03/2018.
     */
}