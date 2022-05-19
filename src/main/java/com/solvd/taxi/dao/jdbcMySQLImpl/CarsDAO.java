package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICarsDAO;
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

public class CarsDAO implements ICarsDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarsDAO.class);

    final String DELETE = "DELETE FROM Cars WHERE id=?";
    final String GET = "SELECT * FROM Cars WHERE id=?";
    final String GET_ALL = "SELECT * FROM Cars";
    final String INSERT = "INSERT INTO Cars VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE Cars SET number=? WHERE id=?";

    PreparedStatement stmt = null;
    ResultSet rs= null;

    @Override
    public void createCars(CarsModel carsModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, carsModel.getId());
            stmt.setString(2, carsModel.getNumberCar());
            stmt.setInt(3, carsModel.getCarTypesModel().getId());
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
    public void updateCarsById(CarsModel carsModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setString(1, carsModel.getNumberCar());
            stmt.setInt(2, carsModel.getId());
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
    public void deleteCarsById(CarsModel carsModel) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, carsModel.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Cars WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public CarsModel getCarsModelById(int id) {
        Connection dbConnect = ConnectionDB.getConnection();
        CarsModel carsModel = new CarsModel();
        CarTypesModel carTypesModel = new CarTypesModel();
        try {
            stmt = dbConnect.prepareStatement(GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                carsModel.setId(rs.getInt(1));
                carsModel.setNumberCar(rs.getString(2));
                carTypesModel.setId(rs.getInt("id"));
                carsModel.setCarTypesModel(carTypesModel);
                carsModel.toString();
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
        return carsModel;
    }

    @Override
    public List<CarsModel> getAllCars() {
        ArrayList<CarsModel> cars = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CarsModel carsModel = new CarsModel();
                carsModel.setId(rs.getInt(1));
                carsModel.setNumberCar(rs.getString(2));
                CarTypesDAO dao = new CarTypesDAO();
                carsModel.setCarTypesModel(dao.getCarTypesById(rs.getInt("car_type_id")));
                cars.add(carsModel);
                carsModel.toString();
            }
            LOGGER.info("ALL is OK!");
            LOGGER.info(cars);
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return cars;
    }
}
