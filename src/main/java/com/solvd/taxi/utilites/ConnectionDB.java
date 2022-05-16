package com.solvd.taxi.utilites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ResourceBundle;

public class ConnectionDB {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionDB.class);

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
/*  */
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String USERNAME = resource.getString("db.username");
    String PASSWORD = resource.getString("db.password");
    String DBURL = resource.getString("db.url");





    private static ConnectionDB singleInstance = new ConnectionDB();

    private ConnectionDB() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.info("An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info("An error occured while trying to close the connection");
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.info("An error occured while trying to close the statement");
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.info("An error occured while trying to close the ResultSet");
            }
        }
    }

}
