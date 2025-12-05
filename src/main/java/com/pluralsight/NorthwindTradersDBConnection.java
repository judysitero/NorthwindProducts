package com.pluralsight;

import java.sql.*;

public class NorthwindTradersDBConnection {
    public static void main(String[] args) {
        try {

            // Step 1: Open the connection
            Connection connection = DriverManager.getConnection("jdbc:mysql: //localhost:3306/northwind", "root", "yearup");

            // Step 2: Create a statement (query holder)
            Statement statement = connection.createStatement();

            // Step 3a: execute the query
            String query = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(query);

            //Step 3b: process the result
            while(resultSet.next()) {
                System.out.println(resultSet.getString("ProductName"));
            }

            // Step 4: we close the connection
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
