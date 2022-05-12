package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICustomersDAO;
import com.solvd.taxi.models.CustomersModel;
import com.solvd.taxi.utilites.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomersDAO implements ICustomersDAO {

    private static final Logger LOGGER = LogManager.getLogger(CustomersDAO.class);

    final String DELETE = "DELETE FROM customers WHERE id=?";
    final String GET = "SELECT * FROM customers WHERE Doctors_id = ?";
    final String INSERT = "INSERT INTO customers VALUES (?, ?, ?,?)";
    final String UPDATE = "UPDATE customers SET rating=? WHERE id=?";


    @Override
    public void createCustomer(CustomersModel customer) {

    }

    @Override
    public void updateCustomerById(int rating, int id) {
        try (Connection dbConnect = ConnectionDB.getConnection()) {

            PreparedStatement stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setInt(1, rating);
            stmt.setInt(2, id);

        } catch (Exception e) {
            LOGGER.info(e);
        }

    }

    @Override
    public void deleteCustomerById(int id) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        PreparedStatement delete = null;
        try {
            delete = dbConnect.prepareStatement(DELETE);
            delete.setInt(1, id);
            int i = delete.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Customers WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(delete);
            ConnectionDB.close(dbConnect);
            if (x == 0) {
                LOGGER.info("SUCCESS CLOSE");
            } else
                LOGGER.info("FAIL CLOSE");
        }

    }

    @Override
    public CustomersModel getCustomerById(int id) {
        return null;
    }

}
