package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICitiesDAO;
import com.solvd.taxi.models.CitiesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CitiesDAO implements ICitiesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CitiesDAO.class);

    @Override
    public void createCities(CitiesModel cities) {

    }

    @Override
    public void updateCitiesById(int id) {

    }

    @Override
    public void deleteCitiesById(int id) {

    }

    @Override
    public CitiesModel getCitiesById(int id) {
        return null;
    }
}
