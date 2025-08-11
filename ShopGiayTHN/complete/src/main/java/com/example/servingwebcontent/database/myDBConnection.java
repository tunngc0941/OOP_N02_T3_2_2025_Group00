package com.example.servingwebcontent.Database;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component
public class myDBConnection {

    private final String myDatabaseURL = "mysql://avnadmin:AVNS_RvswdzmuaXNGn0bnw24@mysql-33f61df4-st-621c.b.aivencloud.com:26201/defaultdb?ssl-mode=REQUIRED";
    private final String username = "avnadmin";  
    private final String password = "AVNS_RvswdzmuaXNGn0bnw24"; 
    private final String myDatabaseDriver = "com.mysql.cj.jdbc.Driver";

    private Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName(myDatabaseDriver);
            return DriverManager.getConnection(myDatabaseURL, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }

    public Statement getMyConn() {
        try {
            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL, username, password);
            return conn.createStatement();
        } catch (Exception e) {
            System.out.println("myDBConnection at getMyConn() error: " + e);
        }
        return null;
    }

    public Connection getOnlyConn() {
        try {
            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL, username, password);
            return conn;
        } catch (Exception e) {
            System.out.println("Database connection error: " + e);
        }
        return null;
    }

    public boolean testConnection() {
        try (Connection conn = getOnlyConn()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Database connection test successful");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Database connection test failed: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
