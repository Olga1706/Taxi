package com.solvd.taxi.dao;

import com.solvd.taxi.models.CarServicesModel;
import com.solvd.taxi.models.CarTypesModel;

public interface ICarTypesDAO {

    void createCarTypes(CarTypesModel carTypes);

    void updateCarTypesById(int id);

    void deleteCarTypesById(int id);

    CarTypesModel getCarTypesById(int id);
}
