package com.example.demo.controller;

import com.example.demo.model.KhachHang;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KhachHangController {
    private final List<KhachHang> khachHangList = new ArrayList<>();


    @GetMapping("/khachhang")
    public String listKhachHang(Model model) {

        KhachHang khachHang1 = new KhachHang("KH001", "Nguyen Van A", "0123456789");
        KhachHang khachHang2 = new KhachHang("KH002", "Tran Thi B", "0987654321");
        khachHangList.add(khachHang1);
        khachHangList.add(khachHang2);


        System.out.println("Danh sách khách hàng: " + khachHangList.get(0).getTenKH());
        model.addAttribute("khachHangList", khachHangList);
        return "test";
    }

    @GetMapping("/khachhang/add")
    public String showAddForm() {
        return "add-khachhang";
    }

    @PostMapping("/khachhang/add")
    public String addKhachHang(@RequestParam String maKH,
                               @RequestParam String tenKH,
                               @RequestParam String soDienThoai) {
        khachHangList.add(new KhachHang(maKH, tenKH, soDienThoai));
        return "redirect:/khachhang";
    }
}