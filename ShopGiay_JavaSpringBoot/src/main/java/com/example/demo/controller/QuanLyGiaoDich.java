package com.example.demo.controller;

import com.example.demo.model.GiaoDich;

import java.util.ArrayList;
import java.util.List;

public class QuanLyGiaoDich {
    private final List<GiaoDich> danhSachGiaoDich = new ArrayList<>();

    public void them(GiaoDich gd) {
        danhSachGiaoDich.add(gd);
    }

    public List<GiaoDich> getDanhSach() {
        return danhSachGiaoDich;
    }

    public void sua(int index, GiaoDich gdMoi) {
        if (index >= 0 && index < danhSachGiaoDich.size()) {
            danhSachGiaoDich.set(index, gdMoi);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < danhSachGiaoDich.size()) {
            danhSachGiaoDich.remove(index);
        }
    }

    public void hienThi() {
        for (GiaoDich gd : danhSachGiaoDich) {
            gd.hienThi();
        }
    }

    public double tinhTongTien() {
        double tong = 0;
        for (GiaoDich gd : danhSachGiaoDich) {
            tong += gd.getTongTien();
        }
        return tong;
    }
}
