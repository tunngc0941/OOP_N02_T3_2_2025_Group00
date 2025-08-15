package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.SanPham;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SanPhamAiven {

    // JDBC URL chuẩn cho MySQL (chú ý: thêm jdbc:mysql:// ở đầu)
    private final String jdbcUrl = "jdbc:mysql://mysql-33f61df4-st-621c.b.aivencloud.com:26201/defaultdb?ssl-mode=REQUIRED";
    private final String jdbcUsername = "avnadmin";
    private final String jdbcPassword = "AVNS_RvswdzmuaXNGn0bnw24";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    // Lấy tất cả sản phẩm
    public List<SanPham> getAllSanPham() throws SQLException {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT MaSp, Name, Price, Size, ImageURL FROM sanpham";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getString("MaSp"),
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

    // Lấy sản phẩm theo mã
    public SanPham getSanPhamById(String maSp) throws SQLException {
        String sql = "SELECT MaSp, Name, Price, Size, ImageURL FROM sanpham WHERE MaSp = ?";
        SanPham sp = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maSp);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                sp = new SanPham(
                        rs.getString("MaSp"),
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getInt("Size"),
                        rs.getString("ImageURL")
                );
            }
        }

        return sp;
    }

    // Thêm sản phẩm mới
    public boolean createSanPham(SanPham sp) throws SQLException {
        String sql = "INSERT INTO sanpham (MaSp, Name, Price, Size, ImageURL) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sp.getMaSp());
            pstmt.setString(2, sp.getName());
            pstmt.setDouble(3, sp.getPrice());
            pstmt.setInt(4, sp.getSize());
            pstmt.setString(5, sp.getImageURL());

            return pstmt.executeUpdate() > 0;
        }
    }

    // Cập nhật sản phẩm theo mã
    public boolean updateSanPham(String maSpOld, SanPham sp) throws SQLException {
        String sql = "UPDATE sanpham SET MaSp = ?, Name = ?, Price = ?, Size = ?, ImageURL = ? WHERE MaSp = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sp.getMaSp());
            pstmt.setString(2, sp.getName());
            pstmt.setDouble(3, sp.getPrice());
            pstmt.setInt(4, sp.getSize());
            pstmt.setString(5, sp.getImageURL());
            pstmt.setString(6, maSpOld);

            return pstmt.executeUpdate() > 0;
        }
    }

    // Xóa sản phẩm theo mã
    public boolean deleteSanPham(String maSp) throws SQLException {
        String sql = "DELETE FROM sanpham WHERE MaSp = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maSp);
            return pstmt.executeUpdate() > 0;
        }
    }
}
