package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICarOrdersDAO;
import com.solvd.taxi.models.CarOrdersModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarOrdersDAO implements ICarOrdersDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarOrdersDAO.class);

    @Override
    public void createCarOrders(CarOrdersModel carOrders) {

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
