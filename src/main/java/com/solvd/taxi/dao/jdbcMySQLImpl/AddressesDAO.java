package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.IAddressesDAO;
import com.solvd.taxi.models.AddressesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressesDAO implements IAddressesDAO {

    private static final Logger LOGGER = LogManager.getLogger(AddressesDAO.class);

    @Override
    public void createAddresses(AddressesModel addresses) {

    }

    @Override
    public void updateAddressesById(int id) {

    }

    @Override
    public void deleteAddressesById(int id) {

    }

    @Override
    public AddressesModel getAddressesById(int id) {
        return null;
    }
}
