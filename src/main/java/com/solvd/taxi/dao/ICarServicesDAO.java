package com.solvd.taxi.dao;

import com.solvd.taxi.models.CarOrdersModel;
import com.solvd.taxi.models.CarServicesModel;

public interface ICarServicesDAO {

    void createCarServices(CarServicesModel carServices);

    void updateCarServicesById(int id);

    void deleteCarServicesById(int id);

    CarServicesModel getCarServicesById(int id);
}
