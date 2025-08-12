package com.example.servingwebcontent.model;

public class KhachHang {
    private String maKh; // Mã khách hàng
    private String ten;  // Tên khách hàng
    private String sdt;  // Số điện thoại

    // Constructor cho các thao tác chỉ cần tên và số điện thoại
    public KhachHang(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

    // Constructor đầy đủ (có mã khách hàng)
    public KhachHang(String maKh, String ten, String sdt) {
        this.maKh = maKh;
        this.ten = ten;
        this.sdt = sdt;
    }

    // Getter và Setter
    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
