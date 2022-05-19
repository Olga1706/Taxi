package com.solvd.taxi.models;

import java.util.List;

public class CarOrdersModel {
    private int id;
    private CarsModel carsModel;
    private CarServicesModel carServicesModel;
    private double totalPrice;


    public CarOrdersModel() {
    }

    public CarOrdersModel(int id, double totalPrice, CarsModel carsModel, CarServicesModel carServicesModel) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.carsModel = carsModel;
        this.carServicesModel = carServicesModel;
    }

    public CarOrdersModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public CarsModel getCarsModel() {
        return carsModel;
    }

    public CarServicesModel getCarServicesModel() {
        return carServicesModel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCarsModel(CarsModel carsModel) {
        this.carsModel = carsModel;
    }

    public void setCarServicesModel(CarServicesModel carServicesModel) {
        this.carServicesModel = carServicesModel;
    }

    @Override
    public String toString() {
        return "CarOrdersModel{" +
                "id=" + id +
                ", carsModel=" + carsModel +
                ", carServicesModel=" + carServicesModel +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

