package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.IDriversDAO;
import com.solvd.taxi.models.DriversModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriversDAO implements IDriversDAO {

    private static final Logger LOGGER = LogManager.getLogger(DriversDAO.class);

    @Override
    public void createDriver(DriversModel driver) {

    }

    @Override
    public void updateDriverById(int id) {

    }

    @Override
    public void deleteDriversById(int id) {

    }

    @Override
    public DriversModel getDriverById(int id) {
        return null;
    }
}
