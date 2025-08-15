package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.KhachHangController;
import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.model.KhachHang;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KhachHangControllerTest {

    @Mock
    private KhachHangAiven khachHangAiven;

    @InjectMocks
    private KhachHangController khachHangController;

    @SuppressWarnings({ "deprecation", "null" })
    @Test
    void testGetAllKhachHang() throws SQLException {
        // Chuẩn bị dữ liệu giả
        Mockito.when(khachHangAiven.getAllKhachHang())
               .thenReturn(Collections.singletonList(new KhachHang(null, null, null)));

        // Gọi hàm
        ResponseEntity<List<KhachHang>> response = khachHangController.getAllKhachHang();

        // Kiểm tra kết quả
        assertEquals(200, response.getStatusCodeValue());
        assertFalse(response.getBody().isEmpty());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testGetKhachHangBySdt() throws SQLException {
        // Chuẩn bị dữ liệu giả
        KhachHang khachHang = new KhachHang(null, null, null);
        khachHang.setSdt("0987654321");
        
        Mockito.when(khachHangAiven.getKhachHangBySdt("0987654321"))
               .thenReturn(khachHang);

        // Gọi hàm
        ResponseEntity<KhachHang> response = khachHangController.getKhachHangBySdt("0987654321");

        // Kiểm tra kết quả
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testCreateKhachHang() throws SQLException {
        // Chuẩn bị dữ liệu giả
        KhachHang khachHang = new KhachHang(null, null, null);
        khachHang.setSdt("0987654321");
        
        Mockito.when(khachHangAiven.createKhachHang(khachHang))
               .thenReturn(true);

        // Gọi hàm
        ResponseEntity<String> response = khachHangController.createKhachHang(khachHang);

        // Kiểm tra kết quả
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Thêm khách hàng thành công", response.getBody());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testUpdateKhachHang() throws SQLException {
        // Chuẩn bị dữ liệu giả
        KhachHang khachHang = new KhachHang(null, null, null);
        khachHang.setSdt("0987654321");
        
        Mockito.when(khachHangAiven.updateKhachHang("0123456789", khachHang))
               .thenReturn(true);

        // Gọi hàm
        ResponseEntity<String> response = khachHangController.updateKhachHang("0123456789", khachHang);

        // Kiểm tra kết quả
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Cập nhật thành công", response.getBody());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testDeleteKhachHang() throws SQLException {
        // Chuẩn bị dữ liệu giả
        Mockito.when(khachHangAiven.deleteKhachHang("0987654321"))
               .thenReturn(true);

        // Gọi hàm
        ResponseEntity<String> response = khachHangController.deleteKhachHang("0987654321");

        // Kiểm tra kết quả
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Xóa thành công", response.getBody());
    }
}
