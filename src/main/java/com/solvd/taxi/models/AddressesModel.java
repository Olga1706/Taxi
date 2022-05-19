package com.solvd.taxi.models;

public class AddressesModel {
    private int id;
    private int zipCode;
    private CitiesModel citiesModel;

    public AddressesModel() {

    }

    public AddressesModel(int id, int zipCode, CitiesModel citiesModel) {
        this.id = id;
        this.zipCode = zipCode;
        this.citiesModel = citiesModel;
    }

    public AddressesModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getZipCode() {
        return zipCode;
    }

    public CitiesModel getCitiesModel() {
        return citiesModel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setCitiesModel(CitiesModel citiesModel) {
        this.citiesModel = citiesModel;
    }

    @Override
    public String toString() {
        return "AddressesModel{" +
                "id=" + id +
                ", zipCode=" + zipCode +
                ", citiesModel=" + citiesModel +
                '}';
    }
}
