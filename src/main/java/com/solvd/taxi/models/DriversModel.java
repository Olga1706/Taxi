package com.solvd.taxi.models;

import java.util.List;

public class DriversModel {
    private int id;
    private String firstName;
    private String lastName;
    private String dayOfStart;
   // private List<OrdersModel> orders;
   // private List<LicensesModel> licenses;


    public DriversModel() {

    }

    public DriversModel(int id, String firstName, String lastName, String dayOfStart) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfStart = dayOfStart;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDayOfStart(String dayOfStart) {
        this.dayOfStart = dayOfStart;
    }
}
