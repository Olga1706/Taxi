package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.IDriversDAO;
import com.solvd.taxi.models.CallOperatorsModel;
import com.solvd.taxi.models.CarServicesModel;
import com.solvd.taxi.models.CustomersModel;
import com.solvd.taxi.models.DriversModel;
import com.solvd.taxi.utilites.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriversDAO implements IDriversDAO {

    private static final Logger LOGGER = LogManager.getLogger(DriversDAO.class);

    final String DELETE = "DELETE FROM Drivers WHERE id=?";
    final String GET = "SELECT * FROM Drivers WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Drivers";
    final String INSERT = "INSERT INTO Drivers VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE Drivers SET date_of_start=? WHERE id=?";



    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void createDriver(DriversModel driversModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, driversModel.getId());
            stmt.setString(2, driversModel.getFirstName());
            stmt.setString(3, driversModel.getDayOfStart());
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
    public void updateDriverById(DriversModel driversModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setString(1, driversModel.getDayOfStart());
            stmt.setInt(2, driversModel.getId());
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
    public void deleteDriversById(DriversModel driversModel) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, driversModel.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Drivers WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public DriversModel getDriversById(int id) {
        Connection dbConnect = ConnectionDB.getConnection();
        DriversModel driversModel = new DriversModel();
        try {
            stmt = dbConnect.prepareStatement(GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                driversModel.setId(rs.getInt(1));
                driversModel.setFirstName(rs.getString(2));
                driversModel.setDayOfStart(rs.getString(3));
                driversModel.toString();
            }
            //LOGGER.info("ALL is OK!");
        } catch (Exception e) {
            LOGGER.info(e);
        }
        finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return driversModel;
    }

    public List<DriversModel> getAllDrivers() {
        ArrayList<DriversModel> drivers = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                DriversModel driversModel = new DriversModel();
                driversModel.setId(rs.getInt(1));
                driversModel.setFirstName(rs.getString(2));
                driversModel.setDayOfStart(rs.getString(3));
                drivers.add(driversModel);
                driversModel.toString();
            }
            LOGGER.info("ALL is OK!");
            LOGGER.info(drivers);
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return drivers;
    }
}
