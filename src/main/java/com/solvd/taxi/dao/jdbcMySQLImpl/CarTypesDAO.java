package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICarTypesDAO;
import com.solvd.taxi.models.CallOperatorsModel;
import com.solvd.taxi.models.CarTypesModel;
import com.solvd.taxi.models.CarsModel;
import com.solvd.taxi.utilites.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarTypesDAO implements ICarTypesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CarTypesDAO.class);

    final String DELETE = "DELETE FROM CarTypes WHERE id=?";
    final String GET = "SELECT * FROM CarTypes WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM CarTypes";
    final String INSERT = "INSERT INTO CarTypes VALUES (?, ?)";
    final String UPDATE = "UPDATE CarTypes SET name=? WHERE id=?";

    PreparedStatement stmt = null;
    ResultSet rs= null;

    @Override
    public void createCarTypes(CarTypesModel carTypesModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, carTypesModel.getId());
            stmt.setString(2, carTypesModel.getNameCar());
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
    public void updateCarTypesById(CarTypesModel carTypesModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setString(1, carTypesModel.getNameCar());
            stmt.setInt(2, carTypesModel.getId());
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
    public void deleteCarTypesById(CarTypesModel carTypesModel) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, carTypesModel.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE CarTypes WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public CarTypesModel getCarTypesById(int id) {
        Connection dbConnect = ConnectionDB.getConnection();
        CarTypesModel carTypesModel = new CarTypesModel();
        try {
            stmt = dbConnect.prepareStatement(GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                carTypesModel.setId(rs.getInt(1));
                carTypesModel.setNameCar(rs.getString(2));
                carTypesModel.toString();
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
        return carTypesModel;
    }

    public List<CarTypesModel> getALLCarTypes() {
        ArrayList<CarTypesModel> carTypes = new ArrayList<CarTypesModel>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CarTypesModel carTypesModel = new CarTypesModel();
                carTypesModel.setId(rs.getInt(1));
                carTypesModel.setNameCar(rs.getString(2));
                carTypes.add(carTypesModel);
                carTypesModel.toString();
            }
            LOGGER.info("ALL is OK!");
            LOGGER.info(carTypes);
        } catch (Exception e) {
            LOGGER.info(e);
        }
        finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return carTypes;
    }
}
