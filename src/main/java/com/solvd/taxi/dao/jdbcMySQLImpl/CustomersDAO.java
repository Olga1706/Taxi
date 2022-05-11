package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICustomersDAO;
import com.solvd.taxi.models.CustomersModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomersDAO implements ICustomersDAO {

    private static final Logger LOGGER = LogManager.getLogger(CustomersDAO.class);

    @Override
    public void createCustomer(CustomersModel customer) {

    }

    @Override
    public void updateCustomerById(int id) {

    }

    @Override
    public void deleteCustomerById(int id) {

    }

    @Override
    public CustomersModel getCustomerById(int id) {
        return null;
    }

}
