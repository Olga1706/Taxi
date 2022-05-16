package com.solvd.taxi.dao;

import com.solvd.taxi.models.OrdersModel;

public interface IOrdersDAO {

    void createOrders(OrdersModel ordersModel);

    void updateOrdersById(OrdersModel ordersModel);

    void deleteOrdersById(OrdersModel ordersModel);

    OrdersModel getOrders();
}
