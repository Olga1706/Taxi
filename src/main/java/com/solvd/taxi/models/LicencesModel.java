package com.solvd.taxi.models;

public class LicencesModel {
    private int id;
    private String number;
    private String expDate;
    private DriversModel driversModel;

    public LicencesModel() {

    }

    public LicencesModel(int id, String number, String expDate, DriversModel driversModel) {
        this.id = id;
        this.number = number;
        this.expDate = expDate;
        this.driversModel = driversModel;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getExpDate() {
        return expDate;
    }

    public DriversModel getDriversModel() {
        return driversModel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setDriversModel(DriversModel driversModel) {
        this.driversModel = driversModel;
    }

    @Override
    public String toString() {
        return "LicencesModel{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", expDate='" + expDate + '\'' +
                ", driversModel=" + driversModel +
                '}';
    }
}
