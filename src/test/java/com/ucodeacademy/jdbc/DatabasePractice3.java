package com.ucodeacademy.jdbc;

import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.DBUtil;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabasePractice3 {

    String dbUrl = "jdbc:oracle:thin:@54.208.138.198:1521/xepdb1";
    String username = ConfigReader.getProperty("dbUsername"); // getting from .properties
    String password = ConfigReader.getProperty("dbPassword"); // getting from .properties


    @Test
    public void practice1() throws SQLException {
        DBUtil.createConnection(dbUrl, username, password);
        ResultSet resultSet = DBUtil.runQuery("select * from employees");

        resultSet.next();
        System.out.println(resultSet.getString("first_name"));


        ResultSetMetaData metaData = resultSet.getMetaData();

        System.out.println(metaData.getColumnCount());

        System.out.println("=========================");

        // loop through the resultSet and print all records

        int columnCount = metaData.getColumnCount();
        resultSet.first(); // go to first row

        while (resultSet.next()){ // loop through each row

            for(int i=1; i<=columnCount; i++ ){ // loop through each column in the row
                System.out.print(resultSet.getString(i)+" | ");

            }
            System.out.println();
        }

        System.out.println("======================-=============");

        resultSet.first(); // move the cursor the first row
        for(int i=1; i<= columnCount; i++){
            System.out.println(resultSet.getString(i));
        }



        DBUtil.closeAllConnections();

    }
}
