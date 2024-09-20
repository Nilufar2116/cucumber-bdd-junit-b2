package com.ucodeacademy.jdbc;

import com.ucodeacademy.utility.ConfigReader;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePractice6 {

    String dbUrl = "jdbc:oracle:thin:@54.208.138.198:1521/xepdb1";
    String username = ConfigReader.getProperty("dbUsername"); // getting from .properties
    String password = ConfigReader.getProperty("dbPassword"); // getting from .properties



    @Test
    public void insertNewRecord() throws SQLException{
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = connection.createStatement();

        // Delete an employee
       // System.out.println(statement.executeUpdate("delete from employees where employee_id = 99"));

        // UPDATE employee
        statement.executeUpdate("update employees Set email='dwhite@test.com' where employee_id=15");

        // Insert new employee
        statement.executeUpdate("Insert into employees (employee_id, first_name, last_name)" +
                "values(07, 'James', 'Bond')");

        statement.close();
        connection.close();

    }
}
