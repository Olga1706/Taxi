package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.IOrdersDAO;
import com.solvd.taxi.models.*;
import com.solvd.taxi.utilites.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO implements IOrdersDAO {

    private static final Logger LOGGER = LogManager.getLogger(OrdersDAO.class);

    final String DELETE = "DELETE FROM Orders WHERE id=?";
    final String GET = "SELECT * FROM Orders WHERE id=?";
    final String GET_ALL = "SELECT * FROM Orders";
    final String INSERT = "INSERT INTO Orders VALUES (?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE Orders SET total=? WHERE id=?";
   final String RIGHT_JOIN = "SELECT Orders.id, Drivers.f_name, Drivers.date_of_start FROM Orders RIGHT JOIN Drivers ON Orders.driver_id = Drivers.id  ORDER BY Orders.id";


    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void createOrders(OrdersModel ordersModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, ordersModel.getId());
            stmt.setString(2, ordersModel.getTime());
            stmt.setDouble(3, ordersModel.getTotal());
            stmt.setString(4, ordersModel.getFromAddress());
            stmt.setString(5, ordersModel.getToAddress());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records inserted");
        } catch (Exception e) {
            LOGGER.info(e);
        }
        finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public void updateOrdersById(OrdersModel ordersModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setDouble(1, ordersModel.getTotal());
            stmt.setInt(2, ordersModel.getId());
            int i = stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.info(e);
        }
        finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public void deleteOrdersById(OrdersModel ordersModel) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, ordersModel.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Orders WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public OrdersModel getOrdersById(int id) {
        Connection dbConnect = ConnectionDB.getConnection();
        OrdersModel ordersModel = new OrdersModel();
        CustomersModel customersModel = new CustomersModel();
        CarsModel carsModel = new CarsModel();
        DriversModel driversModel = new DriversModel();
        CallOperatorsModel callOperatorsModel = new CallOperatorsModel();
        try {
            stmt = dbConnect.prepareStatement(GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ordersModel.setId(rs.getInt(1));
                ordersModel.setTime(rs.getString(2));
                customersModel.setId(rs.getInt("customer_id"));
                ordersModel.setCustomersModels(customersModel);
                carsModel.setId(rs.getInt("car_id"));
                ordersModel.setCarsModels(carsModel);
                driversModel.setId(rs.getInt("driver_id"));
                ordersModel.setDriversModels(driversModel);
                ordersModel.setFromAddress(rs.getString(6));
                ordersModel.setToAddress(rs.getString(7));
                ordersModel.setTotal(rs.getDouble(8));
                callOperatorsModel.setId(rs.getInt("operators_id"));
                ordersModel.setCallOperatorsModels(callOperatorsModel);
                ordersModel.toString();
            }
            LOGGER.info("ALL is OK!");
        } catch (Exception e) {
            LOGGER.info(e);
        }
        finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return ordersModel;
    }

    @Override
    public List<OrdersModel> getAllOrders() {
        ArrayList<OrdersModel> orders = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                OrdersModel ordersModel = new OrdersModel();
                ordersModel.setId(rs.getInt(1));
                ordersModel.setTime(rs.getString(2));
                CustomersDAO dao = new CustomersDAO();
                ordersModel.setCustomersModels(dao.getCustomersById(rs.getInt("customer_id")));
                CarsDAO dao1 = new CarsDAO();
                ordersModel.setCarsModels(dao1.getCarsModelById(rs.getInt("car_id")));
                DriversDAO dao2 = new DriversDAO();
                ordersModel.setDriversModels(dao2.getDriversById(rs.getInt("driver_id")));
                ordersModel.setFromAddress(rs.getString(6));
                ordersModel.setToAddress(rs.getString(7));
                ordersModel.setTotal(rs.getDouble(8));
                CallOperatorsDAO dao3 = new CallOperatorsDAO();
                ordersModel.setCallOperatorsModels(dao3.getCallOperatorsById(rs.getInt("operators_id")));
                orders.add(ordersModel);
                ordersModel.toString();
            }
            LOGGER.info("ALL is OK!");
            LOGGER.info(orders);
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return orders;
    }

    public List<OrdersModel> getOrdersRightJoinDrivers() {
        ArrayList<OrdersModel> allOrders = new ArrayList<>();
        DriversModel driversModel = new DriversModel();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(RIGHT_JOIN);
            rs = stmt.executeQuery();
            while (rs.next()) {
                OrdersModel ordersModel = new OrdersModel();
                ordersModel.setId(rs.getInt("id"));
                driversModel.setFirstName(rs.getString("f_name"));
                ordersModel.setDriversModels(driversModel);
                driversModel.setDayOfStart(rs.getString("date_of_start"));
                ordersModel.setDriversModels(driversModel);
                allOrders.add(ordersModel);
            }
            LOGGER.info("ALL is OK!");
            LOGGER.info(allOrders);
        } catch (Exception e) {
            LOGGER.info(e);
        }
        finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return allOrders;
    }
}
