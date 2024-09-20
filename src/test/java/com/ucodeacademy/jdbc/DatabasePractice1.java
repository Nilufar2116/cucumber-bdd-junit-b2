package com.ucodeacademy.jdbc;

import org.junit.Test;

import java.sql.*;

public class DatabasePractice1 {

    String dbUrl = "jdbc:oracle:thin:@54.208.138.198:1521/xepdb1";
    String username = "hr";
    String password = "hr";
    //String username = ConfigReader.getProperty("dbUsername"); // if you want to get from .properties
    //String password = ConfigReader.getProperty("dbPassword");  // if you want to get from .properties

    @Test
    public void resultSetMethodsPractice() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl,username,password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees");

        resultSet.next(); // -> moving the cursor to first row in resulSet

        // getString("columnNam") -> returns the value of specified column as String
        System.out.println(resultSet.getString("last_name"));

        System.out.println(resultSet.getString("job_id"));
        System.out.println(resultSet.getString("email"));

        // getString(index)
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(4));

        // getInt()
        System.out.println(resultSet.getInt("employee_id"));
        System.out.println(resultSet.getInt("department_id"));

        // getDouble()
        System.out.println(resultSet.getDouble("salary"));
        System.out.println(resultSet.getDouble("employee_id"));

        // getDate()
        System.out.println(resultSet.getDate("hire_date"));

        // we can use getString() got get date as String
        System.out.println(resultSet.getString("hire_date"));

    }
}
