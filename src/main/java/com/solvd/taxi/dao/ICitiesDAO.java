package com.solvd.taxi.dao;

import com.solvd.taxi.models.CarOrdersModel;
import com.solvd.taxi.models.CarsModel;
import com.solvd.taxi.models.CitiesModel;

public interface ICitiesDAO {

    void createCities(CitiesModel citiesModel);

    void updateCitiesById(CitiesModel citiesModel);

    void deleteCitiesById(CitiesModel citiesModel);

    CitiesModel getCities();
}
