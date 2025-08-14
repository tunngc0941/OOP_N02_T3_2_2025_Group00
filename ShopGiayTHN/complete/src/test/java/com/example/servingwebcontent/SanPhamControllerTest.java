package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.SanPhamAiven;
import com.example.servingwebcontent.model.SanPham;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SanPhamController.class)
class SanPhamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SanPhamAiven sanPhamAiven;

    @Test
    void testGetAllSanPham() throws Exception {
        List<SanPham> list = Arrays.asList(
                new SanPham("SP001", "Giày Adidas", 1200000, 10),
                new SanPham("SP002", "Giày Nike", 1500000, 5)
        );
        Mockito.when(sanPhamAiven.getAllSanPham()).thenReturn(list);

        mockMvc.perform(get("/api/sanpham"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].maSp").value("SP001"))
                .andExpect(jsonPath("$[1].tenSp").value("Giày Nike"));
    }

    @Test
    void testGetSanPhamByIdFound() throws Exception {
        SanPham sp = new SanPham("SP003", "Giày Puma", 1000000, 8);
        Mockito.when(sanPhamAiven.getSanPhamById("SP003")).thenReturn(sp);

        mockMvc.perform(get("/api/sanpham/SP003"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tenSp").value("Giày Puma"));
    }

    @Test
    void testGetSanPhamByIdNotFound() throws Exception {
        Mockito.when(sanPhamAiven.getSanPhamById("SP999")).thenReturn(null);

        mockMvc.perform(get("/api/sanpham/SP999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateSanPhamSuccess() throws Exception {
        Mockito.when(sanPhamAiven.createSanPham(any(SanPham.class))).thenReturn(true);

        String json = "{\"maSp\":\"SP004\",\"tenSp\":\"Giày Converse\",\"gia\":800000,\"soLuong\":15}";
        mockMvc.perform(post("/api/sanpham")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Thêm sản phẩm thành công"));
    }

    @Test
    void testCreateSanPhamFail() throws Exception {
        Mockito.when(sanPhamAiven.createSanPham(any(SanPham.class))).thenReturn(false);

        String json = "{\"maSp\":\"SP005\",\"tenSp\":\"Giày Vans\",\"gia\":700000,\"soLuong\":20}";
        mockMvc.perform(post("/api/sanpham")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Không thể thêm sản phẩm"));
    }

    @Test
    void testUpdateSanPhamSuccess() throws Exception {
        Mockito.when(sanPhamAiven.updateSanPham(eq("SP001"), any(SanPham.class))).thenReturn(true);

        String json = "{\"maSp\":\"SP001\",\"tenSp\":\"Giày Adidas Mới\",\"gia\":1300000,\"soLuong\":12}";
        mockMvc.perform(put("/api/sanpham/SP001")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Cập nhật sản phẩm thành công"));
    }

    @Test
    void testUpdateSanPhamNotFound() throws Exception {
        Mockito.when(sanPhamAiven.updateSanPham(eq("SP999"), any(SanPham.class))).thenReturn(false);

        String json = "{\"maSp\":\"SP999\",\"tenSp\":\"Không có\",\"gia\":0,\"soLuong\":0}";
        mockMvc.perform(put("/api/sanpham/SP999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteSanPhamSuccess() throws Exception {
        Mockito.when(sanPhamAiven.deleteSanPham("SP001")).thenReturn(true);

        mockMvc.perform(delete("/api/sanpham/SP001"))
                .andExpect(status().isOk())
                .andExpect(content().string("Xóa sản phẩm thành công"));
    }

    @Test
    void testDeleteSanPhamNotFound() throws Exception {
        Mockito.when(sanPhamAiven.deleteSanPham("SP999")).thenReturn(false);

        mockMvc.perform(delete("/api/sanpham/SP999"))
                .andExpect(status().isNotFound());
    }

    // ====== SQLException tests ======

    @Test
    void testGetAllSanPhamSQLException() throws Exception {
        Mockito.when(sanPhamAiven.getAllSanPham()).thenThrow(new SQLException("DB error"));

        mockMvc.perform(get("/api/sanpham"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void testGetSanPhamByIdSQLException() throws Exception {
        Mockito.when(sanPhamAiven.getSanPhamById("SP001")).thenThrow(new SQLException("DB error"));

        mockMvc.perform(get("/api/sanpham/SP001"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void testCreateSanPhamSQLException() throws Exception {
        Mockito.when(sanPhamAiven.createSanPham(any(SanPham.class))).thenThrow(new SQLException("DB error"));

        String json = "{\"maSp\":\"SP006\",\"tenSp\":\"Giày SQL Error\",\"gia\":900000,\"soLuong\":5}";
        mockMvc.perform(post("/api/sanpham")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Lỗi server"));
    }

    @Test
    void testUpdateSanPhamSQLException() throws Exception {
        Mockito.when(sanPhamAiven.updateSanPham(eq("SP001"), any(SanPham.class))).thenThrow(new SQLException("DB error"));

        String json = "{\"maSp\":\"SP001\",\"tenSp\":\"Giày Error\",\"gia\":1000000,\"soLuong\":3}";
        mockMvc.perform(put("/api/sanpham/SP001")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Lỗi server"));
    }

    @Test
    void testDeleteSanPhamSQLException() throws Exception {
        Mockito.when(sanPhamAiven.deleteSanPham("SP001")).thenThrow(new SQLException("DB error"));

        mockMvc.perform(delete("/api/sanpham/SP001"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Lỗi server"));
    }
}
