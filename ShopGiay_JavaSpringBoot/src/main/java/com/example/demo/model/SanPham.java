package com.example.demo.model;

public class SanPham {
    private String maSP;
    private String tenSP;
    private String size;
    private double giaBan;
    private int soLuong;

    public SanPham() {}

    public SanPham(String maSP, String tenSP, String size, double giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.size = size;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void hienThi() {
        System.out.println("Sản phẩm: " + tenSP + " - Giá: " + giaBan + " - SL: " + soLuong);
    }
}
