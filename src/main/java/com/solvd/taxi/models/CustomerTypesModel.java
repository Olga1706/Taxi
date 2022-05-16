package com.solvd.taxi.models;

public class CustomerTypesModel {
    private int id;
    private String types;
    private int discount;

    public CustomerTypesModel() {

    }

    public CustomerTypesModel(int id) {
        this.id = id;
    }

    public CustomerTypesModel(int id, String types, int discount) {
        this.id = id;
        this.types = types;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getTypes() {
        return types;
    }

    public int getDiscount() {
        return discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

