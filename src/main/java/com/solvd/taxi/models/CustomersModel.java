package com.solvd.taxi.models;

import java.util.List;

public class CustomersModel extends PersonModel{
    private int id;
    private int rating;
    private String email;
    private PersonModel person;
    private CustomerTypesModel customerTypes;
    private List<OrdersModel> orders;

    public CustomersModel () {

    }

    public CustomersModel(int id, String firstName, String lastName,
                          int id1, int rating, String email, PersonModel person,
                          CustomerTypesModel customerTypes, List<OrdersModel> orders) {
        super(id, firstName, lastName);
        this.id = id1;
        this.rating = rating;
        this.email = email;
        this.person = person;
        this.customerTypes = customerTypes;
        this.orders = orders;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getEmail() {
        return email;
    }

    public PersonModel getPerson() {
        return person;
    }

    public CustomerTypesModel getCustomerTypes() {
        return customerTypes;
    }

    public List<OrdersModel> getOrders() {
        return orders;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }

    public void setCustomerTypes(CustomerTypesModel customerTypes) {
        this.customerTypes = customerTypes;
    }

    public void setOrders(List<OrdersModel> orders) {
        this.orders = orders;
    }
}
