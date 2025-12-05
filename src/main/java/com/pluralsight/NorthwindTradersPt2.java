package com.pluralsight;

import java.sql.*;

public class NorthwindTradersPt2 {
    public static void main(String[] args) {
        String query = "SELECT ProductId, ProductName, UnitPrice, UnitsInStock FROM products";

        try( Connection connection = DriverManager.getConnection("jdbc:mysql: //localhost:3306/northwind", "root", "yearup");
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();

        ) {
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-5s %-35s %-10s %-5s\n", "ID", "Name", "Price", "Stock");
            System.out.println("----------------------------------------------------------");


            while(resultSet.next()) {
                int id = resultSet.getInt("ProductID");
                String name = resultSet.getString("ProductName");
                double price = resultSet.getDouble("UnitPrice");
                int stock = resultSet.getInt("UnitsInStock");

                System.out.printf("%-5d %-35s $%-9.2f %-5d\n", id, name, price, stock);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
