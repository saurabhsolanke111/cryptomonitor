package com.monitor.entities;

public class User {
    int id;
    String name;
    String email;
    Double maxAlertVal;
    Double minAlertVal;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMaxAlertVal() {
        return maxAlertVal;
    }

    public void setMaxAlertVal(Double maxAlertVal) {
        this.maxAlertVal = maxAlertVal;
    }

    public Double getMinAlertVal() {
        return minAlertVal;
    }

    public void setMinAlertVal(Double minAlertVal) {
        this.minAlertVal = minAlertVal;
    }
}
