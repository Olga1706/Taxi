package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.IAddressesDAO;
import com.solvd.taxi.models.AddressesModel;
import com.solvd.taxi.models.CallOperatorsModel;
import com.solvd.taxi.utilites.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressesDAO implements IAddressesDAO {

    private static final Logger LOGGER = LogManager.getLogger(AddressesDAO.class);

    final String DELETE = "DELETE FROM Address WHERE id=?";
    final String GET = "SELECT * FROM Address ORDER BY id";
    final String INSERT = "INSERT INTO Address VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE Address SET zip=? WHERE id=?";

    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public void createAddresses(AddressesModel addresses) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, addresses.getId());
            stmt.setInt(2, addresses.getZipCode());
            stmt.setInt(3, addresses.getCitiesModel().getId());
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
    public void updateAddressesById(AddressesModel addresses) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setInt(1, addresses.getZipCode());
            stmt.setInt(2, addresses.getId());
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
    public void deleteAddressesById(AddressesModel addresses) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, addresses.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Addresses WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }


    }

    @Override
    public AddressesModel getAddresses() {
        List<AddressesModel> allAddresses = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET);
            rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1)
                        + "\nZip code: " + rs.getString(2)
                        + "\nCities: " + rs.getString(3));
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
