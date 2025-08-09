package com.example.servingwebcontent.controller;


import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.GiaoDich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CuaHangGiayController {

    private static final QuanLySanPham quanLySanPham = new QuanLySanPham();
    private static final QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
    private static final QuanLyGiaoDich quanLyGiaoDich = new QuanLyGiaoDich();

    static {
        quanLySanPham.them(new SanPham("Giày Adidas", 1500000));
        quanLySanPham.them(new SanPham("Giày Nike", 2000000));
        quanLyKhachHang.them(new KhachHang( "Nguyễn Văn A", "0909123456"));
        quanLyGiaoDich.them(new GiaoDich(
             quanLyKhachHang.getDanhSach().get(0),
            quanLySanPham.getDanhSach().get(0),
            2
        ));
    }

    @GetMapping("/")
    public String giay(Model model) {
        model.addAttribute("products", quanLySanPham.getDanhSach());
        model.addAttribute("customers", quanLyKhachHang.getDanhSach());
        model.addAttribute("transactions", quanLyGiaoDich.getDanhSach());
        return "giay";
    }
}