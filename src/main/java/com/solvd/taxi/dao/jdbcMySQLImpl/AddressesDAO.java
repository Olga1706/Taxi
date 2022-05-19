package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.IAddressesDAO;
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

public class AddressesDAO implements IAddressesDAO {

    private static final Logger LOGGER = LogManager.getLogger(AddressesDAO.class);

    final String DELETE = "DELETE FROM Address WHERE id=?";
    final String GET = "SELECT * FROM Address WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM Address";
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
    public AddressesModel getAddressesById(int id) {
        Connection dbConnect = ConnectionDB.getConnection();
        AddressesModel addressesModel = new AddressesModel();
        CitiesModel citiesModel = new CitiesModel();
        try {
            stmt = dbConnect.prepareStatement(GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                addressesModel.setId(rs.getInt(1));
                addressesModel.setZipCode(rs.getInt(2));
                citiesModel.setId(rs.getInt("id"));
                addressesModel.setCitiesModel(citiesModel);
                addressesModel.toString();
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
        return addressesModel;
    }

    public List<AddressesModel> getAllAddresses() {
        ArrayList<AddressesModel> addresses = new ArrayList<>();
        CitiesModel citiesModel = new CitiesModel();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AddressesModel addressesModel = new AddressesModel();
                addressesModel.setId(rs.getInt(1));
                addressesModel.setZipCode(rs.getInt(2));
                CitiesDAO dao = new CitiesDAO();
                addressesModel.setCitiesModel(dao.getCitiesById(rs.getInt("cities_id")));
                addresses.add(addressesModel);
                addressesModel.toString();
            }
            LOGGER.info("ALL is OK!");
            LOGGER.info(addresses);
        } catch (Exception e) {
            LOGGER.info(e);
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return addresses;
    }
}
