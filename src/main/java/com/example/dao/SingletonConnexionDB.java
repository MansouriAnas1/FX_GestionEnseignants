package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonConnexionDB {
    private static Connection connection;

    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost/db_enseignant?"
                    + "user=root&password=");
            Statement statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() { return connection;}
}
