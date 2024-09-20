package com.ucodeacademy.jdbc;

import com.ucodeacademy.utility.ConfigReader;
import org.junit.Test;

import java.sql.*;

public class DatabaseConnection {

    String dbUrl = "jdbc:oracle:thin:@54.208.138.198:1521/xepdb1";
    String username = "hr";
    String password = "hr";
    //String username = ConfigReader.getProperty("dbUsername"); // if you want to get from .properties
    //String password = ConfigReader.getProperty("dbPassword");  // if you want to get from .properties

    @Test
    public void firstDatabaseTest() throws SQLException {

        // 1. Create Connection to Oracle/HR database
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        // 2. Create statement using connection
        //Statement statement = connection.createStatement(); -> this only goes down the rows

        // 2. this allows us go up and down
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        // 3. Create result and store our query result
        ResultSet resultSet = statement.executeQuery("select * from employees");

        resultSet.next(); // -> move to next row

        System.out.println(resultSet.getString(2));

        // we always need to close all connections at the end
        connection.close();
        statement.close();
        resultSet.close();

    }

    @Test
    public void secondDatabaseTest() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees");

        // loop through the resultSet and print first name and last name

        while (resultSet.next()){
            //String s = resultSet.getString("first_name");
           // System.out.println(s);
            System.out.println(resultSet.getString("first_name")+" "+ resultSet.getString("last_name"));
        }

        // closing all connections
        resultSet.close();
        statement.close();
        connection.close();

    }
}
