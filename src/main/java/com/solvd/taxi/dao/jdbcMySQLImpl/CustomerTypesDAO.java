package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICustomerTypesDAO;
import com.solvd.taxi.models.CustomerTypesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerTypesDAO implements ICustomerTypesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CustomerTypesDAO.class);

    @Override
    public void createCustomerTypes(CustomerTypesModel customerTypes) {

    }

    @Override
    public void updateCustomerTypesById(int id) {

    }

    @Override
    public void deleteCustomerTypesById(int id) {

    }

    @Override
    public CustomerTypesModel getCustomerTypesById(int id) {
        return null;
    }
}

