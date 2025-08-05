package com.example.demo.model;

public class SanPham {
    private String ID;
    private String tenSp;
    private double giaBan;
    private int size;

    public SanPham(String ID, String tenSp, double giaBan, int size) {
        this.ID = ID;
        this.tenSp = tenSp;
        this.giaBan = giaBan;
        this.size = size;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getID() {
        return ID;
    }

    public String getTenSp() {
        return tenSp;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public int getSize() {
        return size;
    }

    public void hienThiThongTin() {
        System.out.println("Thông tin sản phẩm:");
        System.out.println("Mã sản phẩm: " + ID);
        System.out.println("Tên sản phẩm: " + tenSp);
        System.out.println("Giá bán: " + giaBan);
        System.out.println("Size: " + size);
    }
}
