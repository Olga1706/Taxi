package com.solvd.taxi.models;

public class CarsModel {
    private int id;
    private String numberCar;
    private CarTypesModel carTypesModel;

    public CarsModel() {

    }

    public CarsModel(int id, String numberCar, CarTypesModel carTypesModel) {
        this.id = id;
        this.numberCar = numberCar;
        this.carTypesModel = carTypesModel;
    }

    public CarsModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public CarTypesModel getCarTypesModel() {
        return carTypesModel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public void setCarTypesModel(CarTypesModel carTypesModel) {
        this.carTypesModel = carTypesModel;
    }

    @Override
    public String toString() {
        return "CarsModel{" +
                "id=" + id +
                ", numberCar='" + numberCar + '\'' +
                ", carTypesModel=" + carTypesModel +
                '}';
    }
}
