package com.example.servingwebcontent.database;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component
public class myDBConnection {

    public myDBConnection() {}

    // URL JDBC đầy đủ (bao gồm user, password, ssl)
    private final String myDatabaseURL = "mysql://avnadmin:AVNS_RvswdzmuaXNGn0bnw24@mysql-33f61df4-st-621c.b.aivencloud.com:26201/defaultdb?ssl-mode=REQUIRED";
        
    private final String myDatabaseDriver = "com.mysql.cj.jdbc.Driver";
    private Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName(myDatabaseDriver);
            return DriverManager.getConnection(myDatabaseURL);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }

    public Statement getMyConn() {
        try {
            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL);
            return conn.createStatement();
        } catch (Exception e) {
            System.out.println("myDBConnection at getMyConn() error: " + e);
        }
        return null;
    }

    public Connection getOnlyConn() {
        try {
            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL);
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
