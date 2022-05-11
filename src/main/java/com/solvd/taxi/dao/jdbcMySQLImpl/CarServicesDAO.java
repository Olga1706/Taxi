package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICarServicesDAO;
import com.solvd.taxi.models.CarServicesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarServicesDAO implements ICarServicesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarServicesDAO.class);

    @Override
    public void createCarServices(CarServicesModel carServices) {

    }

    @Override
    public void updateCarServicesById(int id) {

    }

    @Override
    public void deleteCarServicesById(int id) {

    }

    @Override
    public CarServicesModel getCarServicesById(int id) {
        return null;
    }
}
