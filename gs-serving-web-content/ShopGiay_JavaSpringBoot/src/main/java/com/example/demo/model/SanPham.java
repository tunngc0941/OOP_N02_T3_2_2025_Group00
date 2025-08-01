package com.example.demo.model;

public class SanPham {
    private String maSP;
    private String tenSP;
    private int size;
    private double giaBan;
    private int soLuong;

    public SanPham() {}

    public SanPham(String maSP, String tenSP, int size, double giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.size = size;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getMaSP() { return maSP; }
    public void setMaSP(String maSP) { this.maSP = maSP; }

    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    public double getGiaBan() { return giaBan; }
    public void setGiaBan(double giaBan) { this.giaBan = giaBan; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
}
