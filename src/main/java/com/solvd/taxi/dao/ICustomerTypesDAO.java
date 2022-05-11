package com.solvd.taxi.dao;

import com.solvd.taxi.models.CustomerTypesModel;
import com.solvd.taxi.models.CustomersModel;

public interface ICustomerTypesDAO {

    void createCustomerTypes(CustomerTypesModel customerTypes);

    void updateCustomerTypesById(int id);

    void deleteCustomerTypesById(int id);

    CustomerTypesModel getCustomerTypesById(int id);
}
