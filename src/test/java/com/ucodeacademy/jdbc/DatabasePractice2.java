package com.ucodeacademy.jdbc;

import org.junit.Test;

import java.sql.*;

public class DatabasePractice2 {

    String dbUrl = "jdbc:oracle:thin:@54.208.138.198:1521/xepdb1";
    String username = "hr";
    String password = "hr";
    //String username = ConfigReader.getProperty("dbUsername"); // if you want to get from .properties
    //String password = ConfigReader.getProperty("dbPassword");  // if you want to get from .properties


    @Test
    public void nextPreviousFirstLast() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees order by employee_id");

        resultSet.next(); // next() moves cursor to next row in resultSet
        System.out.println(resultSet.getString("first_name"));

        resultSet.next(); // move cursor to next row in resultSet
        System.out.println(resultSet.getString("first_name"));

        resultSet.next(); // move cursor to next row in resultSet
        resultSet.next(); // move cursor to next row in resultSet
        System.out.println(resultSet.getString("first_name"));

        resultSet.previous(); // moves the cursor to the previous row/one row back/up
        System.out.println(resultSet.getString("first_name"));

        resultSet.first(); // move the cursor to the first row in the resultSet
        System.out.println(resultSet.getString("first_name"));

        resultSet.last(); // move the cursor the last row in the resultSet
        System.out.println(resultSet.getString("first_name"));

        connection.close();
        statement.close();
        resultSet.close();



    }

}
