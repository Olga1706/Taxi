package com.solvd.taxi.dao;

import com.solvd.taxi.models.CustomersModel;

public interface ICustomersDAO {

    void createCustomers(CustomersModel customersModel);

    void updateCustomersById(CustomersModel customersModel);

    void deleteCustomersById(CustomersModel customersModel);

    CustomersModel getCustomers();

}

