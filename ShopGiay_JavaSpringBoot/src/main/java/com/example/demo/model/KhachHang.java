package com.example.demo.model;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String soDienThoai;

    public KhachHang() {}

    public KhachHang(String maKH, String tenKH, String soDienThoai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soDienThoai = soDienThoai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void hienThi() {
        System.out.println("Khách hàng: " + tenKH + " - SĐT: " + soDienThoai);
    }
}
