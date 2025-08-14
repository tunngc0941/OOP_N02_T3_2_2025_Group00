package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.SanPhamAiven;
import com.example.servingwebcontent.model.SanPham;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/sanpham")
public class SanPhamController {

    private final SanPhamAiven sanPhamAiven;

    public SanPhamController(SanPhamAiven sanPhamAiven) {
        this.sanPhamAiven = sanPhamAiven;
    }

    // Lấy tất cả sản phẩm
    @GetMapping
    public ResponseEntity<List<SanPham>> getAllSanPham() {
        try {
            List<SanPham> list = sanPhamAiven.getAllSanPham();
            return ResponseEntity.ok(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // Lấy sản phẩm theo mã
    @GetMapping("/{maSp}")
    public ResponseEntity<SanPham> getSanPhamById(@PathVariable("maSp") String maSp) {
        try {
            SanPham sp = sanPhamAiven.getSanPhamById(maSp);
            if (sp != null) {
                return ResponseEntity.ok(sp);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // Thêm sản phẩm
    @PostMapping
    public ResponseEntity<String> createSanPham(@RequestBody SanPham sp) {
        try {
            boolean success = sanPhamAiven.createSanPham(sp);
            if (success) {
                return ResponseEntity.ok("Thêm sản phẩm thành công");
            } else {
                return ResponseEntity.badRequest().body("Không thể thêm sản phẩm");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    // Cập nhật sản phẩm
    @PutMapping("/{maSpCu}")
    public ResponseEntity<String> updateSanPham(@PathVariable("maSpCu") String maSpCu,
                                                 @RequestBody SanPham sp) {
        try {
            boolean success = sanPhamAiven.updateSanPham(maSpCu, sp);
            if (success) {
                return ResponseEntity.ok("Cập nhật sản phẩm thành công");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    // Xóa sản phẩm
    @DeleteMapping("/{maSp}")
    public ResponseEntity<String> deleteSanPham(@PathVariable("maSp") String maSp) {
        try {
            boolean success = sanPhamAiven.deleteSanPham(maSp);
            if (success) {
                return ResponseEntity.ok("Xóa sản phẩm thành công");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }
}
