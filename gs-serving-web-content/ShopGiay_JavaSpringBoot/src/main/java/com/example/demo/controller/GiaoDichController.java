package com.example.demo.controller;

import com.example.demo.model.GiaoDich;
import com.example.demo.model.KhachHang;
import com.example.demo.model.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GiaoDichController {
    private final List<GiaoDich> giaoDichList = new ArrayList<>();
    private final List<KhachHang> khachHangList = new ArrayList<>();
    private final List<SanPham> sanPhamList = new ArrayList<>();

    @GetMapping("/giaodich")
    public String listGiaoDich(Model model) {
        model.addAttribute("giaoDichList", giaoDichList);
        return "giaodich";
    }

    @GetMapping("/giaodich/add")
    public String showAddForm(Model model) {
        model.addAttribute("khachHangList", khachHangList);
        model.addAttribute("sanPhamList", sanPhamList);
        return "add-giaodich";
    }

    @PostMapping("/giaodich/add")
    public String addGiaoDich(@RequestParam String maKH,
                              @RequestParam List<String> maSPs,
                              @RequestParam double tongTien) {
        KhachHang kh = khachHangList.stream().filter(k -> k.getMaKH().equals(maKH)).findFirst().orElse(null);
        List<SanPham> sps = new ArrayList<>();
        for (String maSP : maSPs) {
            sanPhamList.stream().filter(sp -> sp.getMaSP().equals(maSP)).findFirst().ifPresent(sps::add);
        }
        giaoDichList.add(new GiaoDich(kh, sps, tongTien));
        return "redirect:/giaodich";
    }
}
