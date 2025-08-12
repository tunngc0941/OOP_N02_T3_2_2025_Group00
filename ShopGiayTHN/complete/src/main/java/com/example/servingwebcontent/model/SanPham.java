package com.example.servingwebcontent.model;

public class SanPham {
    private String name;
    private double price;
    private int size;
    private String imageURL;

    public SanPham(String name, double price, int size, String imageURL) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.imageURL = imageURL;
    }

    public SanPham(String name, double price) {
        this.name = name;
        this.price = price;
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
