package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.GiaoDichAiven;
import com.example.servingwebcontent.model.GiaoDich;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/giaodich")
public class GiaoDichController {

    private final GiaoDichAiven giaoDichAiven;

    public GiaoDichController(GiaoDichAiven giaoDichAiven) {
        this.giaoDichAiven = giaoDichAiven;
    }

    // Lấy tất cả giao dịch
    @GetMapping
    public ResponseEntity<List<GiaoDich>> getAllGiaoDich() {
        try {
            List<GiaoDich> list = giaoDichAiven.getAllGiaoDich();
            return ResponseEntity.ok(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    // Thêm giao dịch mới
    @PostMapping
    public ResponseEntity<String> createGiaoDich(@RequestBody GiaoDich gd) {
        try {
            boolean success = giaoDichAiven.createGiaoDich(gd);
            if (success) {
                return ResponseEntity.ok("Thêm giao dịch thành công");
            }
            return ResponseEntity.badRequest().body("Không thể thêm giao dịch");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    // Xóa giao dịch
    @DeleteMapping("/{maKh}/{maSp}")
    public ResponseEntity<String> deleteGiaoDich(@PathVariable String maKh, @PathVariable String maSp) {
        try {
            boolean success = giaoDichAiven.deleteGiaoDich(maKh, maSp);
            if (success) {
                return ResponseEntity.ok("Xóa giao dịch thành công");
            }
            return ResponseEntity.notFound().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }
}
