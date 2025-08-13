package com.example.servingwebcontent.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Class;
import java.sql.Statement;


public class myDBConnection {

    public myDBConnection() {
    };

  
    String myDatabaseURL = "jdbc:mysql://avnadmin:AVNS_RvswdzmuaXNGn0bnw24@mysql-33f61df4-st-621c.b.aivencloud.com:26201/defaultdb?ssl-mode=REQUIRED";

    String myDatabaseDriver = "com.mysql.cj.jdbc.Driver";

    public Connection conn = null;

    public Statement getMyConn() {

        try {

            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL);
            Statement sta = conn.createStatement();
            return sta;

        } catch (Exception e) {
            System.out.println("myDBConnection at 34" + e);
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

        return conn;

    }

     public boolean testConnection() {
        try (Connection connection = getOnlyConn()) {
            return connection != null && !connection.isClosed();
        } catch (Exception e) {
            System.out.println("Test connection failed: " + e);
            return false;
        }
    }
}
