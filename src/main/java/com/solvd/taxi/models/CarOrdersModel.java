package com.solvd.taxi.models;

import java.util.List;

public class CarOrdersModel {
    private int id;
    private double totalPrice;
    private List<CarsModel> carsModels;
    private List<CarServicesModel> carServicesModels;

    public CarOrdersModel() {

    }

    public CarOrdersModel(int id, double totalPrice, List<CarsModel> carsModels,
                          List<CarServicesModel> carServicesModels) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.carsModels = carsModels;
        this.carServicesModels = carServicesModels;
    }

    public int getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<CarsModel> getCarsModels() {
        return carsModels;
    }

    public List<CarServicesModel> getCarServicesModels() {
        return carServicesModels;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCarsModels(List<CarsModel> carsModels) {
        this.carsModels = carsModels;
    }

    public void setCarServicesModels(List<CarServicesModel> carServicesModels) {
        this.carServicesModels = carServicesModels;
    }
}
