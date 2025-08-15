package com.example.servingwebcontent;

import com.example.servingwebcontent.controller.GiaoDichController;
import com.example.servingwebcontent.database.GiaoDichAiven;
import com.example.servingwebcontent.model.GiaoDich;
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
class GiaoDichControllerTest {

    @Mock
    private GiaoDichAiven giaoDichAiven;

    @InjectMocks
    private GiaoDichController giaoDichController;

    @SuppressWarnings({ "deprecation", "null" })
    @Test
    void testGetAllGiaoDich() throws SQLException {
        // Chuẩn bị dữ liệu giả
        Mockito.when(giaoDichAiven.getAllGiaoDich())
               .thenReturn(Collections.singletonList(new GiaoDich(null, null, 0)));

        // Gọi hàm
        ResponseEntity<List<GiaoDich>> response = giaoDichController.getAllGiaoDich();

        // Kiểm tra kết quả
        assertEquals(200, response.getStatusCodeValue());
        assertFalse(response.getBody().isEmpty());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testCreateGiaoDich() throws SQLException {
        // Chuẩn bị dữ liệu giả
        Mockito.when(giaoDichAiven.createGiaoDich(Mockito.any()))
               .thenReturn(true);

        // Gọi hàm
        ResponseEntity<String> response = giaoDichController.createGiaoDich(new GiaoDich(null, null, 0));

        // Kiểm tra kết quả
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Thêm giao dịch thành công", response.getBody());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testDeleteGiaoDich() throws SQLException {
        // Chuẩn bị dữ liệu giả
        Mockito.when(giaoDichAiven.deleteGiaoDich("KH1", "SP1"))
               .thenReturn(true);

        // Gọi hàm
        ResponseEntity<String> response = giaoDichController.deleteGiaoDich("KH1", "SP1");

        // Kiểm tra kết quả
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Xóa giao dịch thành công", response.getBody());
    }
}