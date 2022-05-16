package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICallOperatorsDAO;
import com.solvd.taxi.models.CallOperatorsModel;
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

public class CallOperatorsDAO implements ICallOperatorsDAO {

    private static final Logger LOGGER = LogManager.getLogger(CallOperatorsDAO.class);

    final String DELETE = "DELETE FROM CallOperators WHERE id=?";
    final String GET = "SELECT * FROM CallOperators ORDER BY id";
    final String INSERT = "INSERT INTO CallOperators VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE CallOperators SET l_name=? WHERE id=?";

    PreparedStatement stmt = null;
    ResultSet rs= null;

    @Override
    public void createCallOperators(CallOperatorsModel callOperators) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(INSERT);
            stmt.setInt(1, callOperators.getId());
            stmt.setString(2, callOperators.getFirstName());
            stmt.setString(3, callOperators.getLastName());
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
    public void updateCallOperatorsById(CallOperatorsModel callOperators) {
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(UPDATE);
            stmt.setString(1, callOperators.getLastName());
            stmt.setInt(2, callOperators.getId());
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
    public void deleteCallOperatorsById(CallOperatorsModel callOperators) {
        int x = 0;

        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(DELETE);
            stmt.setInt(1, callOperators.getId());
            int i = stmt.executeUpdate();
            LOGGER.info(i + " records deleted");
        } catch (SQLException e) {
            LOGGER.error("ERROR DELETE CallOperators WITH ID " + e.getMessage());
            x = 1;
        } finally {
            ConnectionDB.close(stmt);
            ConnectionDB.close(dbConnect);
            ConnectionDB.close(rs);
        }
    }

    @Override
    public CallOperatorsModel getCallOperators() {
        List<CallOperatorsModel> allCallOperators = new ArrayList<>();
        Connection dbConnect = ConnectionDB.getConnection();
        try {
            stmt = dbConnect.prepareStatement(GET);
            rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("\nId: " + rs.getInt(1)
                        + "\nFirst name: " + rs.getString(2)
                        + "\nLast name: " + rs.getString(3));
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
