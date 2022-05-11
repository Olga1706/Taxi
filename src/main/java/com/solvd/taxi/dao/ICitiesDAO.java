package com.solvd.taxi.dao;

import com.solvd.taxi.models.CarOrdersModel;
import com.solvd.taxi.models.CarsModel;
import com.solvd.taxi.models.CitiesModel;

public interface ICitiesDAO {

    void createCities(CitiesModel cities);

    void updateCitiesById(int id);

    void deleteCitiesById(int id);

    CitiesModel getCitiesById(int id);
}
