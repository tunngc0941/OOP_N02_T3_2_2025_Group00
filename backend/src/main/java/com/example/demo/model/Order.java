package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    private double total;

    public Order() {}
    public Order(Long id, List<OrderItem> items, double total) {
        this.id = id; this.items = items; this.total = total;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public static class OrderItem {
        private Long shoeId;
        private int soLuong;
        private double gia;

        public OrderItem() {}
        public OrderItem(Long shoeId, int soLuong, double gia) {
            this.shoeId = shoeId; this.soLuong = soLuong; this.gia = gia;
        }

        public Long getShoeId() { return shoeId; }
        public void setShoeId(Long shoeId) { this.shoeId = shoeId; }
        public int getSoLuong() { return soLuong; }
        public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
        public double getGia() { return gia; }
        public void setGia(double gia) { this.gia = gia; }
    }
}
