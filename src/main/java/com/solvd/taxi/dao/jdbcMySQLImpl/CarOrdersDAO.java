package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICarOrdersDAO;
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

public class CarOrdersDAO implements ICarOrdersDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarOrdersDAO.class);

    final String DELETE = "DELETE FROM CarOrders WHERE id=?";
    final String GET = "SELECT * FROM CarOrders WHERE id=?";
    final String GET_ALL = "SELECT * FROM CarOrders";
    final String INSERT = "INSERT INTO CarOrders VALUES (?, ?)";
    final String UPDATE = "UPDATE CarOrders SET total=? WHERE id=?";

    PreparedStatement stmt = null;
    ResultSet rs= null;

    @Override
    public void createCarOrders(CarOrdersModel carOrders) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, carOrders.getId());
            stmt.setInt(2, carOrders.getCarsModel().getId());
            stmt.setInt(3,carOrders.getCarServicesModel().getId());
            stmt.setDouble(4, carOrders.getTotalPrice());
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
    public void updateCarOrdersById(CarOrdersModel carOrders) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setDouble(1, carOrders.getTotalPrice());
            stmt.setInt(2, carOrders.getId());
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
    public void deleteCarOrdersById(CarOrdersModel carOrders) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, carOrders.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE CarOrders WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public CarOrdersModel getCarOrdersById(int id) {
        Connection dbConnect = ConnectionDB.getConnection();
        CarOrdersModel carOrdersModel = new CarOrdersModel();
        CarsModel carsModel = new CarsModel();
        CarServicesModel carServicesModel = new CarServicesModel();
        try {
            stmt = dbConnect.prepareStatement(GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                carOrdersModel.setId(rs.getInt(1));
                carsModel.setId(rs.getInt("id"));
                carOrdersModel.setCarsModel(carsModel);
                carServicesModel.setId(rs.getInt("id"));
                carOrdersModel.setCarServicesModel(carServicesModel);
                carOrdersModel.setTotalPrice(rs.getInt(4));
                carOrdersModel.toString();
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
        return carOrdersModel;
    }

    @Override
    public List<CarOrdersModel> getAllCarOrders() {
        ArrayList<CarOrdersModel> carOrders = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CarOrdersModel carOrdersModel = new CarOrdersModel();
                carOrdersModel.setId(rs.getInt(1));
                CarsDAO dao = new CarsDAO();
                carOrdersModel.setCarsModel(dao.getCarsModelById(rs.getInt("car_id")));
                CarServicesDAO dao1 = new CarServicesDAO();
                carOrdersModel.setCarServicesModel(dao1.getCarServicesById(rs.getInt("autoservice_id")));
                carOrdersModel.setTotalPrice(rs.getInt(4));
                carOrders.add(carOrdersModel);
                carOrdersModel.toString();
            }
            LOGGER.info("ALL is OK!");
            LOGGER.info(carOrders);
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return carOrders;
    }
}
