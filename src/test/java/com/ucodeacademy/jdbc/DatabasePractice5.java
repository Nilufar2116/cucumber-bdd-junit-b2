package com.ucodeacademy.jdbc;

import com.ucodeacademy.utility.ConfigReader;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasePractice5 {
    String dbUrl = "jdbc:oracle:thin:@54.208.138.198:1521/xepdb1";
    String username = ConfigReader.getProperty("dbUsername"); // getting from .properties
    String password = ConfigReader.getProperty("dbPassword"); // getting from .properties

    @Test
    public void practiceDatabaseMetaData() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        DatabaseMetaData databaseMetaData = connection.getMetaData();

        // get database connection info
        System.out.println(databaseMetaData.getConnection());
        System.out.println(databaseMetaData.getMaxColumnsInIndex());

        System.out.println(databaseMetaData.getDriverName());
        System.out.println(databaseMetaData.getDriverVersion());

        System.out.println(databaseMetaData.allTablesAreSelectable());

        System.out.println(databaseMetaData.getUserName());
        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getDatabaseProductVersion());

        connection.close();

    }

}
