package com.github.giovane.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryConnection {

    public RepositoryConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://database:3306/unyleya";
        return DriverManager.getConnection(url, "giovane", "giovane");
    }

}
