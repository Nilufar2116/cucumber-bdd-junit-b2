package com.ucodeacademy.jdbc;

import com.ucodeacademy.utility.ConfigReader;
import org.junit.Test;

import java.sql.*;

public class DatabasePractice4 {

    String dbUrl = "jdbc:oracle:thin:@54.208.138.198:1521/xepdb1";
    String username = ConfigReader.getProperty("dbUsername"); // getting from .properties
    String password = ConfigReader.getProperty("dbPassword"); // getting from .properties

    // count how manu NULL values are there in Employees table
    @Test
    public void countNullValues() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees");

//        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//        int columnCount = resultSetMetaData.getColumnCount();

        int columnCount = resultSet.getMetaData().getColumnCount(); // shorter way
        int countNulls = 0;
        System.out.println(columnCount);


        while (resultSet.next()){
            for (int i=1; i<= columnCount; i++){

                if(resultSet.getString(i) == null){
                    countNulls ++;
                }
            }
        }

        System.out.println("Number of NULL values: "+ countNulls);

        connection.close();
        statement.close();
        resultSet.close();

    }

}
