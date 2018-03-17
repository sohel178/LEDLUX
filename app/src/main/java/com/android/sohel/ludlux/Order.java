package com.android.sohel.ludlux;

/**
 * Created by user on 13/03/2018.
 */

public class Order {
    private int id;
    private int employeeId;
    private int managerId;
    private int customerId;
    private String date;

    public Order() {
    }

    public Order(int id, int employeeId, int managerId, int customerId, String date) {
        this.id = id;
        this.employeeId = employeeId;
        this.managerId = managerId;
        this.customerId = customerId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "com.android.sohel.ludlux.Order{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", managerId=" + managerId +
                ", customerId=" + customerId +
                ", date='" + date + '\'' +
                '}';
    }
}