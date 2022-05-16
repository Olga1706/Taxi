package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICitiesDAO;
import com.solvd.taxi.models.AddressesModel;
import com.solvd.taxi.models.CitiesModel;
import com.solvd.taxi.utilites.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitiesDAO implements ICitiesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CitiesDAO.class);

    final String DELETE = "DELETE FROM Cities WHERE id=?";
    final String GET = "SELECT * FROM Cities ORDER BY id";
    final String INSERT = "INSERT INTO Cities VALUES (?, ?)";
    final String UPDATE = "UPDATE Cities SET name=? WHERE id=?";

    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void createCities(CitiesModel citiesModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, citiesModel.getId());
            stmt.setString(2, citiesModel.getCityName());
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
    public void updateCitiesById(CitiesModel citiesModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setString(1, citiesModel.getCityName());
            stmt.setInt(2, citiesModel.getId());
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
    public void deleteCitiesById(CitiesModel citiesModel) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, citiesModel.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Cities WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public CitiesModel getCities() {
        List<CitiesModel> allCities = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET);
            rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1)
                        + "\nCities: " + rs.getString(2));
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
}
