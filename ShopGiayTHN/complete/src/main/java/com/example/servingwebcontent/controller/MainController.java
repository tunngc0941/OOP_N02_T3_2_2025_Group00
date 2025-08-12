package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // Trang chủ
    @GetMapping({"/", "/main"})
    public String mainPage() {
        return "main"; // main.html
    }

    // Trang quản lý sản phẩm
    @GetMapping("/sanpham")
    public String sanPhamPage() {
        return "sanpham"; // sanpham.html
    }

    // Trang quản lý khách hàng
    @GetMapping("/khachhang")
    public String khachHangPage() {
        return "khachhang"; // khachhang.html
    }

    // Trang quản lý giao dịch
    @GetMapping("/giaodich")
    public String giaoDichPage() {
        return "giaodich"; // giaodich.html
    }
}
