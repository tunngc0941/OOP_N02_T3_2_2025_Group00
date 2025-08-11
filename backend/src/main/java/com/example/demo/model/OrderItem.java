package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long shoeId;
    private int soLuong;
    private double gia;

    public OrderItem() {}

    public OrderItem(Long shoeId, int soLuong, double gia) {
        this.shoeId = shoeId;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getShoeId() { return shoeId; }
    public void setShoeId(Long shoeId) { this.shoeId = shoeId; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public double getGia() { return gia; }
    public void setGia(double gia) { this.gia = gia; }
}
