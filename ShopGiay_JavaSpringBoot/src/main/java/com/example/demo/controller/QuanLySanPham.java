package com.example.demo.controller;

import com.example.demo.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class QuanLySanPham {
    private final List<SanPham> danhSachSanPham = new ArrayList<>();

    public void them(SanPham sp) {
        danhSachSanPham.add(sp);
    }

    public List<SanPham> getDanhSach() {
        return danhSachSanPham;
    }

    public void sua(int index, SanPham spMoi) {
        if (index >= 0 && index < danhSachSanPham.size()) {
            danhSachSanPham.set(index, spMoi);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < danhSachSanPham.size()) {
            danhSachSanPham.remove(index);
        }
    }

    public void hienThi() {
        for (SanPham sp : danhSachSanPham) {
            sp.hienThi();
        }
    }
}
