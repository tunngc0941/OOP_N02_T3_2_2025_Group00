package com.example.demo.model;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String soDienThoai;

    public KhachHang(String maKH, String tenKH, String soDienThoai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soDienThoai = soDienThoai;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void hienThiThongTin() {
        System.out.println("Mã KH: " + maKH);
        System.out.println("Tên KH: " + tenKH);
        System.out.println("Số điện thoại: " + soDienThoai);
    }
}
