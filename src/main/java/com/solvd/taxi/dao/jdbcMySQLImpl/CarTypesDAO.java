package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICarTypesDAO;
import com.solvd.taxi.models.CarTypesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarTypesDAO implements ICarTypesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarTypesDAO.class);

    @Override
    public void createCarTypes(CarTypesModel carTypes) {

    }

    @Override
    public void updateCarTypesById(int id) {

    }

    @Override
    public void deleteCarTypesById(int id) {

    }

    @Override
    public CarTypesModel getCarTypesById(int id) {
        return null;
    }
}
