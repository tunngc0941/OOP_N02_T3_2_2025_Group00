package com.example.demo.model;

public class GiaoDich {
    private String tenKH;
    private String maSP;
    private double tongTien;

    public GiaoDich() {}

    public GiaoDich(String tenKH, String maSP, double tongTien) {
        this.tenKH = tenKH;
        this.maSP = maSP;
        this.tongTien = tongTien;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void hienThi() {
        System.out.println("Giao dịch của " + tenKH + " - Mã SP: " + maSP + " - Tổng tiền: " + tongTien);
    }
}
