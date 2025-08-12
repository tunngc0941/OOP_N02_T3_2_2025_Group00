package com.example.servingwebcontent.model;

public class SanPham {
    private String maSp;    // Mã sản phẩm
    private String name;    // Tên sản phẩm
    private double price;   // Giá
    private int size;       // Kích thước
    private String imageURL; // Link ảnh

    // Constructor mặc định (cần cho JSON mapping)
    public SanPham() {
    }

    // Constructor đầy đủ
    public SanPham(String maSp, String name, double price, int size, String imageURL) {
        this.maSp = maSp;
        this.name = name;
        this.price = price;
        this.size = size;
        this.imageURL = imageURL;
    }

    // Constructor chỉ với tên và giá
    public SanPham(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
