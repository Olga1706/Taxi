package com.solvd.taxi.dao;


import com.solvd.taxi.models.CallOperatorsModel;
import com.solvd.taxi.models.CarOrdersModel;

public interface ICarOrdersDAO {

    void createCarOrders(CarOrdersModel carOrders);

    void updateCarOrdersById(CarOrdersModel carOrders);

    void deleteCarOrdersById(CarOrdersModel carOrders);

    CarOrdersModel getCarOrders();
}
