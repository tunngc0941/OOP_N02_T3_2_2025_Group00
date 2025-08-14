package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.GiaoDichAiven;
import com.example.servingwebcontent.model.GiaoDich;
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

@WebMvcTest(GiaoDichController.class)
class GiaoDichControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GiaoDichAiven giaoDichAiven;

    @Test
    void testGetAllGiaoDich() throws Exception {
        List<GiaoDich> list = Arrays.asList(
                new GiaoDich("KH001", "SP001", 2),
                new GiaoDich("KH002", "SP002", 1)
        );
        Mockito.when(giaoDichAiven.getAllGiaoDich()).thenReturn(list);

        mockMvc.perform(get("/api/giaodich"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].maKh").value("KH001"))
                .andExpect(jsonPath("$[1].maSp").value("SP002"));
    }

    @Test
    void testCreateGiaoDichSuccess() throws Exception {
        Mockito.when(giaoDichAiven.createGiaoDich(any(GiaoDich.class))).thenReturn(true);

        String json = "{\"maKh\":\"KH003\",\"maSp\":\"SP003\",\"soLuong\":5}";
        mockMvc.perform(post("/api/giaodich")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Thêm giao dịch thành công"));
    }

    @Test
    void testCreateGiaoDichFail() throws Exception {
        Mockito.when(giaoDichAiven.createGiaoDich(any(GiaoDich.class))).thenReturn(false);

        String json = "{\"maKh\":\"KH004\",\"maSp\":\"SP004\",\"soLuong\":2}";
        mockMvc.perform(post("/api/giaodich")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Không thể thêm giao dịch"));
    }

    @Test
    void testDeleteGiaoDichSuccess() throws Exception {
        Mockito.when(giaoDichAiven.deleteGiaoDich(eq("KH001"), eq("SP001"))).thenReturn(true);

        mockMvc.perform(delete("/api/giaodich/KH001/SP001"))
                .andExpect(status().isOk())
                .andExpect(content().string("Xóa giao dịch thành công"));
    }

    @Test
    void testDeleteGiaoDichNotFound() throws Exception {
        Mockito.when(giaoDichAiven.deleteGiaoDich(eq("KH999"), eq("SP999"))).thenReturn(false);

        mockMvc.perform(delete("/api/giaodich/KH999/SP999"))
                .andExpect(status().isNotFound());
    }
}
