package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICarServicesDAO;
import com.solvd.taxi.models.CarServicesModel;
import com.solvd.taxi.models.CarTypesModel;
import com.solvd.taxi.models.CustomerTypesModel;
import com.solvd.taxi.models.CustomersModel;
import com.solvd.taxi.utilites.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarServicesDAO implements ICarServicesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarServicesDAO.class);

    final String DELETE = "DELETE FROM Autoservices WHERE id=?";
    final String GET = "SELECT * FROM Autoservices WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Autoservices";
    final String INSERT = "INSERT INTO Autoservices VALUES (?, ?)";
    final String UPDATE = "UPDATE Autoservices SET name=? WHERE id=?";

    PreparedStatement stmt = null;
    ResultSet rs= null;

    @Override
    public void createCarServices(CarServicesModel carServicesModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, carServicesModel.getId());
            stmt.setString(2, carServicesModel.getNaming());
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
    public void updateCarServicesById(CarServicesModel carServicesModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setString(1, carServicesModel.getNaming());
            stmt.setInt(2, carServicesModel.getId());
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
    public void deleteCarServicesById(CarServicesModel carServicesModel) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, carServicesModel.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE CarServices WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public CarServicesModel getCarServicesById(int id) {
        Connection dbConnect = ConnectionDB.getConnection();
        CarServicesModel carServicesModel = new CarServicesModel();
        try {
            stmt = dbConnect.prepareStatement(GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                carServicesModel.setId(rs.getInt(1));
                carServicesModel.setNaming(rs.getString(2));
                carServicesModel.toString();
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
        return carServicesModel;
    }

    public List<CarServicesModel> getAllCarServices() {
        ArrayList<CarServicesModel> carServices = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CarServicesModel carServicesModel = new CarServicesModel();
                carServicesModel.setId(rs.getInt("id"));
                carServicesModel.setNaming(rs.getString("name"));
                carServices.add(carServicesModel);
                carServicesModel.toString();
            }
            LOGGER.info("ALL is OK!");
            LOGGER.info(carServices);
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return carServices;
    }
}
