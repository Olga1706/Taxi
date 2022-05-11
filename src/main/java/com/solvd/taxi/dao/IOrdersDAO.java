package com.solvd.taxi.dao;

import com.solvd.taxi.models.LicensesModel;
import com.solvd.taxi.models.OrdersModel;

public interface IOrdersDAO {

    void createOrder(OrdersModel order);

    void updateOrderById(int id);

    void deleteOrderById(int id);

    OrdersModel getOrderById(int id);
}
