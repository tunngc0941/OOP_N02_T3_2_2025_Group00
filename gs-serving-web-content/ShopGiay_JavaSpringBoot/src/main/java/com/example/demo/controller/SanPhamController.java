package com.example.demo.controller;

import com.example.demo.model.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SanPhamController {
    private final List<SanPham> sanPhamList = new ArrayList<>();

    @GetMapping("/sanpham")
    public String listSanPham(Model model) {
        model.addAttribute("sanPhamList", sanPhamList);
        return "sanpham";
    }

    @GetMapping("/sanpham/add")
    public String showAddForm() {
        return "add-sanpham";
    }

    @PostMapping("/sanpham/add")
    public String addSanPham(@RequestParam String maSP,
                             @RequestParam String tenSP,
                             @RequestParam int size,
                             @RequestParam double giaBan,
                             @RequestParam int soLuong) {
        sanPhamList.add(new SanPham(maSP, tenSP, size, giaBan, soLuong));
        return "redirect:/sanpham";
    }
}
