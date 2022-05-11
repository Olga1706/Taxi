package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.IOrdersDAO;
import com.solvd.taxi.models.OrdersModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrdersDAO implements IOrdersDAO {

    private static final Logger LOGGER = LogManager.getLogger(OrdersDAO.class);

    @Override
    public void createOrder(OrdersModel order) {

    }

    @Override
    public void updateOrderById(int id) {

    }

    @Override
    public void deleteOrderById(int id) {

    }

    @Override
    public OrdersModel getOrderById(int id) {
        return null;
    }
}
