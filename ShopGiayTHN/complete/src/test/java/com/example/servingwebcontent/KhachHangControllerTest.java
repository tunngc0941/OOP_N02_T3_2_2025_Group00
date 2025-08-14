package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.KhachHangAiven;
import com.example.servingwebcontent.model.KhachHang;
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

@WebMvcTest(KhachHangController.class)
class KhachHangControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KhachHangAiven khachHangAiven;

    @Test
    void testGetAllKhachHang() throws Exception {
        List<KhachHang> list = Arrays.asList(
                new KhachHang("KH001", "Nguyen Van A", "0123456789"),
                new KhachHang("KH002", "Tran Thi B", "0987654321")
        );
        Mockito.when(khachHangAiven.getAllKhachHang()).thenReturn(list);

        mockMvc.perform(get("/api/khachhang"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].maKh").value("KH001"))
                .andExpect(jsonPath("$[1].sdt").value("0987654321"));
    }

    @Test
    void testGetKhachHangBySdtFound() throws Exception {
        KhachHang kh = new KhachHang("KH003", "Le Van C", "0111222333");
        Mockito.when(khachHangAiven.getKhachHangBySdt("0111222333")).thenReturn(kh);

        mockMvc.perform(get("/api/khachhang/0111222333"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tenKh").value("Le Van C"));
    }

    @Test
    void testGetKhachHangBySdtNotFound() throws Exception {
        Mockito.when(khachHangAiven.getKhachHangBySdt("000")).thenReturn(null);

        mockMvc.perform(get("/api/khachhang/000"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateKhachHangSuccess() throws Exception {
        Mockito.when(khachHangAiven.createKhachHang(any(KhachHang.class))).thenReturn(true);

        String json = "{\"maKh\":\"KH004\",\"tenKh\":\"Pham Van D\",\"sdt\":\"0999888777\"}";
        mockMvc.perform(post("/api/khachhang")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Thêm khách hàng thành công"));
    }

    @Test
    void testCreateKhachHangFail() throws Exception {
        Mockito.when(khachHangAiven.createKhachHang(any(KhachHang.class))).thenReturn(false);

        String json = "{\"maKh\":\"KH005\",\"tenKh\":\"Pham Van E\",\"sdt\":\"0999000000\"}";
        mockMvc.perform(post("/api/khachhang")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Không thể thêm khách hàng"));
    }

    @Test
    void testUpdateKhachHangSuccess() throws Exception {
        Mockito.when(khachHangAiven.updateKhachHang(eq("0123456789"), any(KhachHang.class))).thenReturn(true);

        String json = "{\"maKh\":\"KH001\",\"tenKh\":\"Nguyen Van Updated\",\"sdt\":\"0123456789\"}";
        mockMvc.perform(put("/api/khachhang/0123456789")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Cập nhật thành công"));
    }

    @Test
    void testUpdateKhachHangNotFound() throws Exception {
        Mockito.when(khachHangAiven.updateKhachHang(eq("000"), any(KhachHang.class))).thenReturn(false);

        String json = "{\"maKh\":\"KH999\",\"tenKh\":\"No Name\",\"sdt\":\"000\"}";
        mockMvc.perform(put("/api/khachhang/000")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteKhachHangSuccess() throws Exception {
        Mockito.when(khachHangAiven.deleteKhachHang("0123456789")).thenReturn(true);

        mockMvc.perform(delete("/api/khachhang/0123456789"))
                .andExpect(status().isOk())
                .andExpect(content().string("Xóa thành công"));
    }

    @Test
    void testDeleteKhachHangNotFound() throws Exception {
        Mockito.when(khachHangAiven.deleteKhachHang("000")).thenReturn(false);

        mockMvc.perform(delete("/api/khachhang/000"))
                .andExpect(status().isNotFound());
    }

    // ====== SQLException tests ======

    @Test
    void testGetAllKhachHangSQLException() throws Exception {
        Mockito.when(khachHangAiven.getAllKhachHang()).thenThrow(new SQLException("DB error"));

        mockMvc.perform(get("/api/khachhang"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void testGetKhachHangBySdtSQLException() throws Exception {
        Mockito.when(khachHangAiven.getKhachHangBySdt("011")).thenThrow(new SQLException("DB error"));

        mockMvc.perform(get("/api/khachhang/011"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void testCreateKhachHangSQLException() throws Exception {
        Mockito.when(khachHangAiven.createKhachHang(any(KhachHang.class))).thenThrow(new SQLException("DB error"));

        String json = "{\"maKh\":\"KH006\",\"tenKh\":\"SQL Error\",\"sdt\":\"066\"}";
        mockMvc.perform(post("/api/khachhang")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Lỗi server"));
    }

    @Test
    void testUpdateKhachHangSQLException() throws Exception {
        Mockito.when(khachHangAiven.updateKhachHang(eq("066"), any(KhachHang.class))).thenThrow(new SQLException("DB error"));

        String json = "{\"maKh\":\"KH007\",\"tenKh\":\"SQL Error\",\"sdt\":\"066\"}";
        mockMvc.perform(put("/api/khachhang/066")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Lỗi server"));
    }

    @Test
    void testDeleteKhachHangSQLException() throws Exception {
        Mockito.when(khachHangAiven.deleteKhachHang("066")).thenThrow(new SQLException("DB error"));

        mockMvc.perform(delete("/api/khachhang/066"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Lỗi server"));
    }
}
