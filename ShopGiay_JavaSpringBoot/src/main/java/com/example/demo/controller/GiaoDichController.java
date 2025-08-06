package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GiaoDichController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("giaodichForm", new GiaoDichForm());
        return "form";  // trỏ tới form.html
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute GiaoDichForm form, Model model) {
        // Kiểm tra dữ liệu đầu vào
        if (form.getTenKH() == null || form.getTenKH().isEmpty() ||
            form.getTenSP() == null || form.getTenSP().isEmpty() ||
            form.getSoLuong() <= 0) {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin và số lượng hợp lệ.");
            return "form";
        }

        KhachHang kh = new KhachHang(form.getTenKH(), form.getDiaChi(), form.getSoDT());
        SanPham sp = new SanPham(form.getTenSP(), form.getTenSP(), form.getGiaBan(), form.getSize());
        GiaoDich gd = new GiaoDich(kh, sp, form.getSoLuong());

        model.addAttribute("giaodich", gd);
        return "hoadon"; // trỏ tới hoadon.html
    }
}
