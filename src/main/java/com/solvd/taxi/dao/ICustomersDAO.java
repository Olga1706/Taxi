package com.solvd.taxi.dao;

import com.solvd.taxi.models.CustomersModel;

public interface ICustomersDAO {

    void createCustomer(CustomersModel customer);

    void updateCustomerById(int rating, int id);

    void deleteCustomerById(int id);

    CustomersModel getCustomerById(int id);

}

