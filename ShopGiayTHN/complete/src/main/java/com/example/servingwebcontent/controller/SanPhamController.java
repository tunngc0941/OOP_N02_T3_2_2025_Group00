package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.SanPhamTHNDAO;
import com.example.servingwebcontent.model.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {

    private final SanPhamAiven sanPhamAiven = new SanPhamAiven();

    // 1. Hiển thị danh sách sản phẩm
    @GetMapping
    public String listSanPham(Model model) throws SQLException {
        List<SanPham> sanPhams = sanPhamAiven.getAllSanPham();
        model.addAttribute("listSanPham", sanPhams);
        return "sanpham/list"; // View: sanpham/list.html
    }

    // 2. Hiển thị form thêm sản phẩm
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sanpham", new SanPham("", 0, 0, ""));
        return "sanpham/add"; // View: sanpham/add.html
    }

    // 3. Xử lý thêm sản phẩm
    @PostMapping("/add")
    public String addSanPham(@ModelAttribute SanPham sanpham) throws SQLException {
        sanPhamAiven.createSanPham(sanpham);
        return "redirect:/sanpham";
    }

    // 4. Hiển thị form sửa sản phẩm
    @GetMapping("/edit/{name}")
    public String showEditForm(@PathVariable("name") String name, Model model) throws SQLException {
        SanPham sp = sanPhamAiven.getSanPhamByName(name);
        model.addAttribute("sanpham", sp);
        model.addAttribute("oldName", name);
        return "sanpham/edit"; // View: sanpham/edit.html
    }

    // 5. Xử lý cập nhật sản phẩm
    @PostMapping("/edit")
    public String editSanPham(@RequestParam("oldName") String oldName,
                               @ModelAttribute SanPham sanpham) throws SQLException {
        sanPhamAiven.updateSanPham(oldName, sanpham);
        return "redirect:/sanpham";
    }

    // 6. Xóa sản phẩm
    @GetMapping("/delete/{name}")
    public String deleteSanPham(@PathVariable("name") String name) throws SQLException {
        sanPhamAiven.deleteSanPham(name);
        return "redirect:/sanpham";
    }
}
