package com.example.demo.controller;

import com.example.demo.model.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class QuanLyKhachHang {
    private final List<KhachHang> danhSachKhachHang = new ArrayList<>();

    public void them(KhachHang kh) {
        danhSachKhachHang.add(kh);
    }

    public List<KhachHang> getDanhSach() {
        return danhSachKhachHang;
    }

    public void sua(int index, KhachHang khMoi) {
        if (index >= 0 && index < danhSachKhachHang.size()) {
            danhSachKhachHang.set(index, khMoi);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < danhSachKhachHang.size()) {
            danhSachKhachHang.remove(index);
        }
    }

    public void hienThi() {
        for (KhachHang kh : danhSachKhachHang) {
            kh.hienThi();
        }
    }
}
