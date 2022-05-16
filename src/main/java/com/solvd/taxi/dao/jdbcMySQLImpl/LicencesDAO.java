package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ILicencesDAO;
import com.solvd.taxi.models.CustomersModel;
import com.solvd.taxi.models.DriversModel;
import com.solvd.taxi.models.LicencesModel;
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
    final String GET = "SELECT * FROM License ORDER BY id";
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
    public LicencesModel getLicences() {
        List<LicencesModel> allLicences = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET);
            rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1)
                        + "\nNumber licence: " + rs.getString(2)
                        + "\nExploitation day: " + rs.getString(3)
                        + "\nDriver id: " + rs.getString(4));
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
        return null;
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
