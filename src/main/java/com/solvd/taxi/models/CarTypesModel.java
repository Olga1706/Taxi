package com.solvd.taxi.models;

public class CarTypesModel {
    private int id;
    private String nameCar;

    public CarTypesModel() {

    }

    public CarTypesModel(int id, String nameCar) {
        this.id = id;
        this.nameCar = nameCar;
    }

    public int getId() {
        return id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }
}
