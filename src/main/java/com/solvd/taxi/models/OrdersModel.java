package com.solvd.taxi.models;

import java.util.List;

public class OrdersModel {
    private int id;
    private String time;
    private double total;
    private CustomersModel customersModels;
    private CarsModel carsModels;
    private DriversModel driversModels;
    private String fromAddress;
    private String toAddress;
    private CallOperatorsModel callOperatorsModels;

    public OrdersModel() {

    }

    public OrdersModel(int id, String time, double total, CustomersModel customersModels, CarsModel carsModels,
                       DriversModel driversModels, String fromAddress, String toAddress,
                       CallOperatorsModel callOperatorsModels) {
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

    public CustomersModel getCustomersModels() {
        return customersModels;
    }

    public CarsModel getCarsModels() {
        return carsModels;
    }

    public DriversModel getDriversModels() {
        return driversModels;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public CallOperatorsModel getCallOperatorsModels() {
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

    public void setCustomersModels(CustomersModel customersModels) {
        this.customersModels = customersModels;
    }

    public void setCarsModels(CarsModel carsModels) {
        this.carsModels = carsModels;
    }

    public void setDriversModels(DriversModel driversModels) {
        this.driversModels = driversModels;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public void setCallOperatorsModels(CallOperatorsModel callOperatorsModels) {
        this.callOperatorsModels = callOperatorsModels;
    }

    @Override
    public String toString() {
        return "OrdersModel{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", total=" + total +
                ", customersModels=" + customersModels +
                ", carsModels=" + carsModels +
                ", driversModels=" + driversModels +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", callOperatorsModels=" + callOperatorsModels +
                '}';
    }
}
