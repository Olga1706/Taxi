package com.solvd.taxi.models;

import java.util.List;

public class DriversModel{
    private int id;
    private String firstName;
    private String dayOfStart;
    private List<OrdersModel> ordersModel;
    private List<LicencesModel> licencesModel;


    public DriversModel() {

    }

    public DriversModel(int id, String firstName, String dayOfStart,
                        List<OrdersModel> ordersModel,
                        List<LicencesModel> licencesModel) {
        this.id = id;
        this.firstName = firstName;
        this.dayOfStart = dayOfStart;
        this.ordersModel = ordersModel;
        this.licencesModel = licencesModel;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDayOfStart() {
        return dayOfStart;
    }

    public List<OrdersModel> getOrdersModel() {
        return ordersModel;
    }

    public List<LicencesModel> getLicencesModel() {
        return licencesModel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDayOfStart(String dayOfStart) {
        this.dayOfStart = dayOfStart;
    }

    public void setOrdersModel(List<OrdersModel> ordersModel) {
        this.ordersModel = ordersModel;
    }

    public void setLicencesModel(List<LicencesModel> licencesModel) {
        this.licencesModel = licencesModel;
    }
}
