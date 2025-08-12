package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class aivenConnection {

    public void connectAndDisplayProducts() {
        Connection conn = null;
        try {
            // Kết nối database qua class myDBConnection
            myDBConnection mydb = new myDBConnection();
            conn = mydb.getOnlyConn();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Name, Price, Size, ImageURL FROM sanpham");

            System.out.println("Danh sách sản phẩm trong shop giày THN:");
            while (rs.next()) {
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                int size = rs.getInt("Size");
                String imageURL = rs.getString("ImageURL");

                System.out.println("Tên: " + name + " | Giá: " + price + " | Size: " + size + " | Ảnh: " + imageURL);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Lỗi khi kết nối database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
