package com.solvd.taxi.dao;

import com.solvd.taxi.models.OrdersModel;

import java.util.List;

public interface IOrdersDAO {

    void createOrders(OrdersModel ordersModel);

    void updateOrdersById(OrdersModel ordersModel);

    void deleteOrdersById(OrdersModel ordersModel);

    OrdersModel getOrdersById(int id);

    List<OrdersModel> getAllOrders();
}
