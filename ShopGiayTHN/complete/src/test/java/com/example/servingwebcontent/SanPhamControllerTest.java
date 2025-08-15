package com.example.servingwebcontent;

import com.example.servingwebcontent.database.SanPhamAiven;
import com.example.servingwebcontent.model.SanPham;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SanPhamAivenTest {

    @Mock
    private Connection mockConnection;
    
    @Mock
    private PreparedStatement mockPreparedStatement;
    
    @Mock
    private Statement mockStatement;
    
    @Mock
    private ResultSet mockResultSet;
    
    @InjectMocks
    private SanPhamAiven sanPhamAiven;

    /**
     * @throws SQLException
     */
    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        
        // Mock các kết nối và statement
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        
        // Mock DriverManager để trả về connection mock
        try {
            DriverManager.setLoginTimeout(0);
            when(DriverManager.getConnection(anyString(), anyString(), anyString()))
                .thenReturn(mockConnection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetAllSanPham() throws SQLException {
        // Mock ResultSet
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, false); // 1 row
        when(mockResultSet.getString("MaSp")).thenReturn("SP001");
        when(mockResultSet.getString("Name")).thenReturn("Product 1");
        when(mockResultSet.getDouble("Price")).thenReturn(100.0);
        when(mockResultSet.getInt("Size")).thenReturn(10);
        when(mockResultSet.getString("ImageURL")).thenReturn("image1.jpg");

        // Gọi hàm
        List<SanPham> result = sanPhamAiven.getAllSanPham();

        // Kiểm tra kết quả
        assertEquals(1, result.size());
        assertEquals("SP001", result.get(0).getMaSp());
        verify(mockStatement, times(1)).executeQuery(anyString());
    }

    @Test
    void testGetSanPhamById() throws SQLException {
        // Mock ResultSet
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("MaSp")).thenReturn("SP001");
        when(mockResultSet.getString("Name")).thenReturn("Product 1");
        when(mockResultSet.getDouble("Price")).thenReturn(100.0);
        when(mockResultSet.getInt("Size")).thenReturn(10);
        when(mockResultSet.getString("ImageURL")).thenReturn("image1.jpg");

        // Gọi hàm
        SanPham result = sanPhamAiven.getSanPhamById("SP001");

        // Kiểm tra kết quả
        assertNotNull(result);
        assertEquals("SP001", result.getMaSp());
        verify(mockPreparedStatement, times(1)).setString(1, "SP001");
    }

    @Test
    void testCreateSanPham() throws SQLException {
        // Mock executeUpdate
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Tạo sản phẩm test
        SanPham sp = new SanPham("SP001", "Product 1", 100.0, 10, "image1.jpg");

        // Gọi hàm
        boolean result = sanPhamAiven.createSanPham(sp);

        // Kiểm tra kết quả
        assertTrue(result);
        verify(mockPreparedStatement, times(1)).setString(1, "SP001");
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    void testUpdateSanPham() throws SQLException {
        // Mock executeUpdate
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Tạo sản phẩm test
        SanPham sp = new SanPham("SP001", "Product Updated", 150.0, 12, "image2.jpg");

        // Gọi hàm
        boolean result = sanPhamAiven.updateSanPham("SP001", sp);

        // Kiểm tra kết quả
        assertTrue(result);
        verify(mockPreparedStatement, times(1)).setString(6, "SP001");
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    void testDeleteSanPham() throws SQLException {
        // Mock executeUpdate
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Gọi hàm
        boolean result = sanPhamAiven.deleteSanPham("SP001");

        // Kiểm tra kết quả
        assertTrue(result);
        verify(mockPreparedStatement, times(1)).setString(1, "SP001");
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }
}
