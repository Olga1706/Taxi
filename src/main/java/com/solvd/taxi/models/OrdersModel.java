package com.solvd.taxi.models;

import java.util.List;

public class OrdersModel {
    private int id;
    private String time;
    private double total;
    private List<CustomersModel> customersModels;
    private List<CarsModel> carsModels;
    private List<DriversModel> driversModels;
    private String fromAddress;
    private String toAddress;
    private List<CallOperatorsModel> callOperatorsModels;

    public OrdersModel() {

    }

    public OrdersModel(int id, String time, double total,
                       List<CustomersModel> customersModels, List<CarsModel> carsModels,
                       List<DriversModel> driversModels, String fromAddress, String toAddress,
                       List<CallOperatorsModel> callOperatorsModels) {
        this.id = id;
        this.time = time;
        this.total = total;
        this.customersModels = customersModels;
        this.carsModels = carsModels;
        this.driversModels = driversModels;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.callOperatorsModels = callOperatorsModels;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public double getTotal() {
        return total;
    }

    public List<CustomersModel> getCustomersModels() {
        return customersModels;
    }

    public List<CarsModel> getCarsModels() {
        return carsModels;
    }

    public List<DriversModel> getDriversModels() {
        return driversModels;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public List<CallOperatorsModel> getCallOperatorsModels() {
        return callOperatorsModels;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCustomersModels(List<CustomersModel> customersModels) {
        this.customersModels = customersModels;
    }

    public void setCarsModels(List<CarsModel> carsModels) {
        this.carsModels = carsModels;
    }

    public void setDriversModels(List<DriversModel> driversModels) {
        this.driversModels = driversModels;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public void setCallOperatorsModels(List<CallOperatorsModel> callOperatorsModels) {
        this.callOperatorsModels = callOperatorsModels;
    }
}
