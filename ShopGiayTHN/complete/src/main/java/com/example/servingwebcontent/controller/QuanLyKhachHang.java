package com.example.servingwebcontent.controller;


import com.example.servingwebcontent.model.KhachHang;
import java.util.*;

public class QuanLyKhachHang {
    private List<KhachHang> danhSach = new ArrayList<>();

    public void them(KhachHang kh) {
        danhSach.add(kh);
    }

    public void sua(int index, KhachHang kh) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.set(index, kh);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.remove(index);
        }
    }

    public List<KhachHang> getDanhSach() {
        return danhSach;
    }
}
