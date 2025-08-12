package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.KhachHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangAiven {

    private final String jdbcUrl = "mysql://avnadmin:AVNS_RvswdzmuaXNGn0bnw24@mysql-33f61df4-st-621c.b.aivencloud.com:26201/defaultdb?ssl-mode=REQUIRED";
    private final String jdbcUsername = "avnadmin";
    private final String jdbcPassword = "AVNS_RvswdzmuaXNGn0bnw24"; 


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    // Lấy tất cả khách hàng
    public List<KhachHang> getAllKhachHang() throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT TenKhachHang, SoDienThoai FROM khachhang";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String ten = rs.getString("TenKhachHang");
                String sdt = rs.getString("SoDienThoai");

                KhachHang kh = new KhachHang(ten, sdt);
                list.add(kh);
            }
        }

        return list;
    }

    // Lấy khách hàng theo số điện thoại
    public KhachHang getKhachHangBySdt(String sdt) throws SQLException {
        String sql = "SELECT TenKhachHang, SoDienThoai FROM khachhang WHERE SoDienThoai = ?";
        KhachHang kh = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sdt);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                kh = new KhachHang(
                        rs.getString("TenKhachHang"),
                        rs.getString("SoDienThoai")
                );
            }

            rs.close();
        }

        return kh;
    }

    // Thêm khách hàng mới
    public boolean createKhachHang(KhachHang kh) throws SQLException {
        String sql = "INSERT INTO khachhang (TenKhachHang, SoDienThoai) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, kh.getTen());
            pstmt.setString(2, kh.getSdt());

            return pstmt.executeUpdate() > 0;
        }
    }

    // Cập nhật thông tin khách hàng
    public boolean updateKhachHang(String sdtCu, KhachHang kh) throws SQLException {
        String sql = "UPDATE khachhang SET TenKhachHang = ?, SoDienThoai = ? WHERE SoDienThoai = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, kh.getTen());
            pstmt.setString(2, kh.getSdt());
            pstmt.setString(3, sdtCu);

            return pstmt.executeUpdate() > 0;
        }
    }

    // Xóa khách hàng theo số điện thoại
    public boolean deleteKhachHang(String sdt) throws SQLException {
        String sql = "DELETE FROM khachhang WHERE SoDienThoai = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sdt);
            return pstmt.executeUpdate() > 0;
        }
    }
}
