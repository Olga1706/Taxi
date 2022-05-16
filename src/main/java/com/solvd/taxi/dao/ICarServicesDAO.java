package com.solvd.taxi.dao;

import com.solvd.taxi.models.CarOrdersModel;
import com.solvd.taxi.models.CarServicesModel;

public interface ICarServicesDAO {


    void createCarServices(CarServicesModel carServicesModel);

    void updateCarServicesById(CarServicesModel carServicesModel);

    void deleteCarServicesById(CarServicesModel carServicesModel);

    CarServicesModel getCarServices();
}
