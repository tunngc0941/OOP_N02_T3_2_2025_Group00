package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.SanPham;
import java.util.*;

public class QuanLySanPham {
    private List<SanPham> danhSach = new ArrayList<>();

    public void them(SanPham sp) {
        danhSach.add(sp);
    }

    public void sua(int index, SanPham sp) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.set(index, sp);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.remove(index);
        }
    }

    public List<SanPham> getDanhSach() {
        return danhSach;
    }
}