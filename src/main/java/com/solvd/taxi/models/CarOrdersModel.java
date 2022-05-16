package com.solvd.taxi.models;

import java.util.List;

public class CarOrdersModel {
    private int id;
    private double totalPrice;
    private CarsModel carsModel;
    private CarServicesModel carServicesModel;
   // private List<CarsModel> carsModels;
   // private List<CarServicesModel> carServicesModels;

    public CarOrdersModel() {

    }


    public CarOrdersModel(int id, double totalPrice, CarsModel carsModel, CarServicesModel carServicesModel) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.carsModel = carsModel;
        this.carServicesModel = carServicesModel;
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
}
