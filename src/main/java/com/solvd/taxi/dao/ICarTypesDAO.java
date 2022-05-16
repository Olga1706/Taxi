package com.solvd.taxi.dao;

import com.solvd.taxi.models.CarServicesModel;
import com.solvd.taxi.models.CarTypesModel;

public interface ICarTypesDAO {

    void createCarTypes(CarTypesModel carTypesModel);

    void updateCarTypesById(CarTypesModel carTypesModel);

    void deleteCarTypesById(CarTypesModel carTypesModel);

    CarTypesModel getCarTypes();
}
