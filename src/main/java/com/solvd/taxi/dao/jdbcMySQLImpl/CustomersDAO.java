package com.solvd.taxi.dao.jdbcMySQLImpl;


import com.solvd.taxi.dao.ICustomersDAO;
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

public class CustomersDAO implements ICustomersDAO {

    private static final Logger LOGGER = LogManager.getLogger(CustomersDAO.class);

   // private static final String FIND_ALL = "SELECT * FROM customers ORDER BY id";

    final String DELETE = "DELETE FROM Customers WHERE id=?";
    final String GET = "SELECT * FROM Customers ORDER BY id";
    final String INSERT = "INSERT INTO customers VALUES (?, ?, ?, ?, ?,?)";
    final String UPDATE = "UPDATE Customers SET rating=? WHERE id=?";
    final String INNERJOIN = "SELECT Customers.f_name, Customers.l_name, Customers.email, Orders.time, Orders.total FROM Orders INNER JOIN Customers ON Orders.customer_id = Customers.id";


    PreparedStatement stmt = null;
    ResultSet rs = null;



    @Override
    public void createCustomers(CustomersModel customersModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, customersModel.getId());
            stmt.setString(2, customersModel.getFirstName());
            stmt.setString(3, customersModel.getLastName());
            stmt.setInt(4, customersModel.getRating());
            stmt.setString(5, customersModel.getEmail());
            stmt.setInt(6, customersModel.getCustomerTypes().getId());
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
    public void updateCustomersById(CustomersModel customersModel) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setInt(1, customersModel.getRating());
            stmt.setInt(2, customersModel.getId());
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
    public void deleteCustomersById(CustomersModel customersModel) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, customersModel.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE Customers WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public CustomersModel getCustomers() {
        List<CustomersModel> allCustomers = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
           stmt = dbConnect.prepareStatement(GET);
           rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1)
                        + "\nFirst name: " + rs.getString(2)
                        + "\nLast name: " + rs.getString(3)
                        + "\nRating: " + rs.getString(4)
                        + "\nEmail: " + rs.getString(5)
                        + "\nCustomer Types id: " + rs.getString(6));
            }
            LOGGER.info("ALL is OK!");
        } catch (Exception e) {
            LOGGER.info(e);
        }
        /*finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
        return null;
    }

    public List<CustomersModel> getCustomersInnerJoinOrders() {
        ArrayList<CustomersModel> allCustomers = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INNERJOIN);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CustomersModel customersModel = new CustomersModel();
                //customersModel.setId(rs.getInt("id"));
                customersModel.setFirstName(rs.getString("f_name"));
                customersModel.setFirstName(rs.getString("l_name"));
                customersModel.setEmail(rs.getString("email"));
                customersModel.setTime(rs.getString("time"));
                customersModel.setTotal(rs.getDouble("total"));
                allCustomers.add(customersModel);
            }
            LOGGER.info("ALL is OK!");
            return allCustomers;
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
