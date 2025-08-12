package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class GiaoDichAiven {

    private final String jdbcUrl = "mysql://avnadmin:AVNS_RvswdzmuaXNGn0bnw24@mysql-33f61df4-st-621c.b.aivencloud.com:26201/defaultdb?ssl-mode=REQUIRED";
    private final String jdbcUsername = "avnadmin";
    // private final String jdbcPassword = "AVNS_RvswdzmuaXNGn0bnw24";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    // Lấy tất cả giao dịch
    public List<GiaoDich> getAllGiaoDich() throws SQLException {
        List<GiaoDich> list = new ArrayList<>();
        String sql = "SELECT gd.*, kh.*, sp.* " +
                     "FROM giaodich gd " +
                     "JOIN khachhang kh ON gd.MaKh = kh.MaKh " +
                     "JOIN sanpham sp ON gd.MaSp = sp.MaSp";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Tạo đối tượng KhachHang
                KhachHang kh = new KhachHang(
                        rs.getString("MaKh"),
                        rs.getString("TenKh"),
                        rs.getString("SoDienThoai")
                );

                // Tạo đối tượng SanPham
                SanPham sp = new SanPham(
                        rs.getString("MaSp"),
                        rs.getString("TenSp"),
                        rs.getDouble("Gia")
                );

                // Chuyển Timestamp sang LocalDateTime
                LocalDateTime thoiGian = rs.getTimestamp("ThoiGianGd")
                                           .toInstant()
                                           .atZone(ZoneId.systemDefault())
                                           .toLocalDateTime();

                // Tạo đối tượng GiaoDich
                GiaoDich gd = new GiaoDich(khachHang = kh, sanPham = sp, thoiGian = thoiGian);
                list.add(gd);
            }
        }

        return list;
    }

    // Thêm giao dịch mới
    public boolean createGiaoDich(GiaoDich gd) throws SQLException {
        String sql = "INSERT INTO giaodich (MaKh, MaSp, ThoiGianGd) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, gd.getKhachHang().getMaKh());
            pstmt.setString(2, gd.getSanPham().getMaSp());
            pstmt.setTimestamp(3, Timestamp.valueOf(gd.getThoiGian()));

            return pstmt.executeUpdate() > 0;
        }
    }

    // Xóa giao dịch theo khách và sản phẩm
    public boolean deleteGiaoDich(String maKh, String maSp) throws SQLException {
        String sql = "DELETE FROM giaodich WHERE MaKh = ? AND MaSp = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maKh);
            pstmt.setString(2, maSp);

            return pstmt.executeUpdate() > 0;
        }
    }
}
