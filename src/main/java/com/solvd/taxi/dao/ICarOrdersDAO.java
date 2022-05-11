package com.solvd.taxi.dao;


import com.solvd.taxi.models.CallOperatorsModel;
import com.solvd.taxi.models.CarOrdersModel;

public interface ICarOrdersDAO {

    void createCarOrders(CarOrdersModel carOrders);

    void updateCarOrdersById(int id);

    void deleteCarOrdersById(int id);

    CarOrdersModel getCarOrdersById(int id);
}
