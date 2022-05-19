package com.solvd.taxi.dao;

import com.solvd.taxi.models.CarOrdersModel;
import com.solvd.taxi.models.CarsModel;
import com.solvd.taxi.models.CustomersModel;

import java.util.List;

public interface ICarsDAO {

    void createCars(CarsModel carsModel);

    void updateCarsById(CarsModel carsModel);

    void deleteCarsById(CarsModel carsModel);

    CarsModel getCarsModelById(int id);

    List<CarsModel> getAllCars();
}
