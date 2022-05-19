package com.solvd.taxi.models;

import java.util.List;

public class DriversModel{
    private int id;
    private String firstName;
    private String dayOfStart;



    public DriversModel() {

    }

    public DriversModel(int id, String firstName, String dayOfStart) {
        this.id = id;
        this.firstName = firstName;
        this.dayOfStart = dayOfStart;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDayOfStart(String dayOfStart) {
        this.dayOfStart = dayOfStart;
    }

    @Override
    public String toString() {
        return "DriversModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", dayOfStart='" + dayOfStart + '\'' +
                '}';
    }
}
