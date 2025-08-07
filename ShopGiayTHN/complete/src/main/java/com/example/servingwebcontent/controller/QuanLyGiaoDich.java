package com.example.servingwebcontent.controller;


import com.example.servingwebcontent.model.GiaoDich;
import java.util.*;

public class QuanLyGiaoDich {
    private List<GiaoDich> danhSach = new ArrayList<>();

    public void them(GiaoDich gd) {
        danhSach.add(gd);
    }

    public void sua(int index, GiaoDich gd) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.set(index, gd);
        }
    }

    public void xoa(int index) {
        if (index >= 0 && index < danhSach.size()) {
            danhSach.remove(index);
        }
    }

    public List<GiaoDich> getDanhSach() {
        return danhSach;
    }
}