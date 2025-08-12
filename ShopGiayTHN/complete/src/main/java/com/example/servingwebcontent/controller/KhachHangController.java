package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.model.KhachHang;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {

    private final KhachHangAiven khachHangAiven = new KhachHangAiven();

    // Lấy tất cả khách hàng
    @GetMapping
    public ResponseEntity<List<KhachHang>> getAllKhachHang() {
        try {
            List<KhachHang> list = khachHangAiven.getAllKhachHang();
            return ResponseEntity.ok(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // Lấy khách hàng theo số điện thoại
    @GetMapping("/{sdt}")
    public ResponseEntity<KhachHang> getKhachHangBySdt(@PathVariable String sdt) {
        try {
            KhachHang kh = khachHangAiven.getKhachHangBySdt(sdt);
            if (kh != null) {
                return ResponseEntity.ok(kh);
            }
            return ResponseEntity.notFound().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // Thêm khách hàng mới
    @PostMapping
    public ResponseEntity<String> createKhachHang(@RequestBody KhachHang kh) {
        try {
            boolean success = khachHangAiven.createKhachHang(kh);
            if (success) {
                return ResponseEntity.ok("Thêm khách hàng thành công");
            }
            return ResponseEntity.badRequest().body("Không thể thêm khách hàng");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    // Cập nhật khách hàng
    @PutMapping("/{sdtCu}")
    public ResponseEntity<String> updateKhachHang(@PathVariable String sdtCu, @RequestBody KhachHang kh) {
        try {
            boolean success = khachHangAiven.updateKhachHang(sdtCu, kh);
            if (success) {
                return ResponseEntity.ok("Cập nhật thành công");
            }
            return ResponseEntity.notFound().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    // Xóa khách hàng
    @DeleteMapping("/{sdt}")
    public ResponseEntity<String> deleteKhachHang(@PathVariable String sdt) {
        try {
            boolean success = khachHangAiven.deleteKhachHang(sdt);
            if (success) {
                return ResponseEntity.ok("Xóa thành công");
            }
            return ResponseEntity.notFound().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }
}
