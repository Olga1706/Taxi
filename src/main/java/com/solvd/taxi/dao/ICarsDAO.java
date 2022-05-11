package com.solvd.taxi.dao;

import com.solvd.taxi.models.CarOrdersModel;
import com.solvd.taxi.models.CarsModel;

public interface ICarsDAO {

    void createCars(CarsModel cars);

    void updateCarOrdersById(int id);

    void deleteCarOrdersById(int id);

    CarOrdersModel getCarOrdersById(int id);
}
