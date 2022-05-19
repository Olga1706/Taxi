package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICustomerTypesDAO;
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

public class CustomerTypesDAO implements ICustomerTypesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CustomerTypesDAO.class);

    final String DELETE = "DELETE FROM CustomerTypes WHERE id=?";
    final String GET = "SELECT * FROM CustomerTypes WHERE id=?";
    final String INSERT = "INSERT INTO CustomerTypes VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE CustomerTypes SET discount=? WHERE id=?";

    PreparedStatement stmt = null;
    ResultSet rs= null;

    @Override
    public void createCustomerTypes(CustomerTypesModel customerTypes) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, customerTypes.getId());
            stmt.setString(2, customerTypes.getTypes());
            stmt.setInt(3, customerTypes.getDiscount());
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
    public void updateCustomerTypesById(CustomerTypesModel customerTypes) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setInt(1, customerTypes.getDiscount());
            stmt.setInt(2, customerTypes.getId());
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
    public void deleteCustomerTypesById(CustomerTypesModel customerTypes) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, customerTypes.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE CustomerType WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }

    }

    @Override
    public CustomerTypesModel getCustomerTypesById(int id) {
        Connection dbConnect = ConnectionDB.getConnection();
        CustomerTypesModel customerTypesModel = new CustomerTypesModel();
        try {
            stmt = dbConnect.prepareStatement(GET);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                customerTypesModel.setId(rs.getInt(1));
                customerTypesModel.setTypes(rs.getString(2));
                customerTypesModel.setDiscount(rs.getInt(3));
                customerTypesModel.toString();
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
        return customerTypesModel;
    }
}

