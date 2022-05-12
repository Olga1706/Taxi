package com.solvd.taxi.models;

public class CarServicesModel {
    private int id;
    private String naming;

    public CarServicesModel() {

    }

    public CarServicesModel(int id, String naming) {
        this.id = id;
        this.naming = naming;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public String getNaming() {
        return naming;
    }
}
