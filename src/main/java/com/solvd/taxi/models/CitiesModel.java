package com.solvd.taxi.models;

import java.util.List;
import java.util.Properties;

public class CitiesModel {

    private int id;
    private String cityName;


    public CitiesModel() {

    }

    public CitiesModel(int id) {
        this.id = id;
    }


    public CitiesModel(int id, String cityName) {
        this.id = id;
        this.cityName = cityName;

    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    @Override
    public String toString() {
        return "CitiesModel{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
