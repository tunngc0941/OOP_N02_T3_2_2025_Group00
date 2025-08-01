package com.example.demo.model;

import java.util.List;

public class GiaoDich {
    private KhachHang khachHang;
    private List<SanPham> sanPhamList;
    private double tongTien;

    public GiaoDich() {}

    public GiaoDich(KhachHang khachHang, List<SanPham> sanPhamList, double tongTien) {
        this.khachHang = khachHang;
        this.sanPhamList = sanPhamList;
        this.tongTien = tongTien;
    }

    public KhachHang getKhachHang() { return khachHang; }
    public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; }

    public List<SanPham> getSanPhamList() { return sanPhamList; }
    public void setSanPhamList(List<SanPham> sanPhamList) { this.sanPhamList = sanPhamList; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
}
