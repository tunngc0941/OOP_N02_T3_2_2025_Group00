package com.example.servingwebcontent.model;

import java.time.LocalDateTime;

public class GiaoDich {
    private KhachHang khachHang;
    private SanPham sanPham;
    private LocalDateTime thoiGian;

    public GiaoDich(KhachHang khachHang, SanPham sanPham, LocalDateTime thoiGian) {
        this.khachHang = khachHang;
        this.sanPham = sanPham;
        this.thoiGian = thoiGian;
    }

    public GiaoDich(KhachHang khachHang2, SanPham sanPham2, int i) {
        //TODO Auto-generated constructor stub
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }
}
