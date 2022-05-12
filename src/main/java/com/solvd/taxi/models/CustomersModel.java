package com.solvd.taxi.models;

import java.util.List;

public class CustomersModel {
    private int id;
    private String firstName;
    private String lastName;
    private int rating;
    private String email;
    private CustomerTypesModel customerTypes;
    private List<OrdersModel> orders;

    public CustomersModel () {

    }

    public CustomersModel(int id, String firstName, String lastName, int rating,
                          String email, CustomerTypesModel customerTypes,
                          List<OrdersModel> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.email = email;
        this.customerTypes = customerTypes;
        this.orders = orders;
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

    public int getRating() {
        return rating;
    }

    public String getEmail() {
        return email;
    }

    public CustomerTypesModel getCustomerTypes() {
        return customerTypes;
    }

    public List<OrdersModel> getOrders() {
        return orders;
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

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerTypes(CustomerTypesModel customerTypes) {
        this.customerTypes = customerTypes;
    }

    public void setOrders(List<OrdersModel> orders) {
        this.orders = orders;
    }
}
