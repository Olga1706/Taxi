package com.solvd.taxi.dao;

import com.solvd.taxi.models.CustomersModel;

import java.util.List;

public interface ICustomersDAO {

    void createCustomers(CustomersModel customersModel);

    void updateCustomersById(CustomersModel customersModel);

    void deleteCustomersById(CustomersModel customersModel);

    CustomersModel getCustomersById(int id);

    List<CustomersModel> getAllCustomers();

}

