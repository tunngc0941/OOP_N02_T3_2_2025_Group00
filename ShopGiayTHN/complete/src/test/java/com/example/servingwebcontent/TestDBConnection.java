package com.example.servingwebcontent;

import com.example.servingwebcontent.database.myDBConnection;

public class TestDBConnection {
    public static void main(String[] args) {
        myDBConnection db = new myDBConnection();

        System.out.println("=== Bắt đầu test kết nối database ===");

        if (db.testConnection()) {
            System.out.println("✅ Kết nối thành công!");
        } else {
            System.out.println("❌ Kết nối thất bại!");
        }
    }
}
