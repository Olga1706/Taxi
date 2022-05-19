package com.solvd.taxi.dao;


import com.solvd.taxi.models.CallOperatorsModel;
import com.solvd.taxi.models.CarOrdersModel;

import java.util.List;

public interface ICarOrdersDAO {

    void createCarOrders(CarOrdersModel carOrders);

    void updateCarOrdersById(CarOrdersModel carOrders);

    void deleteCarOrdersById(CarOrdersModel carOrders);

    CarOrdersModel getCarOrdersById(int id);

    List<CarOrdersModel> getAllCarOrders();
}
