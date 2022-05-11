package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICarsDAO;
import com.solvd.taxi.models.CarOrdersModel;
import com.solvd.taxi.models.CarsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarsDAO implements ICarsDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarsDAO.class);

    @Override
    public void createCars(CarsModel cars) {

    }

    @Override
    public void updateCarOrdersById(int id) {

    }

    @Override
    public void deleteCarOrdersById(int id) {

    }

    @Override
    public CarOrdersModel getCarOrdersById(int id) {
        return null;
    }
}
