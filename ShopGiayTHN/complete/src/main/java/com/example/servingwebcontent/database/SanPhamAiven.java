package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamTHNDAO {

    private final String jdbcUrl = "mysql://avnadmin:AVNS_RvswdzmuaXNGn0bnw24@mysql-33f61df4-st-621c.b.aivencloud.com:26201/defaultdb?ssl-mode=REQUIRED";
    private final String jdbcUsername = "avnadmin";
    private final String jdbcPassword = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    // Lấy tất cả sản phẩm
    public List<SanPham> getAllSanPham() throws SQLException {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT Name, Price, Size, ImageURL FROM sanpham";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getInt("Size"),
                        rs.getString("ImageURL")
                );
                list.add(sp);
            }
        }

        return list;
    }

    // Lấy sản phẩm theo tên
    public SanPham getSanPhamByName(String name) throws SQLException {
        String sql = "SELECT Name, Price, Size, ImageURL FROM sanpham WHERE Name = ?";
        SanPham sp = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                sp = new SanPham(
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getInt("Size"),
                        rs.getString("ImageURL")
                );
            }

            rs.close();
        }

        return sp;
    }

    // Thêm sản phẩm mới
    public boolean createSanPham(SanPham sp) throws SQLException {
        String sql = "INSERT INTO sanpham (Name, Price, Size, ImageURL) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sp.getName());
            pstmt.setDouble(2, sp.getPrice());
            pstmt.setInt(3, sp.getSize());
            pstmt.setString(4, sp.getImageURL());

            return pstmt.executeUpdate() > 0;
        }
    }

    // Cập nhật sản phẩm
    public boolean updateSanPham(String nameOld, SanPham sp) throws SQLException {
        String sql = "UPDATE sanpham SET Name = ?, Price = ?, Size = ?, ImageURL = ? WHERE Name = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sp.getName());
            pstmt.setDouble(2, sp.getPrice());
            pstmt.setInt(3, sp.getSize());
            pstmt.setString(4, sp.getImageURL());
            pstmt.setString(5, nameOld);

            return pstmt.executeUpdate() > 0;
        }
    }

    // Xóa sản phẩm
    public boolean deleteSanPham(String name) throws SQLException {
        String sql = "DELETE FROM sanpham WHERE Name = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            return pstmt.executeUpdate() > 0;
        }
    }
}
