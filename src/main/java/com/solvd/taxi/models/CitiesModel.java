package com.solvd.taxi.models;

import java.util.List;
import java.util.Properties;

public class CitiesModel {

    private int id;
    private String cityName;
    private List<String> addresses;

    public CitiesModel() {

    }

    public CitiesModel(int id) {
        this.id = id;
    }


    public CitiesModel(int id, String cityName, List<String> addresses) {
        this.id = id;
        this.cityName = cityName;
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "CitiesModel{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
