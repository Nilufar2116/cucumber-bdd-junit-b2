package com.ucodeacademy.jdbc;

import com.ucodeacademy.utility.ConfigReader;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePractice7 {
    String dbUrl = "jdbc:oracle:thin:@54.208.138.198:1521/xepdb1";
    String username = ConfigReader.getProperty("dbUsername"); // getting from .properties
    String password = ConfigReader.getProperty("dbPassword"); // getting from .properties

    @Test
    public void createNewTable() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = connection.createStatement();

        statement.executeUpdate("""
                 create table table1(
                 table_id NUMBER(10) PRIMARY KEY,
                 first_name VARCHAR(30),
                 last_name VARCHAR(30)
                 )
                """);
        statement.close();
        connection.close();
    }

    @Test
    public void dropNewlyCreatedTable() throws SQLException{
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = connection.createStatement();
        statement.executeUpdate("drop table table1");

        statement.close();
        connection.close();

    }
}
