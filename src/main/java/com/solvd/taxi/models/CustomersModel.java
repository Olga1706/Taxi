package com.solvd.taxi.models;

import java.util.List;

public class CustomersModel {
    private int id;
    private String firstName;
    private String lastName;
    private int rating;
    private String email;
    private CustomerTypesModel customerTypes;
    private OrdersModel orders;

    public CustomersModel () {

    }

    public CustomersModel(int id, String firstName, String lastName, int rating,
                          String email, CustomerTypesModel customerTypes,
                          OrdersModel orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.email = email;
        this.customerTypes = customerTypes;
        this.orders = orders;
    }


    public CustomersModel(int id) {
        this.id = id;
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

    public OrdersModel getOrders() {
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

    public void setOrders(OrdersModel orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CustomersModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rating=" + rating +
                ", email='" + email + '\'' +
                ", customerTypes=" + customerTypes +
                ", orders=" + orders +
                '}';
    }
}
