package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ILicencesDAO;
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

public class LicencesDAO implements ILicencesDAO {

    private static final Logger LOGGER = LogManager.getLogger(LicencesDAO.class);


    final String DELETE = "DELETE FROM License WHERE id=?";
    final String GET = "SELECT * FROM License WHERE id=?";
    final String GET_ALL = "SELECT * FROM License";
    final String INSERT = "INSERT INTO License VALUES (?, ?, ?, ?)";
    final String UPDATE = "UPDATE License SET exp_day=? WHERE id=?";
    //final String INNERJOIN = "SELECT License.id, License.number, License.exp_day, Drivers.f_name, FROM Drivers INNER JOIN License ON License.driver_id = License.id";


    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void createLicences(LicencesModel licencesModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, licencesModel.getId());
            stmt.setString(2, licencesModel.getNumber());
            stmt.setString(3, licencesModel.getExpDate());
            stmt.setInt(4, licencesModel.getDriversModel().getId());
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
    public void updateLicencesById(LicencesModel licencesModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setString(1, licencesModel.getExpDate());
            stmt.setInt(2, licencesModel.getId());
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
    public void deleteLicencesById(LicencesModel licencesModel) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, licencesModel.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Licences WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public LicencesModel getLicencesById(int id) {
        Connection dbConnect = ConnectionDB.getConnection();
        LicencesModel licencesModel = new LicencesModel();
        DriversModel driversModel = new DriversModel();
        try {
            stmt = dbConnect.prepareStatement(GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                licencesModel.setId(rs.getInt(1));
                licencesModel.setNumber(rs.getString(2));
                licencesModel.setExpDate(rs.getString(3));
                driversModel.setId(rs.getInt("id"));
                licencesModel.setDriversModel(driversModel);
                licencesModel.toString();
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
        return licencesModel;
    }

    @Override
    public List<LicencesModel> getAllLicences() {
        ArrayList<LicencesModel> licences = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                LicencesModel licencesModel = new LicencesModel();
                licencesModel.setId(rs.getInt(1));
                licencesModel.setNumber(rs.getString(2));
                licencesModel.setExpDate(rs.getString(3));
                DriversDAO dao = new DriversDAO();
                licencesModel.setDriversModel(dao.getDriversById(rs.getInt("driver_id")));
                licences.add(licencesModel);
                licencesModel.toString();
            }
            LOGGER.info("ALL is OK!");
            LOGGER.info(licences);
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return licences;
    }
/*
    public List<LicencesModel> getLicencesInnerJoinDrivers() {
        ArrayList<LicencesModel> allLicences = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INNERJOIN);
            rs = stmt.executeQuery();
            while (rs.next()) {
                LicencesModel licencesModel = new LicencesModel();
                licencesModel.setId(rs.getInt("id"));
                licencesModel.setNumber(rs.getString("number"));
                licencesModel.setExpDate(rs.getString("exp_day"));
                licencesModel.setFirstName(rs.getString("f_name"));
                allLicences.add(licencesModel);
            }
            LOGGER.info("ALL is OK!");
            return allLicences;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return null;
    }
*/

}
