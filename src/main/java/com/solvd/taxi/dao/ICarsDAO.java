package com.solvd.taxi.dao;

import com.solvd.taxi.models.CarOrdersModel;
import com.solvd.taxi.models.CarsModel;

public interface ICarsDAO {

    void createCars(CarsModel carsModel);

    void updateCarsById(CarsModel carsModel);

    void deleteCarsById(CarsModel carsModel);

    CarsModel getCarsModel();
}
